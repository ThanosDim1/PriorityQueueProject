import java.util.Scanner;


public class Influenza_k {
    public Influenza_k(Scanner scanner) {

        // Ask the user for the file name
        System.out.println("Enter the name of the text file:");
        String fileName = scanner.nextLine() + ".txt";
        ReadFile readFile = new ReadFile(fileName);
        City[] cities = readFile.getCities();

        System.out.println("Enter the number of cities to compare:");
        int k = scanner.nextInt();
        if (k > readFile.getCityCount()){
            System.out.println("The number you entered exceeds the number of cities");
            return;
        }

        PQ pq = new PQ();
        for (City city : cities) {
            pq.insert(city);
        }

        // Display the top k cities with the least amount of cases
        System.out.println("Top " + k + " cities with the least amount of cases:");
        for (int i = 0; i < k; i++) {
            System.out.println(pq.getmin().getName());
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
        Scanner scanner = new Scanner(System.in);
        Influenza_k mainObj = new Influenza_k(scanner);
    }
}