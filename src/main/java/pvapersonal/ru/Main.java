package pvapersonal.ru;

import pvapersonal.ru.models.Code;
import pvapersonal.ru.texmodels.documents.Content;
import pvapersonal.ru.texmodels.documents.Document;
import pvapersonal.ru.texmodels.documents.Header;
import pvapersonal.ru.texmodels.documents.list.List;
import pvapersonal.ru.texmodels.documents.tasks.CodeforcesTask;
import pvapersonal.ru.texmodels.documents.tasks.taskelements.*;
import pvapersonal.ru.texmodels.documents.tasks.taskelements.code.CodeBlock;
import pvapersonal.ru.texmodels.documents.text.Text;
import pvapersonal.ru.utils.ContentReader;
import pvapersonal.ru.utils.ContentWriter;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {
        ContentWriter.init("C:/Users/vladi/Desktop/ws");

        Document document = new Document(
                new Header(
                        new Text("7"),
                        new Text("Основы программирования"),
                        new Text("Побитовые операции"),
                        new Text("ст. группы ПВ-223").addElement(new Text("\\\\")).addElement(new Text("Пахомов Владислав Андреевич")),
                        new Text("Притчин Иван Сергеевич\\\\ Черников Сергей Викторович"),
                        new Text("ст. группы ПВ-223\\\\ Голуцкий Георгий Юрьевич"),
                        new Text("2022")),
                new Content(
                        new Text("7"),
                        new List(false,
                                new Text("Тема лабораторной работы"),
                                new Text("Цель лабораторной работы"),
                                new Text("Решения задач"),
                                new List(false,
                                        new Text("Условие задачи"),
                                        new Text("Тестовые данные"),
                                        new Text("Исходный код функции и её спецификация")),
                                new Text("Работа над ошибками (код-ревью)"),
                                new Text("Вывод по работе")),
                        new Text("Побитовые операции"),
                        new Text("получение навыков работы с побитовыми операциями.")),
                new List(true,
                        new CodeforcesTask(
                                new TaskHeader(
                                        new Text("Минуты до Нового года (1283A)"),
                                        new URL("https://codeforces.com/problemset/problem/1283/A?locale=ru&f0a28=1")),
                                new BlockDiagram(
                                        new File("C:/Users/vladi/Workspace/Лабы/1 курс/ОП и ОА/19.1/Блок-схемы/1283A.png").toURI(),
                                        "1283A"),
                                new CodeBlock(
                                        new Text("#include <stdio.h>\n" +
                                        "\n" +
                                        "#define MINUTES_IN_HOUR 60\n" +
                                        "#define HOURS_IN_DAY 24\n" +
                                        "#define FULL_DAY_IN_MINUTES HOURS_IN_DAY * MINUTES_IN_HOUR\n" +
                                        "\n" +
                                        "int main() {\n" +
                                        "    int t;\n" +
                                        "    scanf(\"%d\", &t);\n" +
                                        "\n" +
                                        "    for (int i = 0; i < t; i++) {\n" +
                                        "        int h, m;\n" +
                                        "        scanf(\"%d %d\", &h, &m);\n" +
                                        "\n" +
                                        "        int minutesTillNewYear = FULL_DAY_IN_MINUTES - (h * MINUTES_IN_HOUR + m);\n" +
                                        "\n" +
                                        "        printf(\"%d\\n\", minutesTillNewYear);\n" +
                                        "    }\n" +
                                        "\n" +
                                        "    return 0;\n" +
                                        "}", false),
                                        "C"),
                                new CodeforcesResult(
                                        new File("C:/Users/vladi/Workspace/Лабы/1 курс/ОП и ОА/19.1/Вердикты/1283A.png").toURI(),
                                        "1283A"
                                ),
                                new RepoLink(new URL("https://github.com/IAmProgrammist/programming-and-algorithmization-basics/blob/c/lab1/1283A.c"))
                                )));

        java.util.List<Code> codeList = ContentReader.readCodeHeaders(new File("C:\\Users\\vladi\\Workspace\\C\\programming-and-algorithmization-basics\\lab8\\sharedfuncs\\src\\stupidfunc.c").toURI());

        for(Code c : codeList) {
            document.addElement(new Specification(c));
        }

        document.addElement(new CodeBlock(new Text(
                "// n somecomment n,n^,n,n,n,n%n<n$n# n\\n#n$n%n&n_  n{n}n^_ endo:n\n" +
                        "void stupidfunc(int n) {\n" +
                        "\n" +
                        "}", false
        ), "C"));

        ContentWriter.get().writeTexFile(document, "outfile.txt");

    }
}