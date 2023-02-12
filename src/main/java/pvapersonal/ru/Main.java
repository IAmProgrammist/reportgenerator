package pvapersonal.ru;

import com.sun.source.tree.YieldTree;
import pvapersonal.ru.models.Code;
import pvapersonal.ru.texmodels.documents.Content;
import pvapersonal.ru.texmodels.documents.Document;
import pvapersonal.ru.texmodels.documents.Header;
import pvapersonal.ru.texmodels.documents.list.List;
import pvapersonal.ru.texmodels.documents.tasks.CodeforcesTask;
import pvapersonal.ru.texmodels.documents.tasks.Task;
import pvapersonal.ru.texmodels.documents.tasks.taskelements.*;
import pvapersonal.ru.texmodels.documents.tasks.taskelements.code.CodeBlock;
import pvapersonal.ru.texmodels.documents.text.BoldText;
import pvapersonal.ru.texmodels.documents.text.Text;
import pvapersonal.ru.utils.ContentReader;
import pvapersonal.ru.utils.ContentWriter;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {
        ContentWriter.init("/Users/vlad/Desktop/Лабы/1 курс/ОП и ОА/19.10/Отчёт");

        Document document = new Document(
                new Header(
                        new Text("10"),
                        new Text("Основы программирования"),
                        new Text("Бинарный поиск"),
                        new Text("ст. группы ПВ-223").addElement(new Text("\\\\", false)).addElement(new Text("Пахомов Владислав Андреевич")),
                        new Text("Притчин Иван Сергеевич\\\\ Черников Сергей Викторович", false),
                        new Text("ст. группы ПВ-223\\\\ Голуцкий Георгий Юрьевич", false),
                        new Text("2023")),
                new Content(
                        new Text("10\\\\Вариант 1", false),
                        new List(false,
                                new Text("Тема лабораторной работы"),
                                new Text("Цель лабораторной работы"),
                                new Text("Решения задач"),
                                new List(false,
                                        new Text("Название задачи."),
                                        new Text("Исходный код."),
                                        new Text("Вердикт тестирующей системы."),
                                        new Text("Задачи с двумя звёздочками не являются обязательными.")),
                                new Text("Работа над ошибками (код-ревью)"),
                                new Text("Вывод по работе")),
                        new Text("Бинарный поиск"),
                        new Text("получение навыков использования алгоритмов бинарного поиска для решения задач оптимизации.")),
                new List(true,
                        // Задача номер 1
                        new Task().addElements(
                                new TaskHeader(
                                        new Text("Двоичный поиск"),
                                        new URL("https://codeforces.com/edu/course/2/lesson/6/1/practice/contest/283911/problem/A")),
                                new CodeBlock(new File("/Users/vlad/Desktop/C/programming-and-algorithmization-basics/lab10/1.c"),
                                        "C"),
                                new CodeforcesResult(
                                        new File("/Users/vlad/Desktop/Лабы/1 курс/ОП и ОА/19.10/Результаты Codeforces/1.png").toURI(),
                                        "283911A"
                                ),
                                new RepoLink(new URL("https://github.com/IAmProgrammist/programming-and-algorithmization-basics/blob/c/lab10/1.c"))

                        ),
                        // Задача номер 4
                        new Task().addElements(
                                new TaskHeader(
                                        new Text("Быстрый поиск в массиве"),
                                        new URL("https://codeforces.com/edu/course/2/lesson/6/1/practice/contest/283911/problem/D")),
                                new CodeBlock(new File("/Users/vlad/Desktop/C/programming-and-algorithmization-basics/lab10/4.c"),
                                        "C"),
                                new CodeforcesResult(
                                        new File("/Users/vlad/Desktop/Лабы/1 курс/ОП и ОА/19.10/Результаты Codeforces/4.png").toURI(),
                                        "283911D"
                                ),
                                new RepoLink(new URL("https://github.com/IAmProgrammist/programming-and-algorithmization-basics/blob/c/lab10/4.c"))

                        ),
                        // Задача номер 6
                        new Task().addElements(
                                new TaskHeader(
                                        new Text("Очень Легкая Задача"),
                                        new URL("https://codeforces.com/edu/course/2/lesson/6/2/practice/contest/283932/problem/C")),
                                new CodeBlock(new File("/Users/vlad/Desktop/C/programming-and-algorithmization-basics/lab10/6.c"),
                                        "C"),
                                new CodeforcesResult(
                                        new File("/Users/vlad/Desktop/Лабы/1 курс/ОП и ОА/19.10/Результаты Codeforces/6.png").toURI(),
                                        "283932A"
                                ),
                                new RepoLink(new URL("https://github.com/IAmProgrammist/programming-and-algorithmization-basics/blob/c/lab10/6.c"))

                        ),
                        // Задача номер 12
                        new Task().addElements(
                                new TaskHeader(
                                        new Text("Модные числа"),
                                        new URL("https://codeforces.com/problemset/problem/192/A")),
                                new CodeBlock(new File("/Users/vlad/Desktop/C/programming-and-algorithmization-basics/lab10/12.c"),
                                        "C"),
                                new CodeforcesResult(
                                        new File("/Users/vlad/Desktop/Лабы/1 курс/ОП и ОА/19.10/Результаты Codeforces/12.png").toURI(),
                                        "192A"
                                ),
                                new RepoLink(new URL("https://github.com/IAmProgrammist/programming-and-algorithmization-basics/blob/c/lab10/12.c"))

                        ),
                        // Задача номер 14
                        new Task().addElements(
                                new TaskHeader(
                                        new Text("** Чемпионат мира"),
                                        new URL("https://codeforces.com/contest/996/problem/B")),
                                new CodeBlock(new File("/Users/vlad/Desktop/C/programming-and-algorithmization-basics/lab10/14.c"),
                                        "C"),
                                new CodeforcesResult(
                                        new File("/Users/vlad/Desktop/Лабы/1 курс/ОП и ОА/19.10/Результаты Codeforces/14.png").toURI(),
                                        "996B"
                                ),
                                new RepoLink(new URL("https://github.com/IAmProgrammist/programming-and-algorithmization-basics/blob/c/lab10/14.c"))

                        ),
                        // Задача номер 15
                        new Task().addElements(
                                new TaskHeader(
                                        new Text("** Максимальная медиана"),
                                        new URL("https://codeforces.com/problemset/problem/1201/C")),
                                new CodeBlock(new File("/Users/vlad/Desktop/C/programming-and-algorithmization-basics/lab10/15.c"),
                                        "C"),
                                new CodeforcesResult(
                                        new File("/Users/vlad/Desktop/Лабы/1 курс/ОП и ОА/19.10/Результаты Codeforces/15.png").toURI(),
                                        "1201С"
                                ),
                                new RepoLink(new URL("https://github.com/IAmProgrammist/programming-and-algorithmization-basics/blob/c/lab10/15.c"))

                        ),
                        // Задача номер 16
                        new Task().addElements(
                                new TaskHeader(
                                        new Text("** Разделение массива"),
                                        new URL("https://codeforces.com/edu/course/2/lesson/6/3/practice/contest/285083/problem/B")),
                                new CodeBlock(new File("/Users/vlad/Desktop/C/programming-and-algorithmization-basics/lab10/16.c"),
                                        "C"),
                                new CodeforcesResult(
                                        new File("/Users/vlad/Desktop/Лабы/1 курс/ОП и ОА/19.10/Результаты Codeforces/16.png").toURI(),
                                        "285083B"
                                ),
                                new RepoLink(new URL("https://github.com/IAmProgrammist/programming-and-algorithmization-basics/blob/c/lab10/16.c"))

                        ),
                        // Задача номер 17
                        new Task().addElements(
                                new TaskHeader(
                                        new Text("** Гамбургеры"),
                                        new URL("https://codeforces.com/edu/course/2/lesson/6/2/practice/contest/283932/problem/H")),
                                new CodeBlock(new File("/Users/vlad/Desktop/C/programming-and-algorithmization-basics/lab10/17.c"),
                                        "C"),
                                new CodeforcesResult(
                                        new File("/Users/vlad/Desktop/Лабы/1 курс/ОП и ОА/19.10/Результаты Codeforces/17.png").toURI(),
                                        "283932H"
                                ),
                                new RepoLink(new URL("https://github.com/IAmProgrammist/programming-and-algorithmization-basics/blob/c/lab10/17.c"))

                        ),
                        // Задача номер 18
                        new Task().addElements(
                                new TaskHeader(
                                        new Text("** Slay the Dragon"),
                                        new URL("https://codeforces.com/problemset/problem/1574/C")),
                                new CodeBlock(new File("/Users/vlad/Desktop/C/programming-and-algorithmization-basics/lab10/18.c"),
                                        "C"),
                                new CodeforcesResult(
                                        new File("/Users/vlad/Desktop/Лабы/1 курс/ОП и ОА/19.10/Результаты Codeforces/18.png").toURI(),
                                        "1574C"
                                ),
                                new RepoLink(new URL("https://github.com/IAmProgrammist/programming-and-algorithmization-basics/blob/c/lab10/18.c"))

                        ),
                        // Задача номер 19
                        new Task().addElements(
                                new TaskHeader(
                                        new Text("** Детский праздник"),
                                        new URL("https://codeforces.com/edu/course/2/lesson/6/2/practice/contest/283932/problem/D")),
                                new CodeBlock(new File("/Users/vlad/Desktop/C/programming-and-algorithmization-basics/lab10/19.c"),
                                        "C"),
                                new CodeforcesResult(
                                        new File("/Users/vlad/Desktop/Лабы/1 курс/ОП и ОА/19.10/Результаты Codeforces/19.png").toURI(),
                                        "283932D"
                                ),
                                new RepoLink(new URL("https://github.com/IAmProgrammist/programming-and-algorithmization-basics/blob/c/lab10/19.c"))

                        )
                ),
                new Text().addElements(new BoldText(new Text("Вывод: "))), new Text("в ходе лабораторной работы получили навыки использования алгоритмов бинарного поиска для решения задач оптимизации."));

        ContentWriter.get().writeTexFile(document, "outfile.tex");
    }
}