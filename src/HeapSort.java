public class HeapSort {
    public List<City> HeapSort(List<City> Cities){

        int lenght=Cities.size;

        for (int i=lenght/2-1; i>=0; i--){
            heapify(Cities,lenght,i);
        }

        for (int i = lenght - 1; i > 0; i--) {
            // Swap the root (maximum element) with the last element
            City temp = Cities.removeFromFront();
            Cities.insertAtFront(Cities.get(i));
            Cities.remove(i);
            Cities.insert(i,temp);

            // Heapify the reduced heap
            heapify(Cities, i, 0);
        }
        return Cities;
    }

    private void heapify(List<City> Cities, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i ; // Left child
        int right = 2 * i + 1; // Right child

        // If left child is larger than root
        if (left < n && Cities.get(left).compareTo(Cities.get(largest)) > 0) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n &&  Cities.get(right).compareTo(Cities.get(largest)) > 0) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            City swap = Cities.get(i);
            Cities.remove(i);
            Cities.insert(i,Cities.get(largest));
            Cities.remove(largest);
            Cities.insert(largest,swap);

            // Recursively heapify the affected sub-tree
            heapify(Cities, n, largest);
        }
    }
}
