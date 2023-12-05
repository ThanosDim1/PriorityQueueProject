public class City implements CityInterface{
    int ID;
    String Name;
    int Population;
    int InfCases;
    public City(int ID,String Name,int Population,int InfCases){
        this.ID=ID;
        this.Name=Name;
        this.Population=Population;
        this.InfCases=InfCases;
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
        return this.InfCases;
    }

    @Override
    public void setID(int ID) {
        this.ID=ID;
    }

    @Override
    public void setName(String name) {
        this.Name=Name;
    }

    @Override
    public void setPopulation(int population) {
        this.Population=population;
    }

    @Override
    public void setInfluenzaCases(int InfluenzaCases) {
        this.InfCases=InfluenzaCases;
    }
}
