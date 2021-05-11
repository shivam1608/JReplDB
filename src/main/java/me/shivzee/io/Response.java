package me.shivzee.io;

import me.shivzee.exceptions.InvalidKeyException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Response {
    private String requestUrl;
    public Response(String requestUrl){
        this.requestUrl = requestUrl;
    }

    public String getResponse() {
        String response = "";
        try{
            URL url = new URL(requestUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            String line;
            StringBuilder builder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            while((line = reader.readLine()) != null){
                builder.append(line).append("\n");
            }
            response = builder.toString();

        }catch (Exception e){
            response = "";
        }
        return response;
    }
}
