package dk.sdu.cbse.common.services;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ScoreService {
    public static int sendScore(long points) {
        try {
            URL url = new URL("http://localhost:8080/Score?point=" + points);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            if (connection.getResponseCode() == 200) {
                return Integer.parseInt((new String(connection.getInputStream().readAllBytes())));
            }
        } catch (IOException e) {
            e.printStackTrace(); // You can log or handle differently
        }
        return 0;
    }
}