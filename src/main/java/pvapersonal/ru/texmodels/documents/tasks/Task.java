package pvapersonal.ru.texmodels.documents.tasks;

import pvapersonal.ru.texmodels.Supplemented;
import pvapersonal.ru.texmodels.TexElement;

import java.util.List;

public class Task extends TexElement implements Supplemented<TexElement> {
    @Override
    public String getTexPath() {
        return getClass().getResource("/texpatterns/tasklist/tasks/task").getPath();
    }

    @Override
    public int getArgumentsAmount() {
        return 0;
    }

    @Override
    public TexElement addElement(TexElement element) {
        this.childTexElements.add(element);
        this.commandArguments.add(element);

        return this;
    }

    @Override
    public TexElement addElements(TexElement... elements) {
        this.childTexElements.addAll(List.of(elements));
        this.commandArguments.addAll(List.of(elements));

        return this;
    }

    @Override
    public StringBuilder buildTex() {
        StringBuilder finalResult = new StringBuilder();

        for(int i = 1; i < this.commandArguments.size(); i++)
            finalResult.append(this.commandArguments.get(i).buildTex() + "\n");

        return new StringBuilder(String.format(getCommand().toString(), this.commandArguments.get(0),
                finalResult));
    }
}
