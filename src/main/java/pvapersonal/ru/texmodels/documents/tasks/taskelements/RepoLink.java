package pvapersonal.ru.texmodels.documents.tasks.taskelements;

import pvapersonal.ru.texmodels.documents.text.LinkText;
import pvapersonal.ru.texmodels.documents.text.Text;
import pvapersonal.ru.texmodels.documents.text.UnderlineText;

import java.net.URL;

public class RepoLink extends LinkText {

    public RepoLink(URL link) {
        super(new UnderlineText(new Text("Ссылка на репозиторий")), link);
    }
}
