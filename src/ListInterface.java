import java.util.Comparator;
import java.util.NoSuchElementException;

public interface ListInterface<T> {

    void insertAtFront(T data);


    void insertAtBack(T data);

    T removeFromFront() throws NoSuchElementException;

    T removeFromBack() throws NoSuchElementException;

    boolean isEmpty();

    void sort(Comparator<T> comparator);
}
