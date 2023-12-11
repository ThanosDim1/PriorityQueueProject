import javax.sound.sampled.Line;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadFile {

    public int id;
    public String city;
    public int population;
    public int cases;
    public int cityCount;
    public City[] cities;
    private Scanner scanner;

    
    public void LineProcessor(String[] tokens){
        try {
            id = Integer.parseInt(tokens[0]);
            if (id < 1 || id > 999) {
                throw new IllegalArgumentException("ID must be between 1 and 999");
            }
        
            city = tokens[1];
        
            population = Integer.parseInt(tokens[2]);
            if (population <= 0 || population >= 10_000_000) {
                throw new IllegalArgumentException("Population must be positive and less than 10,000,000");
            }
        
            cases = Integer.parseInt(tokens[3]);
            if (cases >= population) {
                throw new IllegalArgumentException("Cases must be less than the population");
            }
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }
        
    

    public ReadFile(Scanner scanner) {
        this.scanner = scanner;
        System.out.println("Enter the name of the txt file:");
        String txtfile =scanner.nextLine();
        txtfile= txtfile+ ".txt";
        if (txtfile.equals(".txt")){
            System.out.println("You did not enter a file name");
            System.exit(1);
        }

        File file = new File(txtfile);
        
        if (!file.exists()) {
            System.out.println("The file does not exist");
            System.exit(1);
            }

        try (BufferedReader br = new BufferedReader(new FileReader(txtfile))) {
            String line;

            // Count the number of lines in the file to determine the array size
            while ((line = br.readLine()) != null) {
                cityCount++;
            }
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }

        // Initialize the array with the determined size
        cities = new City[cityCount];

        try (BufferedReader br = new BufferedReader(new FileReader(txtfile))) {
            String line;
            int index = 0;
            while ((line = br.readLine()) != null) {
                String[] elements = line.split("\\s+");
                LineProcessor(elements);
                cities[index] = new City(id, city, population, cases);
                index++;
            }
        }catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    public City[] getCities() {
        return this.cities;
    }

    public int getCityCount(){
        return this.cityCount;
    }
}
