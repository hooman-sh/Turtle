import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;

public class Search {
    private ArrayList<House> houses;

    public void addHouse (House house) {
        this.houses.add(house);
    }

    public void setHouses(ArrayList<House> houses) {
        this.houses = houses;
    }

    public ArrayList<House> getHouses() {
        return houses;
    }

    public ArrayList<House> filterHouses(String minArea,String dealType,String buildingType,String maxPrice){
        ArrayList<House> filteredArray = new ArrayList<House>();
        for(int i=0;i<houses.size();i++){
            if((buildingType.length() == 0) || houses.get(i).getBuildingType().equals(buildingType.toString())){
                if((minArea.length() == 0) || houses.get(i).getArea() >= Double.parseDouble(minArea)){
                    if(dealType.length() == 0 || houses.get(i).getDealType().equals(Integer.parseInt(dealType))){
                        if(dealType.length() == 0 || Integer.parseInt(dealType) == 1){
                            if(maxPrice.length() == 0 || houses.get(i).getRentPrice() != 0 && houses.get(i).getRentPrice() <= Integer.parseInt(maxPrice)){
                                filteredArray.add(houses.get(i));
                            }
                        }
                        if(dealType.length() == 0 || Integer.parseInt(dealType) == 0){
                            if(maxPrice.length() != 0 && houses.get(i).getSellPrice() != 0 && houses.get(i).getSellPrice() <= Integer.parseInt(maxPrice)){
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
