package pvapersonal.ru.texmodels.documents.list;

import pvapersonal.ru.texmodels.TexElement;

import java.io.IOException;

public class ListItem extends TexElement {

    public enum Arguments {
        ARG_ITEM_CONTENT(0);

        int index;

        Arguments(int index) {
            this.index = index;
        }
    }

    public ListItem(TexElement item) {
        super();

        this.commandArguments.set(Arguments.ARG_ITEM_CONTENT.index, item);
        this.childTexElements.add(item);
    }

    @Override
    public String getTexPath() {
        return getClass().getResource("/texpatterns/list/listitem").getPath();
    }

    @Override
    public int getArgumentsAmount() {
        return Arguments.values().length;
    }

    @Override
    public StringBuilder buildTex() {
        TexElement item = this.commandArguments.get(Arguments.ARG_ITEM_CONTENT.index);

        if (item instanceof List)
            return item.buildTex();

        return new StringBuilder(String.format(this.getCommand().toString(), this.commandArguments.get(Arguments.ARG_ITEM_CONTENT.index).buildTex()));
    }
}
