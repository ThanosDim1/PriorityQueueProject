import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;

public class List<T> implements ListInterface<T> {
    private Node<T> head = null;
    private Node<T> tail = null;

    public List() {
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void sort(Comparator<T> comparator) {

    }

    @Override
    public void insertAtFront(T data) {
        Node<T> n = new Node<>(data);

        if (isEmpty()) {
            head = n;
            tail = n;
        } else {
            n.setNext(head);
            head = n;
        }
    }

    @Override
    public void insertAtBack(T data) {
        Node<T> n = new Node<>(data);

        if (isEmpty()) {
            head = n;
            tail = n;
        } else {
            tail.setNext(n);
            tail = n;
        }
    }

    @Override
    public T removeFromFront() throws NoSuchElementException {
        if (isEmpty())
            throw new NoSuchElementException();

        T data = head.getData();

        if (head == tail)
            head = tail = null;
        else
            head = head.getNext();

        return data;
    }


    @Override
    public T removeFromBack() throws NoSuchElementException {
        if (isEmpty())
            throw new NoSuchElementException();

        T data = tail.getData();

        if (head == tail)
            head = tail = null;
        else {
            Node<T> iterator = head;
            while (iterator.getNext() != tail)
                iterator = iterator.getNext();

            iterator.setNext(null);
            tail = iterator;
        }

        return data;
    }


    @Override
    public String toString() {
        if (isEmpty()) {
            return "List is empty :(";
        }

        Node current = head;

        StringBuilder ret = new StringBuilder();

        // while not at end of list, output current node's data
        ret.append("\n\nHEAD -> ");

        while (current != null) {
            ret.append(current.data.toString());

            if (current.getNext() != null)
                ret.append(" -> ");

            current = current.next;
        }

        ret.append(" <- TAIL");

        return ret.toString();
    }

    public City compare(City city1,City city2) {
        int nameComparison = city1.getName().compareTo(city2.getName());

        if (city1.getDensity() == city2.getDensity()) {
            if (Objects.equals(city1.getName(), city2.getName())) {
                return (city1.getID() > city2.getID()) ? city2 : city1;
            } else {
                return (nameComparison < 0) ? city1 : city2;
            }
        } else {
            return (city1.getDensity() > city2.getDensity()) ? city2 : city1;
        }
    }
}
