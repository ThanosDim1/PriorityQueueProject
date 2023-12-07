import java.util.Comparator;
import java.util.NoSuchElementException;

public interface ListInterface<T> {

    void insertAtFront(T data);

    void insertAtBack(T data);

    T removeFromFront() throws NoSuchElementException;

    T removeFromBack() throws NoSuchElementException;

    boolean isEmpty();

    T getFirst() throws NoSuchElementException;
    T getLast() throws NoSuchElementException;
    T get(int index) throws IndexOutOfBoundsException;
    T remove(int index) throws IndexOutOfBoundsException;
    void insert(int index, T data) throws IndexOutOfBoundsException;
}
