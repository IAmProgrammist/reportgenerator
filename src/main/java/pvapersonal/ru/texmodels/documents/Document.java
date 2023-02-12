package pvapersonal.ru.texmodels.documents;

import pvapersonal.ru.texmodels.Supplemented;
import pvapersonal.ru.texmodels.TexElement;
import pvapersonal.ru.utils.UniqueList;

import java.io.IOException;
import java.util.*;

public class Document extends TexElement implements Supplemented<Document> {
    public enum Arguments {
        ARG_DEPENDENCIES(0),
        ARG_COMMANDS(1),
        ARG_DOCUMENT_BODY(2);

        int index;

        Arguments(int index) {
            this.index = index;
        }
    }

    public Document() {
        super();
    }
    public Document(TexElement ...elements) {
        super();

        addElements(elements);
    }

    @Override
    public Document addElement(TexElement element) {
        if (element instanceof Document)
            throw new RuntimeException("You can't add another document in document!");

        this.childTexElements.add(element);

        return this;
    }

    @Override
    public Document addElements(TexElement ...elements) {
        for (TexElement element : elements)
            this.addElement(element);

        return this;
    }

    @Override
    public String getTexPath() {
        return getClass().getResource("/texpatterns/main").getPath();
    }

    @Override
    public int getArgumentsAmount() {
        return Arguments.values().length;
    }

    @Override
    public StringBuilder buildTex() {
        StringBuilder finalResult = new StringBuilder();

        finalResult.append(this.getCommandContent()).append("\n");

        UniqueList<StringBuilder> totalCommands = this.getChildCommandContent();
        UniqueList<StringBuilder> totalDependencies = this.getAllDependencies();

        StringBuilder firstArgument = new StringBuilder();

        for (StringBuilder dependence : totalDependencies) {
            firstArgument.append(dependence).append("\n");
        }

        StringBuilder secondArgument = new StringBuilder();

        for (StringBuilder command : totalCommands) {
            secondArgument.append(command).append("\n");
        }

        StringBuilder thirdArgument = new StringBuilder();

        for (TexElement elem : this.childTexElements) {
            thirdArgument.append(elem.buildTex()).append("\n");
        }

        finalResult.append(String.format(this.getCommand().toString(), firstArgument,
                secondArgument, thirdArgument)).append("\n");

        return finalResult;
    }
}
