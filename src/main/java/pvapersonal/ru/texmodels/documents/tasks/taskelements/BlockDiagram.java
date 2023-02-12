package pvapersonal.ru.texmodels.documents.tasks.taskelements;

import pvapersonal.ru.texmodels.TexElement;
import pvapersonal.ru.utils.ContentWriter;

import java.net.URI;

public class BlockDiagram extends TexElement {
    private URI blockDiagram;
    private String taskId;

    public enum Arguments {
        ARG_BLOCK_DIAGRAM_CONTENT(0);

        int index;

        Arguments(int index) {
            this.index = index;
        }
    }

    public BlockDiagram(URI blockDiagram, String taskId) {
        super();

        this.blockDiagram = blockDiagram;
        this.taskId = taskId;
    }

    @Override
    public String getTexPath() {
        return getClass().getResource("/texpatterns/tasklist/tasks/taskelements/blockdiagram").getPath();
    }

    @Override
    public int getArgumentsAmount() {
        return Arguments.values().length;
    }

    @Override
    public StringBuilder buildTex() {
        ContentWriter.get().loadBlockDiagram(blockDiagram, taskId);
        return new StringBuilder(String.format(getCommand().toString(), (ContentWriter.SUBFOLDER_BLOCK_DIAGRAMS) + "/" + taskId));
    }
}
