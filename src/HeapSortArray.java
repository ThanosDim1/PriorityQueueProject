public class HeapSortArray {
    public City[] heapSort(City[] cities) {
        int length = cities.length;

        // Build heap (rearrange array)
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(cities, length, i);
        }

        // One by one extract an element from the heap
        for (int i = length - 1; i > 0; i--) {
            // Swap the root (maximum element) with the last element
            City temp = cities[0];
            cities[0] = cities[i];
            cities[i] = temp;

            // Heapify the reduced heap
            heapify(cities, i, 0);
        }
        return cities;
    }

    private void heapify(City[] cities, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // Left child
        int right = 2 * i + 2; // Right child

        // If left child is larger than root
        if (left < n && cities[left].compareTo(cities[largest]) > 0) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && cities[right].compareTo(cities[largest]) > 0) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            City swap = cities[i];
            cities[i] = cities[largest];
            cities[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(cities, n, largest);
        }
    }
}
