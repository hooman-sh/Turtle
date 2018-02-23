import java.util.ArrayList;
import java.io.*;
import java.util.Iterator;
import java.util.Map;
import java.util.List;

import org.apache.http.client.*;
import org.apache.http.impl.client.*;
import org.apache.http.client.methods.*;
import org.apache.http.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.ContentType;
import static org.apache.http.HttpHeaders.USER_AGENT;

public class RSEndPoint {

    private String HouseURL;
    private String apiKey;

    public RSEndPoint(){
        this.apiKey = "4e273cc0-164c-11e8-87b4-496f79ef1988";
        this.HouseURL = "http://acm.ut.ac.ir/khaneBeDoosh/house";
    }

    public static String executeGet(String targetURL) {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(targetURL);
        request.addHeader("User-Agent", USER_AGENT);
        try {
            HttpResponse response = client.execute(request);

            System.out.println("Response Code : "
                    + response.getStatusLine().getStatusCode());

            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            StringBuffer result = new StringBuffer();
            String line = "";

            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            rd.close();
            return result.toString();
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;

    }

    public static String executePost(String targetURL,String value, String userId) {
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost request = new HttpPost(targetURL);
        request.setHeader("User-Agent", USER_AGENT);
        request.setHeader("apiKey", "4e273cc0-164c-11e8-87b4-496f79ef1988");

        try {
            String JSON_STRING = "{\n" +
                    "\t\"value\":" + "\"" + value + "\",\n" +
                    "\t\"userId\":" + "\"" + userId + "\"\n" +
                    "}";
            StringEntity requestEntity = new StringEntity(
                    JSON_STRING,
                    ContentType.APPLICATION_JSON);
            request.setEntity(requestEntity);
            HttpResponse response = client.execute(request);

            System.out.println("Response Code : "
                    + response.getStatusLine().getStatusCode());


            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            StringBuffer result = new StringBuffer();
            String line = "";

            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            rd.close();
            return result.toString();
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;

    }

    public static String executeGetById(String targetURL,String id) {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(targetURL+'/'+id);
        request.addHeader("User-Agent", USER_AGENT);
        try {
            HttpResponse response = client.execute(request);

            System.out.println("Response Code : "
                    + response.getStatusLine().getStatusCode());

            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            StringBuffer result = new StringBuffer();
            String line = "";

            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            rd.close();
            return result.toString();
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
    private ArrayList<House> parseJson(String contentBody){
        ArrayList<House> Houses = new ArrayList<>();
        try {
            Object obj = new JSONParser().parse(contentBody);
            JSONObject jo = (JSONObject) obj;
            JSONArray ja = (JSONArray) jo.get("data");
            Iterator itr2 = ja.iterator();
            Iterator<Map.Entry> itr1;

            while (itr2.hasNext())
            {
                itr1 = ((Map) itr2.next()).entrySet().iterator();
                House newHouse  = new House();
                while (itr1.hasNext()) {
                    Map.Entry pair = itr1.next();
                    if (pair.getKey().equals("price")) {
                        long sellPrice;
                        long basePrice;
                        long rentPrice;
                        Object price = new JSONParser().parse(pair.getValue().toString());
                        JSONObject objp = (JSONObject) price;
                        try {
                            sellPrice = (long) objp.get("sellPrice");
                        } catch (NullPointerException e) {
                            sellPrice = 0;
                        }
                        try {
                            basePrice = (long) objp.get("basePrice");
                        } catch (NullPointerException e) {
                            basePrice = 0;
                        }
                        try {

                            rentPrice = (long) objp.get("rentPrice");
                        } catch (NullPointerException e) {
                            rentPrice = 0;
                        }
                        newHouse.setBasePrice((int) basePrice);
                        newHouse.setRentPrice((int) rentPrice);
                        newHouse.setSellPrice((int) sellPrice);
                    } else {
                        switch (pair.getKey().toString()) {
                            case "area":
                                newHouse.setArea(new Double(pair.getValue().toString()));
                                break;
                            case "imageURL":
                                newHouse.setImageURL(pair.getValue().toString());
                                break;
                            case "id":
                                newHouse.setId(pair.getValue().toString());
                                break;
                            case "dealType":
                                newHouse.setDealType(new Integer(pair.getValue().toString()));
                                break;
                            case "buildingType":
                                newHouse.setBuildingType(pair.getValue().toString());
                                break;
                        }
                    }

                }

                Houses.add(newHouse);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Houses;
    }
    private House parseJson_2 (String contentBody){
        House newHouse  = new House();
        try {
            Object obj = new JSONParser().parse(contentBody);
            JSONObject jo = (JSONObject) obj;
            Map data = ((Map)jo.get("data"));
            // iterating address Map
            Iterator<Map.Entry> itr1 = data.entrySet().iterator();
            while (itr1.hasNext()) {
                Map.Entry pair = itr1.next();
                if (pair.getKey().equals("price")) {
                    long sellPrice;
                    long basePrice;
                    long rentPrice;
                    Object price = new JSONParser().parse(pair.getValue().toString());
                    JSONObject objp = (JSONObject) price;
                    try {
                        sellPrice = (long) objp.get("sellPrice");
                    } catch (NullPointerException e) {
                        sellPrice = 0;
                    }
                    try {
                        basePrice = (long) objp.get("basePrice");
                    } catch (NullPointerException e) {
                        basePrice = 0;
                    }
                    try {

                        rentPrice = (long) objp.get("rentPrice");
                    } catch (NullPointerException e) {
                        rentPrice = 0;
                    }
                    newHouse.setBasePrice((int) basePrice);
                    newHouse.setRentPrice((int) rentPrice);
                    newHouse.setSellPrice((int) sellPrice);
                } else {
                    switch (pair.getKey().toString()) {
                        case "area":
                            newHouse.setArea(new Double(pair.getValue().toString()));
                            break;
                        case "imageURL":
                            newHouse.setImageURL(pair.getValue().toString());
                            break;
                        case "id":
                            newHouse.setId(pair.getValue().toString());
                            break;
                        case "dealType":
                            newHouse.setDealType(new Integer(pair.getValue().toString()));
                            break;
                        case "buildingType":
                            newHouse.setBuildingType(pair.getValue().toString());
                            break;
                    }
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return newHouse;
    }

    public ArrayList<House> getHousesList(){
        ArrayList<House> houses;
        String body = executeGet(HouseURL);
        houses = parseJson(body);
        return houses;
    }
    public House getHouseDetail(String id){
        House house;
        String body = executeGetById(HouseURL,id);
        house = parseJson_2(body);
        return house;
    }
    public String increaseCredit(String userId, Integer value){
        String res =  executePost("http://acm.ut.ac.ir/ieBank/pay",value.toString(),userId);
        String response = "";
        try {
            Object obj = new JSONParser().parse(res);
            JSONObject jo = (JSONObject) obj;
            boolean result = (Boolean) jo.get("success");
            if(result){
                response="success";
            }
            else {
                response="err";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }
    public House getHouse(){
        return null;
    }


}