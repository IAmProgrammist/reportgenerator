package pvapersonal.ru.texmodels.documents;

import pvapersonal.ru.texmodels.TexElement;
import pvapersonal.ru.texmodels.documents.text.Text;

import java.io.IOException;

public class Content extends TexElement {

    public enum Arguments {
        ARG_LAB_NUMBER(0),
        ARG_LAB_CONTENTS(1),
        ARG_LAB_THEME(2),
        ARG_LAB_TARGET(3);

        int index;

        Arguments(int index) {
            this.index = index;
        }
    }

    public Content(TexElement labNumber, TexElement labContents, TexElement labTheme, TexElement labTarget) {
        super();
        this.commandArguments.set(Arguments.ARG_LAB_NUMBER.index, labNumber);
        this.commandArguments.set(Arguments.ARG_LAB_CONTENTS.index, labContents);
        this.commandArguments.set(Arguments.ARG_LAB_THEME.index, labTheme);
        this.commandArguments.set(Arguments.ARG_LAB_TARGET.index, labTarget);

        this.childTexElements.add(new Text());
    }

    @Override
    public String getTexPath() {
        return getClass().getResource("/texpatterns/content").getPath();
    }

    @Override
    public int getArgumentsAmount() {
        return Arguments.values().length;
    }

    @Override
    public StringBuilder buildTex() {
        StringBuilder result = new StringBuilder();

        result = result.append(String.format(this.getCommand().toString(),
                this.commandArguments.get(Arguments.ARG_LAB_NUMBER.index),
                this.commandArguments.get(Arguments.ARG_LAB_CONTENTS.index),
                this.commandArguments.get(Arguments.ARG_LAB_THEME.index),
                this.commandArguments.get(Arguments.ARG_LAB_TARGET.index)));

        return result;
    }
}
