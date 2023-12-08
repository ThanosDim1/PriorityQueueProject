import java.util.Scanner;

public class Influenza_k {
    private Scanner scanner;

    public Influenza_k(Scanner scanner) {
        this.scanner = scanner;

        ReadFile readFile = new ReadFile(scanner);
        City[] cities = readFile.getCities();

        System.out.println("Enter the number of cities to compare:");
        int k = scanner.nextInt();

        HeapSortArray heapSort = new HeapSortArray();
        cities = heapSort.heapSort(cities);

        // Display the top k cities with the least amount of cases
        System.out.println("Top " + k + " cities with the least amount of cases:");
        for (int i = 0; i < k; i++) {
            System.out.println(cities[i].getName());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Influenza_k mainObj = new Influenza_k(scanner);
    }
}