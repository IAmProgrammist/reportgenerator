package pvapersonal.ru.texmodels.documents.list;

import pvapersonal.ru.texmodels.Supplemented;
import pvapersonal.ru.texmodels.TexElement;

import java.io.IOException;

public class List extends TexElement implements Supplemented<List> {
    private boolean isNumbered;

    public enum Arguments {
        ARG_ITEM_CONTENT(0);

        int index;

        Arguments(int index) {
            this.index = index;
        }
    }

    public List(boolean numbered) throws IOException {
        super();
        this.isNumbered = numbered;
    }

    public List(boolean numbered, TexElement... items) {
        super();

        this.isNumbered = numbered;
        addElements(items);
    }

    @Override
    public List addElement(TexElement element) {
        if (element instanceof ListItem) {
            this.childTexElements.add(element);
        } else {
            this.childTexElements.add(new ListItem(element));
        }

        return this;
    }

    @Override
    public List addElements(TexElement... elements) {
        for (TexElement element : elements)
            addElement(element);

        return this;
    }

    @Override
    public String getTexPath() {
        if (this.isNumbered)
            return getClass().getResource("/texpatterns/list/numbered").getPath();
        else
            return getClass().getResource("/texpatterns/list/pointed").getPath();
    }

    @Override
    public int getArgumentsAmount() {
        return Arguments.values().length;
    }

    @Override
    public StringBuilder buildTex() {
        StringBuilder resultTex = new StringBuilder();

        for (TexElement item : this.childTexElements) {
            resultTex = resultTex.append(item.buildTex()).append("\n");
        }

        return new StringBuilder(String.format(this.getCommand().toString(), resultTex));
    }
}
