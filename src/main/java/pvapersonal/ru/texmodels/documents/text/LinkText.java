package pvapersonal.ru.texmodels.documents.text;

import java.net.URL;

public class LinkText extends Text {
    private URL link;

    public LinkText(Text text, URL link) {
        super(text);

        this.link = link;
    }

    @Override
    public String getTexPath() {
        return getClass().getResource("/texpatterns/text/link").getPath();
    }

    @Override
    public StringBuilder buildTexSelf() {
        return new StringBuilder(String.format(this.getCommand().toString(), link.toString(), this.commandArguments.get(Arguments.ARG_TEXT_CONTENT.index).buildTex()));
    }
}
