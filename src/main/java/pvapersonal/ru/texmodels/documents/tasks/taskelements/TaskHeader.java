package pvapersonal.ru.texmodels.documents.tasks.taskelements;

import pvapersonal.ru.texmodels.documents.text.BoldText;
import pvapersonal.ru.texmodels.documents.text.LinkText;
import pvapersonal.ru.texmodels.documents.text.Text;

import java.net.MalformedURLException;
import java.net.URL;

public class TaskHeader extends LinkText {
    public TaskHeader(Text text, URL link) {
        super(new BoldText(text), link);
    }

    public TaskHeader(Text text) throws MalformedURLException {
        super(new BoldText(text), new URL(""));
    }
}
