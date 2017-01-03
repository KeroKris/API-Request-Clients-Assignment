package se.keroprog.network.apiclient;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Simple Client for the Chuck Norris API that prints just the value, ie the joke
 * Created by Kristoffer on 2016-12-28.
 */
public class ChuckNorrisAPIClient {

    public static void main(String[] args) throws IOException, JSONException {

        ChuckNorrisAPIClient http = new ChuckNorrisAPIClient();

        for (int i = 0; i < 4; i++) {
            System.out.println(http.getRandomChuckNorrisJoke());
        }
    }


    /**
     * Sends a GET request to the Chuck Norris API and returns the value field from the Json object, that is the joke.
     */
    private String getRandomChuckNorrisJoke() throws IOException, JSONException {

        String url = "https://api.chucknorris.io/jokes/random";
        HttpURLConnection connection =(HttpURLConnection) (new URL(url)).openConnection();

        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "chucknorris-io/client-java-1.0.1");
        System.out.println("Sending GET request to URL: " + url);
        int responseCode = connection.getResponseCode();

        String returnValue = "response code: " + responseCode;
        if (responseCode == 200){
            JSONObject object = new JSONObject(new JSONTokener(connection.getInputStream()));
            returnValue = object.optString("value");
        }
        return returnValue;
    }
}
