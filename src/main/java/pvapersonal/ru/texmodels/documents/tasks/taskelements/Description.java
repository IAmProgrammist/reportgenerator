package pvapersonal.ru.texmodels.documents.tasks.taskelements;

import pvapersonal.ru.texmodels.documents.text.Text;

public class Description extends Text {
    public Description(Text text) {
        super(text);
    }

    @Override
    public String getTexPath() {
        return getClass().getResource("/texpatterns/tasklist/tasks/taskelements/description").getPath();
    }

    @Override
    public StringBuilder buildTexSelf() {
        return new StringBuilder(String.format(this.getCommand().toString(), this.commandArguments.get(Arguments.ARG_TEXT_CONTENT.index)));
    }
}
