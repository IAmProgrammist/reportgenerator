package pvapersonal.ru.texmodels.documents.tasks;

import pvapersonal.ru.texmodels.TexElement;
import pvapersonal.ru.texmodels.documents.tasks.taskelements.*;
import pvapersonal.ru.texmodels.documents.tasks.taskelements.code.CodeBlock;
import pvapersonal.ru.texmodels.documents.text.LinkText;

import java.util.Comparator;

public class CodeforcesTask extends Task {
    public CodeforcesTask(TaskHeader text, BlockDiagram blockDiagram, CodeBlock codeBlock, CodeforcesResult codeforcesResult, RepoLink repoLink) {
        super();

        this.addElements(text, blockDiagram, codeBlock, codeforcesResult, repoLink);
    }

    public CodeforcesTask(TaskHeader text, CodeBlock codeBlock, CodeforcesResult codeforcesResult,  RepoLink repoLink) {
        super();

        this.addElements(text, codeBlock, repoLink, codeforcesResult);
    }

    public CodeforcesTask(TaskHeader text, BlockDiagram blockDiagram, CodeBlock codeBlock, CodeforcesResult codeforcesResult) {
        super();

        this.addElements(text, blockDiagram, codeBlock, codeforcesResult);
    }

    public CodeforcesTask(TaskHeader text, CodeBlock codeBlock, CodeforcesResult codeforcesResult) {
        super();

        this.addElements(text, codeBlock, codeforcesResult);
    }
}
