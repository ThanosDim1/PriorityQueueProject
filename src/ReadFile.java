import javax.sound.sampled.Line;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadFile {
    public List<City> Cities=new List<>();
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

    public ReadFile() {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter the name of the txt file:");
        String txtfile =input.nextLine();
        txtfile= txtfile+ ".txt";
        try (BufferedReader br = new BufferedReader(new FileReader(txtfile))){
            String line;

            while ((line = br.readLine()) != null) {
                
                String[] elements = line.split("\\s+");

                
                LineProcessor(elements);
                Cities.insertAtFront(new City(id,city,population,area,density));
            }
        }catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            input.close();
        }
    }

    public List<City> getCities(){
        return Cities;
    }

}
