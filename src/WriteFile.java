import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteFile {
    static int id;
    static String city;
    static int population;
    static int area;
    static double density;
    public void LineProcessor(String[] tokens){
        id = Integer.parseInt(tokens[0]);
        city = tokens[1];
        population = Integer.parseInt(tokens[2]);
        area = Integer.parseInt(tokens[3]);
        density = Double.parseDouble(tokens[6]);
    }

    public WriteFile() {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter the name of the txt file:");
        String txtfile =input.nextLine();
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(txtfile))){
            while (input.hasNextLine()){
                String line=input.nextLine();
                String[] tokens = line.split("\\s+");
                LineProcessor(tokens);
                writer.write("ID: " + id + ", City: " + city + ", Population: " + population
                        + ", Area: " + area + ", Density: " + density + "\n");
            }
        }catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            input.close(); // Close the scanner to prevent resource leaks
        }
    }
}
