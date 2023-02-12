package pvapersonal.ru.texmodels;

import pvapersonal.ru.texmodels.documents.tasks.taskelements.BlockDiagram;
import pvapersonal.ru.texmodels.documents.text.Text;
import pvapersonal.ru.utils.ContentReader;
import pvapersonal.ru.utils.UniqueList;

import java.io.IOException;
import java.util.*;

public abstract class TexElement {
    private StringBuilder command = null;
    private StringBuilder commandContent = null;
    private Set<StringBuilder> dependencies = null;
    protected List<TexElement> commandArguments;
    protected List<TexElement> childTexElements;


    public TexElement() {
        this.commandArguments = new ArrayList<>(getArgumentsAmount());

        for (int arg = 0; arg < getArgumentsAmount(); arg++) {
            this.commandArguments.add(null);
        }

        childTexElements = new ArrayList<>();
    }

    public StringBuilder getCommand() {
        try {
            if (this.command == null)
                this.command = ContentReader.getFileContents(getTexPath() + ContentReader.COMMAND_FILE_NAME);
        } catch (IOException ignored) {
        }

        return this.command;
    }

    public StringBuilder getCommandContent() {
        try {
            if (this.commandContent == null)
                this.commandContent = ContentReader.getFileContents(getTexPath() + ContentReader.TEX_FILE_NAME);
        } catch (IOException ignored) {
        }

        return this.commandContent;
    }

    public Set<StringBuilder> getDependencies() {
        try {
            if (this.dependencies == null)
                this.dependencies = new LinkedHashSet<>(ContentReader.getFileListContests(getTexPath() + ContentReader.DEPENDENCIES_FILE_NAME));
        } catch (IOException ignored) {
        }

        return dependencies;
    }

    public abstract String getTexPath();

    public abstract int getArgumentsAmount();

    public UniqueList<StringBuilder> getChildCommandContent() {
        UniqueList<StringBuilder> totalCommands = new UniqueList<>();

        for (TexElement elem : childTexElements) {
            totalCommands.addAll(elem.getAllCommandContent());
        }

        return totalCommands;
    }

    public UniqueList<StringBuilder> getChildDependencies() {
        UniqueList<StringBuilder> totalDependencies = new UniqueList<>();

        for (TexElement elem : childTexElements) {
            totalDependencies.addAll(elem.getAllDependencies());
        }

        return totalDependencies;
    }

    public UniqueList<StringBuilder> getAllCommandContent() {
        UniqueList<StringBuilder> allCommandContent = getChildCommandContent();
        allCommandContent.add(getCommandContent());
        return allCommandContent;
    }

    public UniqueList<StringBuilder> getAllDependencies() {
        UniqueList<StringBuilder> allDependencies = getChildDependencies();
        allDependencies.addAll(getDependencies());
        return allDependencies;
    }

    public abstract StringBuilder buildTex();

    @Override
    public String toString() {
        return buildTex().toString();
    }
}
