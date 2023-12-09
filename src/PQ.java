import java.util.Comparator;

public class PQ implements PQInterface,Comparator<City>{
    private City[] heap;
    private int size;
    private final Comparator<City> comparator;

    public PQ(Comparator<City> comparator) {
        this.heap = new City[DEFAULT_CAPACITY + 1];
        this.size = 0;
        this.comparator = comparator;
    }
    @Override
    public int size(){
        return this.size;
    }
    @Override
    public boolean isEmpty(){
        return this.size==0;
    }

    @Override
    public void insert(City item) {
        // Check available space
        if (size == heap.length - 1)
            resize();

        // Place item at the next available position
        heap[++size] = item;

        // Let the newly added item swim
        swim(size);
    }

    @Override
    public City min() {
        // Ensure not empty
        if (size == 0)
            return null;

        // return root without removing
        return heap[1];
    }

    @Override
    public City getmin() {
        // Ensure not empty
        if (size == 0)
            return null;

        // Keep a reference to the root item
        City root = heap[1];

        // Replace root item with the one at rightmost leaf
        heap[1] = heap[size];
        size--;

        // Dispose the rightmost leaf
        // Sink the new root element
        sink(1);

        // Return the int removed
        return root;
    }

    @Override
    public City remove(int id) {
        // Find the index of the item with the given ID
        int index = -1;
        for (int i = 1; i <= size; i++) {
            if (heap[i].getID() == id) {
                index = i;
                break;
            }
        }

        // If the item with the given ID is not found, return null
        if (index == -1) {
            return null;
        }

        // Keep a reference to the removed item
        City removedCity = heap[index];

        // Swap the item with the last element
        heap[index] = heap[size];
        size--;

        // Check if the removal affected the heap's order
        // Sink or swim the element based on its new position
        if (index > 1 && comparator.compare(heap[index], heap[index / 2]) > 0) {
            swim(index);
        } else {
            sink(index);
        }

        // Return the removed item
        return removedCity;
    }
    @Override
    public void swim(int i) {
        // if i is root (i==1) return
        if (i == 1)
            return;

        // find parent
        int parent = i / 2;

        // compare parent with child i
        while (i != 1 && comparator.compare(heap[i], heap[parent]) > 0) {
            City parentCity = heap[i];
            heap[i]=heap[parent];
            heap[parent] = parentCity;
            i = parent;
            parent = i / 2;
        }
    }
    @Override
    public void sink(int i) {
        // determine left, right child
        int left = 2 * i;
        int right = left + 1;

        // if 2*i > size, node i is a leaf return
        if (left > size)
            return;

        // while haven't reached the leafs
        while (left <= size) {
            // Determine the largest child of node i
            int min = left;
            if (right <= size) {
                if (comparator.compare(heap[left], heap[right]) > 0)
                    min = right;
            }

            // If the heap condition holds, stop. Else swap and go on.
            // child smaller than parent
            if (comparator.compare(heap[i], heap[min]) < 0)
                return;
            else {
                City minCity = heap [i];
                heap[i] = heap[min];
                heap[min] = minCity;
                i = min;
                left = i * 2;
                right = left + 1;
            }
        }
    }

    @Override
    public void resize() {
        City[] newHeap = new City[heap.length + AUTOGROW_SIZE];

        // copy array
        //(notice: in the priority queue, elements are located in the array slots with positions in [1, size])
        for (int i = 0; i <= size; i++) {
            newHeap[i] = heap[i];
        }
        heap = newHeap;
    }

    @Override
    public int compare(City city1,City city2) {
        int densityComparison = Double.compare(city1.CalculateDensity(), city2.CalculateDensity());

        if (densityComparison == 0) {
            int nameComparison = city1.getName().compareTo(city2.getName());

            if (nameComparison == 0) {
                return Integer.compare(city1.getID(), city2.getID());
            } else {
                return nameComparison;
            }
        } else {
            return densityComparison;
        }
    }
}