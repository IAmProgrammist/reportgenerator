package pvapersonal.ru.texmodels.documents.tasks.taskelements;

import pvapersonal.ru.texmodels.TexElement;
import pvapersonal.ru.utils.ContentWriter;

import java.net.URI;

public class CodeforcesResult extends TexElement {
    private URI codeforcesResult;
    private String taskId;

    public enum Arguments {
        ARG_CODEFORCES_RESULT_CONTENT(0);

        int index;

        Arguments(int index) {
            this.index = index;
        }
    }

    public CodeforcesResult(URI codeforcesResult, String taskId) {
        super();

        this.codeforcesResult = codeforcesResult;
        this.taskId = taskId;
    }

    @Override
    public String getTexPath() {
        return getClass().getResource("/texpatterns/tasklist/tasks/taskelements/codeforcesresult").getPath();
    }

    @Override
    public int getArgumentsAmount() {
        return BlockDiagram.Arguments.values().length;
    }

    @Override
    public StringBuilder buildTex() {
        ContentWriter.get().loadCodeforcesResult(codeforcesResult, taskId);
        return new StringBuilder(String.format(getCommand().toString(), (ContentWriter.SUBFOLDER_CODEFORCE_RESULTS) + "/" + taskId));
    }
}
