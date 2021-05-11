package me.shivzee.io;



import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Requests {
    private String requestUrl;

    public Requests(String requestUrl){
        this.requestUrl = requestUrl;
    }

    public int request(byte[] bytesData,String method){
        int success = 404;
        try{
            URL url=new URL(requestUrl);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod(method);
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(bytesData);
            connection.getResponseMessage();

            success = connection.getResponseCode();
            connection.disconnect();

        }catch (Exception e){
            System.out.println("Exception Caught "+e+" Report Owner/Open an Issue");
        }
        return success;
    }
}
