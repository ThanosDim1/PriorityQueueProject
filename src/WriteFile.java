import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteFile {
    public static List<City> Cities=new List<>();
    public int id;
    public String city;
    public int population;
    public int area;
    public float density;

    public void LineProcessor(String[] tokens){
        id = Integer.parseInt(tokens[0]);
        city = tokens[1];
        population = Integer.parseInt(tokens[2]);
        area = Integer.parseInt(tokens[3]);
        density = Float.parseFloat(tokens[5]);
    }

    public WriteFile() {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter the name of the txt file:");
        String txtfile =input.nextLine();
        txtfile= txtfile+ ".txt";
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(txtfile))){
            System.out.println("Enter the data");
            while (input.hasNextLine()){
                String line=input.nextLine();
                if (line.isEmpty()){
                    break;
                }
                String[] tokens = line.split("\\s+");
                LineProcessor(tokens);
                writer.write("ID: " + id + ", City: " + city + ", Population: " + population
                        + ", Area: " + area + ", Density: " + density + "\n");
                Cities.insertAtFront(new City(id,city,population,area,density));
            }
        }catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            input.close();
        }
    }
}
