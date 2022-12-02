package pvapersonal.ru.texmodels.documents.tasks.taskelements.code;

import pvapersonal.ru.texmodels.documents.text.Text;

public class CodeInsert extends Text {
    String lang;

    public CodeInsert(Text code, String lang) {
        super(code);

        this.lang = lang;
    }

    @Override
    public String getTexPath() {
        return getClass().getResource("/texpatterns/tasklist/tasks/taskelements/code/codeinsert").getPath();
    }

    @Override
    public StringBuilder buildTexSelf() {
        return new StringBuilder(String.format(this.getCommand().toString(), this.lang,
                this.commandArguments.get(Arguments.ARG_TEXT_CONTENT.index)));
    }
}
