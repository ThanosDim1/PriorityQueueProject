public class City implements CityInterface,Comparable<City>{
    int ID;
    String Name;
    int Population;
    int InfluenzaCases;
    public City(int ID,String Name,int Population,int InfCases){
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
    public double CalculateDensity() {
        double density = ((double) (this.InfluenzaCases * 50000)) / ((double) this.Population);
        return Math.round(density * 100.0) / 100.0;
    }
    

    public int compareTo(City city2) {
        int densityComparison = Double.compare(this.CalculateDensity(), city2.CalculateDensity());

        if (densityComparison == 0) {
            int nameComparison = this.getName().compareTo(city2.getName());

            if (nameComparison == 0) {
                return Integer.compare(this.getID(), city2.getID());
            } else {
                return nameComparison;
            }
        } else {
            return densityComparison;
        }
    }
    @Override
    public String toString(){
        return this.getName();
    }
}