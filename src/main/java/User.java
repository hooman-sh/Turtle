import java.util.ArrayList;

public class User {
    private String name;
    private String userId;
    private ArrayList<String> houses;

    public User(){
        if(houses == null){
            houses = new ArrayList<String>();
        }
    }
    public ArrayList<String> getHouses() {
        return houses;
    }

    public String getName() {
        return name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHouses(String id) {
        this.houses.add(id);
    }
}
