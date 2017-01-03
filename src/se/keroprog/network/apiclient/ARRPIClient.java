package se.keroprog.network.apiclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 * Asks for a text in the console and returns the text turned into pirate speak.
 * Created by Kristoffer on 2016-12-28.
 */
public class ARRPIClient {

    public static void main(String[] args) throws IOException {

        String exampleText = "Hello friend, how are you?";

        System.out.println("This small program lets you enter a text and get it back from an API turned into pirate speak");
        System.out.println("\nExample: " + exampleText);
        System.out.println("pirate: " + makePirateSpeak(exampleText));

        System.out.println("\nEnd with \"quit\"");
        Scanner input = new Scanner(System.in);

        String query;

        do {

            System.out.println("write a text and get it returned as pirate speak:");
            query = input.nextLine();

            System.out.println(makePirateSpeak(query));
        }while (!query.equals("quit"));

    }

    private static String makePirateSpeak(String query) throws IOException {

        String url = "http://isithackday.com/arrpi.php?text=" + query.replaceAll(" ", "%20");
        HttpURLConnection connection = (HttpURLConnection) (new URL(url)).openConnection();

        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();

        String returnValue = "response code: " + responseCode;
        if (responseCode == 200) {

            returnValue = "";
            BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = input.readLine()) != null) {
                returnValue += line;
            }
        }
        return returnValue;
    }
}
