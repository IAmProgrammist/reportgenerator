package pvapersonal.ru.texmodels.documents.tasks.taskelements;

import pvapersonal.ru.models.Code;
import pvapersonal.ru.texmodels.TexElement;
import pvapersonal.ru.texmodels.documents.tasks.taskelements.code.CodeInsert;
import pvapersonal.ru.texmodels.documents.text.Text;

import java.net.URI;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Specification extends TexElement {
    public enum Arguments {
        ARG_HEADER(0),
        ARG_SPEC_DESCRIPTION(1);

        int index;

        Arguments(int index) {
            this.index = index;
        }
    }

    public Specification(Code code) {
        super();

        //TODO: hardcoded language should'a fix it!
        this.commandArguments.set(Arguments.ARG_HEADER.index, new CodeInsert(new Text(code.getHeader(), false), "C"));

        Text spec = new Text("");

        String specText = " " + code.getSpec() + " ";
        boolean foundAny;
        boolean foundAtLeast = false;

        do {
            foundAny = false;

            String minIndexParam = "";
            int minIndex = specText.length();

            for (String parameter : code.getParameters()) {
                Pattern pattern = Pattern.compile(String.format("(?=((?!([a-z]|[A-Z]|[0-9]|_)).%s(?!([a-z]|[A-Z]|[0-9]|_)).))", parameter));
                Matcher matcher = pattern.matcher(specText);
                if (matcher.find()){
                    int position = matcher.start();

                    if (position < minIndex) {
                        minIndex = position;
                        minIndexParam = parameter;
                        foundAny = true;
                        foundAtLeast = true;
                    }
                }
            }

            if (foundAny) {
                spec.addElement(new Text(specText.substring(0, minIndex + 1)))
                    .addElement(new CodeInsert(new Text(minIndexParam, false), "C"));

                specText = specText.substring(Math.min(minIndex + 1 + minIndexParam.length(), specText.length()));
            }
        } while (foundAny);

        if (!foundAtLeast)
            spec.addElement(new Text(specText));

        this.commandArguments.set(Arguments.ARG_SPEC_DESCRIPTION.index, spec);

        this.childTexElements.add(new CodeInsert(new Text("", false), "C"));
    }

    @Override
    public String getTexPath() {
        return getClass().getResource("/texpatterns/tasklist/tasks/taskelements/spec").getPath();
    }

    @Override
    public int getArgumentsAmount() {
        return Arguments.values().length;
    }

    @Override
    public StringBuilder buildTex() {
        return new StringBuilder(String.format(getCommand().toString(),
                                               this.commandArguments.get(Arguments.ARG_HEADER.index).toString().trim(),
                                               this.commandArguments.get(Arguments.ARG_SPEC_DESCRIPTION.index).toString().trim()));
    }
}
