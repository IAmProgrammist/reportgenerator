package pvapersonal.ru.texmodels.documents.tasks.taskelements.code;

import pvapersonal.ru.texmodels.documents.tasks.taskelements.TaskElement;
import pvapersonal.ru.texmodels.documents.text.Text;
import pvapersonal.ru.utils.ContentReader;

import java.io.File;
import java.io.IOException;

public class CodeBlock extends Text {
    String lang;

    public CodeBlock(Text code, String lang) {
        super(code);

        this.lang = lang;
    }

    public CodeBlock(File code, String lang) throws IOException {
        this(new Text(ContentReader.getFileContents(code.getAbsolutePath(), "\n", "\n").toString(), false), lang);
    }

    @Override
    public String getTexPath() {
        return getClass().getResource("/texpatterns/tasklist/tasks/taskelements/code/codeblock").getPath();
    }

    @Override
    public StringBuilder buildTexSelf() {
        return new StringBuilder(String.format(this.getCommand().toString(), this.lang, this.commandArguments.get(Arguments.ARG_TEXT_CONTENT.index)));
    }
}
