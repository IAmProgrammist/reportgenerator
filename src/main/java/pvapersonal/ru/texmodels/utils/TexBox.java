package pvapersonal.ru.texmodels.utils;

import pvapersonal.ru.texmodels.TexElement;
import pvapersonal.ru.texmodels.documents.text.Text;

import java.io.IOException;

public class TexBox extends TexElement {
    public enum Arguments {
        ARG_BODY(0);

        int index;

        Arguments(int index) {
            this.index = index;
        }
    }

    public TexBox(TexElement element) {
        super();

        this.commandArguments.set(Arguments.ARG_BODY.index, element);
    }

    public TexBox() {
        super();
        this.commandArguments.set(Arguments.ARG_BODY.index, new Text());
    }

    @Override
    public String getTexPath() {
        return getClass().getResource("/texpatterns/texbox").getPath();
    }

    @Override
    public int getArgumentsAmount() {
        return Arguments.values().length;
    }

    @Override
    public StringBuilder buildTex() {
        return new StringBuilder(String.format(this.getCommand().toString(), this.commandArguments.get(Arguments.ARG_BODY.index).buildTex()));
    }
}
