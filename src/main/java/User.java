import java.util.ArrayList;

public class User {
    private String name;
    private ArrayList<House> houses;

    public User(){
        if(houses == null){
            houses = new ArrayList<House>();
        }
    }
    public ArrayList<House> getHouses() {
        return houses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHouses(House house) {
        this.houses.add(house);
    }
}
