package pvapersonal.ru.texmodels.documents;

import pvapersonal.ru.texmodels.TexElement;
import pvapersonal.ru.texmodels.documents.text.Text;
import pvapersonal.ru.texmodels.utils.TexBox;

import java.io.IOException;

public class Header extends TexElement {

    public enum Arguments {
        ARG_LAB_NUMBER(0),
        ARG_DISCIPLINE_NAME(1),
        ARG_LAB_NAME(2),
        ARG_LAB_EXECUTOR(3),
        ARG_LAB_TEACHER(4),
        ARG_LAB_REVIEWER(5),
        ARG_LAB_YEAR(6);

        int index;

        Arguments(int index) {
            this.index = index;
        }
    }

    public Header(TexElement labNumber, TexElement labDisciplineName, TexElement labName,
                  TexElement labExecutor, TexElement labTeacher, TexElement labReviewer, TexElement labYear) {
        super();
        this.commandArguments.set(Arguments.ARG_LAB_NUMBER.index, labNumber);
        this.commandArguments.set(Arguments.ARG_DISCIPLINE_NAME.index, labDisciplineName);
        this.commandArguments.set(Arguments.ARG_LAB_NAME.index, labName);
        this.commandArguments.set(Arguments.ARG_LAB_EXECUTOR.index, labExecutor);
        this.commandArguments.set(Arguments.ARG_LAB_TEACHER.index, labTeacher);
        this.commandArguments.set(Arguments.ARG_LAB_REVIEWER.index, labReviewer);
        this.commandArguments.set(Arguments.ARG_LAB_YEAR.index, labYear);

        this.childTexElements.add(new TexBox());
        this.childTexElements.add(new Text());
    }

    @Override
    public String getTexPath() {
        return getClass().getResource("/texpatterns/header").getPath();
    }

    @Override
    public int getArgumentsAmount() {
        return Arguments.values().length;
    }

    @Override
    public StringBuilder buildTex() {
        StringBuilder result = new StringBuilder();

        result = result.append(String.format(this.getCommand().toString(),
                this.commandArguments.get(Arguments.ARG_LAB_NUMBER.index),
                this.commandArguments.get(Arguments.ARG_DISCIPLINE_NAME.index),
                this.commandArguments.get(Arguments.ARG_LAB_NAME.index),
                this.commandArguments.get(Arguments.ARG_LAB_EXECUTOR.index),
                this.commandArguments.get(Arguments.ARG_LAB_TEACHER.index),
                this.commandArguments.get(Arguments.ARG_LAB_REVIEWER.index),
                this.commandArguments.get(Arguments.ARG_LAB_YEAR.index)));

        return result;
    }
}
