import java.util.NoSuchElementException;

public class List<T> implements ListInterface<T> {
    private Node<T> head = null;
    private Node<T> tail = null;
    public int size=0;

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
            size=1;
            head = n;
            tail = n;
        } else {
            size++;
            n.setNext(head);
            head = n;
        }
    }

    @Override
    public void insertAtBack(T data) {
        Node<T> n = new Node<>(data);

        if (isEmpty()) {
            size=1;
            head = n;
            tail = n;
        } else {
            size++;
            tail.setNext(n);
            tail = n;
        }
    }

    @Override
    public T removeFromFront() throws NoSuchElementException {
        if (isEmpty())
            throw new NoSuchElementException();

        T data = head.getData();

        if (head == tail) {
            head = tail = null;
            size=0;
        }else {
            head = head.getNext();
            size-=1;
        }
        return data;
    }

    @Override
    public T removeFromBack() throws NoSuchElementException {
        if (isEmpty())
            throw new NoSuchElementException();

        T data = tail.getData();

        if (head == tail) {
            head = tail = null;
            size = 0;
        }else {
            Node<T> iterator = head;
            while (iterator.getNext() != tail)
                iterator = iterator.getNext();

            iterator.setNext(null);
            tail = iterator;
            size-=1;
        }

        return data;
    }

    @Override
    public T getFirst() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        return head.getData();
    }

    @Override
    public T getLast() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        return tail.getData();
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        return current.getData();
    }

    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }

        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }

        T data;

        if (index == 0) {
            // Remove from the front
            data = removeFromFront();
        } else if (index == size ) {
            // Remove from the back
            data = removeFromBack();
        } else {
            // Remove from the middle
            Node<T> previous = head;
            for (int i = 0; i < index - 1; i++) {
                previous = previous.getNext();
            }

            data = previous.getNext().getData();
            previous.setNext(previous.getNext().getNext());
            size--;
        }

        return data;
    }

    @Override
    public void insert(int index, T data) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }

        Node<T> newNode = new Node<>(data);

        if (index == 0) {
            // Insert at the front
            insertAtFront(data);
        } else if (index == size) {
            // Insert at the back
            insertAtBack(data);
        } else {
            // Insert in the middle
            Node<T> previous = head;
            for (int i = 0; i < index - 1; i++) {
                previous = previous.getNext();
            }

            newNode.setNext(previous.getNext());
            previous.setNext(newNode);
            size++;
        }
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "List is empty :(";
        }

        Node<T> current = head;

        StringBuilder ret = new StringBuilder();

        // while not at end of list, output current node's data
        ret.append("\n\nHEAD -> ");

        while (current != null) {
            if (current.data instanceof City) {
                // Assuming City has a meaningful toString() method
                ret.append(((City) current.data).toString());
            } else {
                ret.append(current.data.toString());
            }

            if (current.getNext() != null) {
                ret.append(" -> ");
            }

            current = current.next;
        }

        ret.append(" <- TAIL");

        return ret.toString();
    }
}
