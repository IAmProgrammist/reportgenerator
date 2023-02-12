package pvapersonal.ru.texmodels.documents.text;

public class ItalicText extends Text {
    public ItalicText(Text text) {
        super(text);
    }

    @Override
    public String getTexPath() {
        return getClass().getResource("/texpatterns/text/italic").getPath();
    }

    @Override
    public StringBuilder buildTexSelf() {
        return new StringBuilder(String.format(this.getCommand().toString(), this.commandArguments.get(Arguments.ARG_TEXT_CONTENT.index)));
    }
}
