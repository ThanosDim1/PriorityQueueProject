import java.util.Scanner;

public class Influenza_k {
    public Influenza_k(int k,String filePath) {
        ReadFile readFile = new ReadFile(filePath, k);
        City[] cities = readFile.getCities();

        if (k > readFile.getCityCount()) {
            System.out.println("The number you entered exceeds the number of cities");
            return;
        }

        HeapSortArray heapSort = new HeapSortArray();
        cities = heapSort.heapSort(cities);

        // Display the top k cities with the least amount of cases
        System.out.println("Top " + k + " cities with the least amount of cases:");
        for (int i = 0; i < k; i++) {
            System.out.println(cities[i].getName());
        }
    }

    public static void main(String[] args) {

        // Check if the correct number of command-line arguments is provided
        if (args.length != 2) {
            System.out.println("Usage: java Influenza_k <k> <filepath>");
            System.exit(1); // Exit the program with an error code
        }
        int k = Integer.parseInt(args[0]);
        String filePath = args[1];

        // Create an instance of Influenza_k with the provided arguments\
        Influenza_k influenza_k = new Influenza_k(k, filePath);
    }
}
