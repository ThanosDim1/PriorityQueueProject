import java.util.Scanner;

public class DynamicInfluenza_k_withPQ {
    public DynamicInfluenza_k_withPQ(Scanner scanner) {
        // Ask the user for the file name
        System.out.println("Enter the whole path of the text file:");
        String fileName = scanner.nextLine();

        // Create an instance of ReadFile to read cities from the file
        ReadFile readFile = new ReadFile(fileName);

        // Create an instance of PQ
        PQ priorityQueue = new PQ();

        System.out.println("Enter the number of cities to compare:");
        int k = scanner.nextInt();
        if (k > readFile.getCityCount()) {
            System.out.println("The number you entered exceeds the number of cities");
            return;
        }

        // Read cities line by line and insert them into the priority queue
        for (City city : readFile.getCities()) {
            city.CalculateDensity(); // Calculate density for the city
            priorityQueue.insert(city); // Insert the city into the priority queue

            // Ensure that the priority queue has at most k elements
            while (priorityQueue.size() > k) {
                priorityQueue.getmin();
            }

        }
        // Print the top k cities with the least density
        System.out.println("Top " + k + " cities with the least density:");
        for (int i = 0; i < k; i++) {
            System.out.println(priorityQueue.min().getName());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DynamicInfluenza_k_withPQ mainObj = new DynamicInfluenza_k_withPQ (scanner);
    }
}