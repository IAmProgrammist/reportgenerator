package pvapersonal.ru.utils;

import org.apache.commons.lang3.StringUtils;
import pvapersonal.ru.models.Code;

import java.io.*;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContentReader {
    public static final String COMMAND_FILE_NAME = "/command";
    public static final String DEPENDENCIES_FILE_NAME = "/dependencies";
    public static final String TEX_FILE_NAME = "/main.tex";

    public static StringBuilder getFileContents(String fileName, String delimeter) throws IOException {
        try (Scanner reader = new Scanner(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8))) {
            reader.useDelimiter(delimeter);
            StringBuilder fileContent = new StringBuilder();

            while (reader.hasNext()) {
                fileContent.append(reader.next());
            }

            return fileContent;
        }
    }

    public static StringBuilder getFileContents(String fileName) throws IOException {
        return getFileContents(fileName, "\n");
    }

    public static List<StringBuilder> getFileListContests(String fileName, String delimeter) throws IOException {
        try (Scanner reader = new Scanner(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8))) {
            reader.useDelimiter(delimeter);
            List<StringBuilder> fileContent = new ArrayList<>();

            while (reader.hasNext()) {
                fileContent.add(new StringBuilder(reader.next()));
            }

            return fileContent;
        }
    }

    public static List<StringBuilder> getFileListContests(String fileName) throws IOException {
        return getFileListContests(fileName, "\n");
    }

    public static List<Code> readCodeHeaders(URI codeFile) throws IOException {
        List<Code> codes = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(codeFile)), StandardCharsets.UTF_8))) {
            int input;
            int nestingLevel = 0;
            String comment = "";
            String codeContent = "";

            while (reader.ready()) {
                input = reader.read();

                if (input == '/') {
                    input = reader.read();

                    if (input == '/')
                        comment = reader.readLine().replaceAll("\\s", " ")
                                .replaceAll(" {2,}", " ").trim();
                    else if (input == '*') {
                        comment = "";

                        while (reader.ready()) {
                            input = reader.read();

                            if (input == '*') {
                                input = reader.read();
                                if (input == '/')
                                    break;
                            } else if (input != '\n' && input != '\t') {
                                comment += (char) input;
                            }
                        }

                        comment = comment.replaceAll("\\s", " ")
                                .replaceAll(" {2,}", " ").trim();

                    }

                } else if (input == '{')
                    nestingLevel++;
                else if (input == '}' || input == ';') {
                    if (input == '}') nestingLevel--;

                    if (nestingLevel == 0 && !StringUtils.isEmpty(comment) && !StringUtils.isEmpty(codeContent)) {
                        codeContent = codeContent.replaceAll("\\s", " ")
                                .replaceAll(" {2,}", " ").trim();


                        List<String> params = new ArrayList<>();

                        // Предположим, что мы нашли всё-таки функцию
                        if (codeContent.endsWith(")")) {
                            int codeNestingLevel = 1;
                            String tempParam = "";

                            for (int i = codeContent.length() - 2; i >= 0 && codeNestingLevel != 0; i--) {
                                if (codeContent.charAt(i) == ')') {
                                    codeNestingLevel++;
                                    tempParam = codeContent.charAt(i) + tempParam;
                                } else if (codeContent.charAt(i) == '(') {
                                    codeNestingLevel--;
                                    if (codeNestingLevel != 0) {
                                        tempParam = codeContent.charAt(i) + tempParam;
                                    }
                                } else if (codeContent.charAt(i) == ',' && codeNestingLevel == 1) {
                                    params.add(tempParam.replaceAll("\\s", " ")
                                            .replaceAll(" {2,}", " ").trim());
                                    tempParam = "";
                                } else {
                                    tempParam = codeContent.charAt(i) + tempParam;
                                }
                            }

                            tempParam = tempParam.replaceAll("\\s", " ")
                                    .replaceAll(" {2,}", " ").trim();
                            if (!StringUtils.isBlank(tempParam))
                                params.add(tempParam);

                            List<String> cutParams = new ArrayList<>();

                            for (String param : params) {
                                String cutParameter = "";

                                int paramNestingLevel = 0;
                                for (int i = 0; i < param.length(); i++) {
                                    if (param.charAt(i) == '(')
                                        paramNestingLevel++;
                                    else if (param.charAt(i) == ')') {
                                        paramNestingLevel--;

                                        if (paramNestingLevel == 0 && !StringUtils.isBlank(cutParameter)) {
                                            break;
                                        }
                                    } else if (paramNestingLevel > 0 && param.charAt(i) != '*' &&
                                            !StringUtils.isBlank(Character.toString(param.charAt(i)))) {
                                        cutParameter += param.charAt(i);
                                    }
                                }

                                cutParameter = cutParameter.replaceAll("\\s", " ")
                                        .replaceAll(" {2,}", " ").trim();

                                if (StringUtils.isBlank(cutParameter)) {
                                    String[] keyWords = param.replaceAll("\\*", " ")
                                            .split(" ");
                                    cutParams.add(keyWords[keyWords.length - 1]);
                                } else {
                                    cutParams.add(cutParameter);
                                }
                            }

                            Code code = new Code(codeContent,
                                    comment,
                                    cutParams);

                            codes.add(code);

                            System.out.println(code);
                        }


                        codeContent = "";
                        comment = "";
                    }
                } else if (nestingLevel == 0 && !StringUtils.isEmpty(comment)) {
                    codeContent += (char) input;
                }
            }


        }

        return codes;
    }
}
