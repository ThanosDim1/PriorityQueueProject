import java.util.Scanner;

public class Influenza_k_withPQ {
    public Influenza_k_withPQ(Scanner scanner) {
        // Ask the user for the file name
        System.out.println("Enter the whole path of the text file:");
        String fileName = scanner.nextLine();
        
        // Create an instance of ReadFile to read cities from the file
        ReadFile readFile = new ReadFile(fileName);
        
        
        // Get the array of cities from ReadFile
        City[] cities = readFile.getCities();

        // Create an instance of PQ
        PQ priorityQueue = new PQ();

        System.out.println("Enter the number of cities to compare:");
        int k = scanner.nextInt();
        if (k > readFile.getCityCount()) {
            System.out.println("The number you entered exceeds the number of cities");
            return;
        }
        

        // Insert each city into the priority queue
        for (City city : cities) {
            priorityQueue.insert(city);

            // Ensure that the priority queue has at most k elements
            while (priorityQueue.size() > k) {
                priorityQueue.getmin();
            }
        }

        
    }
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Influenza_k mainObj = new Influenza_k(scanner);
    }
}

