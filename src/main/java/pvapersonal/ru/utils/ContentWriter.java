package pvapersonal.ru.utils;

import pvapersonal.ru.texmodels.TexElement;

import java.io.*;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

public class ContentWriter {
    private static ContentWriter writer;

    public static ContentWriter init(String outputFolder) {
        new File(outputFolder + SUBFOLDER_IMAGES).mkdirs();
        new File(outputFolder + SUBFOLDER_IMAGES_BLOCK_DIAGRAMS).mkdirs();
        new File(outputFolder + SUBFOLDER_IMAGES_CODEFORCE_RESULTS).mkdirs();
        new File(outputFolder + SUBFOLDER_FONTS).mkdirs();
        return writer = new ContentWriter(outputFolder);
    }

    public static ContentWriter get() {
        if (writer == null)
            throw new RuntimeException("ContentWriter is not initialized!");

        return writer;
    }

    private static String outputFolder;
    public static final String SUBFOLDER_IMAGES = "/images";
    public static final String SUBFOLDER_BLOCK_DIAGRAMS = "/blockdiagrams";
    public static final String SUBFOLDER_IMAGES_BLOCK_DIAGRAMS = SUBFOLDER_IMAGES + SUBFOLDER_BLOCK_DIAGRAMS;
    public static final String SUBFOLDER_CODEFORCE_RESULTS = "/codeforceresults";
    public static final String SUBFOLDER_IMAGES_CODEFORCE_RESULTS = SUBFOLDER_IMAGES + SUBFOLDER_CODEFORCE_RESULTS;
    public static final String SUBFOLDER_FONTS = "/fonts";

    private ContentWriter(String outputFolder) {
        this.outputFolder = outputFolder;
    }

    public void writeTexFile(TexElement element, String file) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFolder + "/" + file),
                StandardCharsets.UTF_8))) {
            writer.write(element.toString());
        }
    }

    public String getOutputFolder() {
        return outputFolder;
    }

    public void setOutputFolder(String outputFolder) {
        ContentWriter.outputFolder = outputFolder;
    }

    public void copyFileToWorkingSubfolder(File copyFile, String subFolder) {
        try {
            File toFile = new File(outputFolder + subFolder + "." + getExtensionByStringHandling(copyFile.toString()).get());
            new File(toFile.getParent()).mkdirs();
            toFile.createNewFile();
            Files.copy(copyFile.toPath(), toFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadBlockDiagram(URI blockDiagram, String fileName) {
        copyFileToWorkingSubfolder(new File(blockDiagram), SUBFOLDER_IMAGES_BLOCK_DIAGRAMS + "/" + fileName);
    }

    public void loadCodeforcesResult(URI codeforcesResult, String fileName) {
        copyFileToWorkingSubfolder(new File(codeforcesResult), SUBFOLDER_IMAGES_CODEFORCE_RESULTS + "/" + fileName);
    }

    public Optional<String> getExtensionByStringHandling(String filename) {
        return Optional.ofNullable(filename)
                .filter(f -> f.contains("."))
                .map(f -> f.substring(filename.lastIndexOf(".") + 1));
    }
}
