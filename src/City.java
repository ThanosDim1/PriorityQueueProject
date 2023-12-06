public class City implements CityInterface{
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
        this.Name=Name;
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
}
