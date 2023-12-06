import java.util.Comparator;
import java.util.NoSuchElementException;
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

    /**
     * Inserts the data at the end of the list
     *
     * @param data the inserted item
     */
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

    @Override
    public void sort(Comparator<T> comparator) {
        // No need to sort if list is empty or has a single element
        if (head == null || head == tail)
            return;

        Node<T> newHead = null;
        Node<T> newTail = null;

        while (head != null) {
            // get next item
            Node<T> tmp = head;

            // move head
            head = head.getNext();

            // move swap to new-sorted list
            if (newHead == null) {
                newHead = newTail = tmp;
                tmp.setNext(null);
            } else {
                Node<T> prev = null;
                Node<T> iterator = newHead;

                // iterate newList until we get to a point where our data is smaller or reach the end
                while (iterator != null && comparator.compare(iterator.getData(), tmp.getData()) >= 0) {
                    prev = iterator;
                    iterator = iterator.getNext();
                }

                // reached the point where we should place the node

                // if prev == null then its the head of the list
                if (prev == null)
                    newHead = tmp;
                else
                    prev.setNext(tmp);

                // if iterator == null then its the tail of the list
                tmp.setNext(iterator);
                if(iterator == null)
                    newTail = tmp;
            }
        }

        head = newHead;
        tail = newTail;
    }
}
