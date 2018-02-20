import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;

public class Search {
    private ArrayList<House> houses;

    public void addHouse (House house) {
        this.houses.add(house);
    }

    public ArrayList<House> getHouses() {
        return houses;
    }

    public ArrayList<House> filterHouses(Double minArea,Integer dealType,String buildingType,Integer maxPrice){
        ArrayList<House> filteredArray = new ArrayList<House>();
        for(int i=0;i<this.houses.size();i++){
            if(houses.get(i).getBuildingType() == buildingType || (buildingType.length() == 0) ){
                if(houses.get(i).getArea() >= minArea || (buildingType.length() == 0)){
                    if(houses.get(i).getDealType() == dealType || dealType == null){
                        if(dealType == 1){
                            if(houses.get(i).getRentPrice() <= maxPrice || maxPrice == null){
                                filteredArray.add(houses.get(i));
                            }
                        }
                        if(dealType == 0){
                            if(houses.get(i).getSellPrice() <= maxPrice || maxPrice == null){
                                filteredArray.add(houses.get(i));
                            }
                        }
                    }
                }
            }
        }
        return filteredArray;
    }
}
