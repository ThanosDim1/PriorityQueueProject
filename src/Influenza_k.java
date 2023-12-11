import java.util.Comparator;
import java.util.Scanner;


public class Influenza_k {
    private Scanner scanner;


    public Influenza_k(Scanner scanner) {
        this.scanner = scanner;

        ReadFile readFile = new ReadFile(scanner);
        City[] cities = readFile.getCities();

        System.out.println("Enter the number of cities to compare:");
        int k = scanner.nextInt();
        if (k > readFile.getCityCount()){
            System.out.println("The number you entered exceeds the number of cities");
            return;
        }
        HeapSortArray heapSort = new HeapSortArray();
        cities = heapSort.heapSort(cities);
        for (int i = 0; i < cities.length; i++) {
            System.out.println(cities[i].CalculateDensity());
        }

        PQ pq = new PQ(new Comparator<City>() {
            @Override
            public int compare(City o1, City o2) {
                return o1.compareTo(o2);
            }
        });

        for (int i = 0; i < cities.length; i++) {
            pq.insert(cities[i]);
        }

        // Display the top k cities with the least amount of cases
        System.out.println("Top " + k + " cities with the least amount of cases:");
        for (int i = 0; i < k; i++) {
            System.out.println(pq.getmin().getName());
        }

        

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