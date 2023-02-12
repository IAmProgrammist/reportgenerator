package pvapersonal.ru.texmodels.documents.text;

public class BoldText extends Text {
    public BoldText(Text text) {
        super(text);
    }

    @Override
    public String getTexPath() {
        return getClass().getResource("/texpatterns/text/bold").getPath();
    }

    @Override
    public StringBuilder buildTexSelf() {
        return new StringBuilder(String.format(this.getCommand().toString(), this.commandArguments.get(Arguments.ARG_TEXT_CONTENT.index)));
    }
}
