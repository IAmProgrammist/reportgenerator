package pvapersonal.ru.texmodels;

public interface Supplemented<T extends TexElement> {
    public T addElement(TexElement element);

    public T addElements(TexElement ...elements);
}
