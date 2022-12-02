package pvapersonal.ru.texmodels.documents.text;

import pvapersonal.ru.texmodels.Supplemented;
import pvapersonal.ru.texmodels.TexElement;

import java.util.List;
import java.util.regex.Matcher;

public class Text extends TexElement implements Supplemented<Text> {
    public enum Arguments {
        ARG_TEXT_CONTENT(0);

        public int index;

        Arguments(int index) {
            this.index = index;
        }
    }

    private String content;

    public Text(String text, boolean escapeCharacters) {
        super();

        if (escapeCharacters)
            this.content = text.replaceAll("\\\\", "\\\\textbackslash ")
                    .replaceAll("#", "\\\\# ")
                    .replaceAll("\\$", Matcher.quoteReplacement("\\$ "))
                    .replaceAll("%", "\\\\% ")
                    .replaceAll("&", "\\\\& ")
                    .replaceAll("_", "\\\\_ ")
                    .replaceAll("\\{", "\\\\{ ")
                    .replaceAll("}", "\\\\} ")
                    .replaceAll("\\^", Matcher.quoteReplacement("$\\hat{}$ "))
                    .replaceAll("~", Matcher.quoteReplacement("$\\sim{}$ "));
        else
            this.content = text;
    }

    public Text(Text text) {
        super();
        this.content = text.getContent();

        this.commandArguments.set(Arguments.ARG_TEXT_CONTENT.index, text);
    }

    public Text(String text) {
        this(text, true);
    }

    public Text() {
        this("", true);
    }

    public Text(boolean escapeCharacters) {
        this("", escapeCharacters);
    }

    @Override
    public String getTexPath() {
        return getClass().getResource("/texpatterns/text/regular").getPath();
    }

    @Override
    public int getArgumentsAmount() {
        return 1;
    }

    public String getContent() {
        return content;
    }

    @Override
    public Text addElement(TexElement element) {
        this.childTexElements.add(element);

        return this;
    }

    @Override
    public Text addElements(TexElement... elements) {
        this.childTexElements.addAll(List.of(elements));

        return this;
    }

    public StringBuilder buildTexSelf() {
        return new StringBuilder(String.format(this.getCommand().toString(), getContent()));
    }

    @Override
    public StringBuilder buildTex() {
        StringBuilder finalResult = buildTexSelf();

        for (int i = 0; i < this.childTexElements.size(); i++)
            finalResult.append(this.childTexElements.get(i).buildTex());

        return finalResult;
    }
}
