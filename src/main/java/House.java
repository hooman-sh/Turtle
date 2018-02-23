import java.util.Date;
import java.util.Random;

public class House {
    private String id;
    private Double area;
    private String buildingType;
    private String address;
    private String imageURL;
    private Integer dealType;
    private Integer basePrice;
    private Integer rentPrice;
    private Integer sellPrice;
    private String phone;
    private String description;
    private Date expireTime;

    public House(){
        this.imageURL = "../static/no-pic.jpg";
    }

    public Integer getBasePrice() {
        return basePrice;
    }

    public Integer getRentPrice() {
        return rentPrice;
    }

    public String getAddress() {
        return address;
    }

    public double getArea() {
        return area;
    }

    public Integer getSellPrice() {
        return sellPrice;
    }

    public String getBuildingType() {
        return buildingType;
    }

    public Integer getDealType() {
        return dealType;
    }

    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getPhone() {
        return phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void setBasePrice(Integer basePrice) {
        this.basePrice = basePrice;
    }

    public void setBuildingType(String buildingType) {
        this.buildingType = buildingType;
    }

    public void setDealType(Integer dealType) {
        this.dealType = dealType;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setRentPrice(Integer rentPrice) {
        this.rentPrice = rentPrice;
    }

    public void setSellPrice(Integer sellPrice) {
        this.sellPrice = sellPrice;
    }

    private String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

    public House createHouse(String buildingType,Integer dealType,Integer price,String address,String description,Double area,String phone) {
        this.buildingType = buildingType;
        this.dealType = dealType;
        if(dealType == 0){
            this.sellPrice = price;
            this.basePrice = 0;
            this.rentPrice = 0;
        }else{
            this.rentPrice = price;
            this.sellPrice = 0;
            this.basePrice = 0;
        }
        this.description = description;
        this.address = address;
        this.phone = phone;
        this.area = area;
        this.id = getSaltString();
        return this;
    }
}
