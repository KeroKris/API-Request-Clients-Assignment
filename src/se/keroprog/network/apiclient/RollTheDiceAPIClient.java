package se.keroprog.network.apiclient;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Network programming assignment, simple RollTheDiceAPIClient making a GET and a POST request to a specified API.
 * Created by Kristoffer on 2016-12-20.
 */
public class RollTheDiceAPIClient {

    private static HttpURLConnection connection;
    private static URL obj;
    private static String url;
    public static void main(String[] args) throws IOException {

        RollTheDiceAPIClient http = new RollTheDiceAPIClient();
        url = "http://demo.edument.se/api/highscore";
//        http.sendPost(url,"{\"name\":\"Test Person\",\"score\":1337}");

        url = "http://rollthedice.setgetgo.com/get.php";
        for (int i = 0; i < 10; i++) {

            http.sendGet(url);
        }
    }

    /**
     * Sends a GET request to the Roll the Dice API and prints out the result.
     * @param url the url
     * @throws IOException
     */
    private void sendGet(String url) throws IOException {

        obj = new URL(url);
        connection = (HttpURLConnection) obj.openConnection();
        connection.setRequestMethod("GET");


//        System.out.println("Sending GET request to URL: " + url);

        BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        while ((line = input.readLine()) != null){
            System.out.println(line);
        }
    }
}
