package pvapersonal.ru.texmodels.documents.text;

import java.io.IOException;

public class UnderlineText extends Text {
    public UnderlineText(Text text) {
        super(text);
    }

    @Override
    public String getTexPath() {
        return getClass().getResource("/texpatterns/text/underline").getPath();
    }

    @Override
    public StringBuilder buildTexSelf() {
        return new StringBuilder(String.format(this.getCommand().toString(), this.commandArguments.get(Arguments.ARG_TEXT_CONTENT.index)));
    }
}
