/**
 * JReplDB is a Small, Powerful, Stable Java Wrapper Class of Replit.com DB API Access
 * Can be used within Replit.com as well as Out Side (We Do Not Promote any kind of illegal activity)
 *
 * @version 1.0
 * @author Shivzee
 * @Github : https://github.com/shivam1608/
 * @Stable : YES
 *
 * Shivzee Made all this alone (well its not so big api lol )
 *
 * */


package me.shivzee;

import me.shivzee.exceptions.InvalidDBUrlException;
import me.shivzee.exceptions.InvalidKeyException;
import me.shivzee.io.Requests;
import me.shivzee.io.Response;
import me.shivzee.utils.RDBUtils;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JReplDB {

    // Important Variables
    private String DBUrl;

    /**
     * This is Constructor and it makes sure that user have REPL_DB_URL input
     * @param REPLIT_DB_URL Check Github Page to know How to Get DB URL!
     * */
    public JReplDB(String REPLIT_DB_URL) throws InvalidDBUrlException {
        if(RDBUtils.isValidURL(REPLIT_DB_URL)){
            this.DBUrl = REPLIT_DB_URL;
        }else{
            throw new InvalidDBUrlException("Invalid DB URL Found!");
        }
    }

    // Getters & Setters
    public void setDBUrl(String REPLIT_DB_URL){
        this.DBUrl = REPLIT_DB_URL;
    }

    public String getDBUrl(){
        return this.DBUrl;
    }


    // Functions/Methods

    /**
     * This set function/method set's the data in the database
     *
     * @return true/false according to response code
     * @param key The Key for the data
     * @param value The Value of the data
     * */

    public boolean set(String key,String value) throws UnsupportedEncodingException {
        String jsonString = key+"="+value;
        byte[] bytes = jsonString.getBytes(StandardCharsets.UTF_8);
        Requests requests = new Requests(DBUrl);
        int code = requests.request(bytes,"POST");
        return code == 200 || code == 204;
    }

    /**
     * This get function/method get the value of a particular key
     *
     * @return response <String>
     * @param key The Key for value
     * @throws InvalidKeyException When the specified key is not found !
     * */

    public String get(String key) throws InvalidKeyException {
        Response response = new Response(DBUrl+"/"+key);
        String getBackResponse = response.getResponse();
        if(getBackResponse.equals("")){
            throw new InvalidKeyException("Invalid Key : '"+key+"', 404 Key Not Found!");
        }
        return getBackResponse;
    }

    /**
     * This get function/method get the value of a particular key
     *
     * @return true/false according to response code
     * @param key The Key for value
     * */


    public boolean delete(String key){
        Requests requests = new Requests(DBUrl+"/"+key);
        int code = requests.request("".getBytes(StandardCharsets.UTF_8),"DELETE");
        return code == 204;
    }

    /**
     * Overloaded Function/Method
     * This get function/method get the value of a particular key
     *
     * @return array of all possible KEY cases
     * @param query The optional query to search for a particular KEY
     *              i.e If query Specified "e" then all key starting with e will be the response
     * */


    public String[] getList(String query){
        Response response = new Response(DBUrl+"?prefix="+query);
        List<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(response.getResponse());
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            list.add(line);
        }
        return list.toArray(new String[0]);
    }

    public String[] getList(){
        Response response = new Response(DBUrl+"?prefix=");
        List<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(response.getResponse());
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            list.add(line);
        }
        return list.toArray(new String[0]);
    }

    /**
     * Overloaded Function/Method
     * This get function/method get the value of a particular key
     *
     * @return array of all KEY cases in DB
     * */

    public String[] getAllKeys() {
        Response response = new Response(DBUrl+"?prefix=");
        List<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(response.getResponse());
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            list.add(line);
        }
        return list.toArray(new String[0]);
    }





}

// ....................................<! The End  !>.. <-> ..<! Shivzee !>.........................................................