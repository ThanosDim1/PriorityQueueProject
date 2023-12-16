import java.util.Scanner;

public class DynamicInfluenza_k_withPQ {

    public DynamicInfluenza_k_withPQ(int k, String filePath) {
        // Create an instance of ReadFile to read cities from the file
        ReadFile readFile = new ReadFile(filePath,k);

        PQ priorityQueue = readFile.getPQ();

        if (k > readFile.getCityCount()) {
            System.out.println("The number you entered exceeds the number of cities");
            return;
        }

        // Print the top k cities with the least density
        System.out.println("Top " + k + " cities with the least density:");
        for (int i = 0; i < k; i++) {
            System.out.println(priorityQueue.getmin().getName());
        }
    }

    public static void main(String[] args) {
        // Check if the correct number of command-line arguments is provided
        if (args.length != 2) {
            System.out.println("Usage: java DynamicInfluenza_k_withPQ <k> <filepath>");
            System.exit(1); // Exit the program with an error code
        }
        int k = Integer.parseInt(args[0]);
        String filePath = args[1];
        

        // Create an instance of DynamicInfluenza_k_withPQ with the provided arguments
        DynamicInfluenza_k_withPQ mainObj = new DynamicInfluenza_k_withPQ(k, filePath);
    }
}
