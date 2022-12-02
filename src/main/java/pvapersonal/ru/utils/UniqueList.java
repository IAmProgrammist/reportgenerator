package pvapersonal.ru.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class UniqueList<T> implements Iterable<T> {
    private List<T> data;

    public UniqueList() {
        data = new ArrayList<>();
    }

    public void add(T element) {
        if (element != null) {
            for (T elem : data) {
                if (elem.toString().equals(element.toString()))
                    return;
            }

            data.add(element);
        }
    }

    public void addAll(Collection<T> elements) {
        if (elements != null) {
            for (T element : elements) {
                add(element);
            }
        }
    }

    public void addAll(UniqueList<T> elements) {
        for (T element : elements) {
            add(element);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return data.iterator();
    }
}
