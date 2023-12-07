import java.util.Objects;

public class City implements CityInterface,Comparable<City>{
    int ID;
    String Name;
    int Population;
    int InfluenzaCases;
    float density;
    public City(int ID,String Name,int Population,int InfCases,float density){
        this.ID=ID;
        this.Name=Name;
        this.Population=Population;
        this.InfluenzaCases=InfCases;
        this.density=density;
    }

    @Override
    public int getID() {
        return this.ID;
    }

    @Override
    public String getName() {
        return this.Name;
    }

    @Override
    public int getPopulation() {
        return this.Population;
    }

    @Override
    public int getInfluenzaCases() {
        return this.InfluenzaCases;
    }

    @Override
    public float getDensity(){
        return this.density;
    }

    @Override
    public void setID(int ID) {
        this.ID=ID;
    }

    @Override
    public void setName(String name) {
        this.Name=name;
    }

    @Override
    public void setPopulation(int population) {
        this.Population=population;
    }

    @Override
    public void setInfluenzaCases(int InfluenzaCases) {
        this.InfluenzaCases=InfluenzaCases;
    }

    @Override
    public void setDensity(float density){
        this.density=density;
    }

    @Override
    public int compareTo(City city2) {
        int nameComparison = this.getName().compareTo(city2.getName());
        if (this.getDensity() == city2.getDensity()) {
            if (Objects.equals(this.getName(), city2.getName())) {
                return (this.getID() > city2.getID()) ? 0 : 1;
            } else {
                return (nameComparison < 0) ? 1 : 0;
            }
        } else {
            return (this.getDensity() > city2.getDensity()) ? 0 : 1;
        }
    }

    @Override
    public String toString(){
        return this.getName();
    }
}