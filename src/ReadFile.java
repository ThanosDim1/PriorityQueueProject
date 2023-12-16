import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadFile {

    public int id;
    public String city;
    public int population;
    public int cases;
    public int cityCount;
    public City[] cities;
    public PQ pq = new PQ();
    public int k;
    public int cnt = 1;

    public void LineProcessor(String[] tokens) {
        id = Integer.parseInt(tokens[0]);
        city = tokens[1];
        population = Integer.parseInt(tokens[2]);
        cases = Integer.parseInt(tokens[3]);
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

    public ReadFile(String fileName, int kFromCommandLine) {
        // Use the provided kFromCommandLine value if it's greater than zero
        
        this.k = kFromCommandLine;
        
        // Check if the file exists
        Path filePath = Paths.get(fileName);
        if (!Files.exists(filePath)) {
            System.err.println("Path not found: " + fileName);
            System.exit(1);
        }

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
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

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            int index = 0;
            while ((line = br.readLine()) != null) {
                String[] elements = line.split("\\s+");
                LineProcessor(elements);

                if (k >= cnt) {
                    pq.insert(new City(id, city, population, cases));
                    cnt++;
                } else {

                    City temp = pq.getLast();
                    if (pq.compare(temp, new City(id, city, population, cases)) > 0) {
                        pq.insert(new City(id, city, population, cases));
                    } else {
                        pq.insert(temp);
                    }
                }

                cities[index] = new City(id, city, population, cases);
                index++;
            }
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    public City[] getCities() {
        return this.cities;
    }

    public PQ getPQ() {
        return this.pq;
    }

    public int getCityCount() {
        return this.cityCount;
    }

}
