package me.shivzee.utils;

import java.net.URL;

public class RDBUtils {
    public static boolean isValidURL(String url){
        try{
            URL dblink = new URL(url);
            return true;
        }catch(Exception e){
            return false;
        }


    }
    public static String fetchDBUrl(){
        return System.getenv("REPLIT_DB_URL");
    }
    public static String fetchDBUrl(String envKey){
        return System.getenv(envKey);
    }
}
