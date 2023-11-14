import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        String url = "https://reqres.in/api/users";
        try {
            URL myUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) myUrl.openConnection();
            connection.setRequestMethod("GET");
            System.out.println(connection.getResponseCode());
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String response = in.readLine();
            in.close();
            System.out.println(response);
            connection.disconnect();
            URL url1 = new URL("https://reqres.in/api/users");
            connection = (HttpURLConnection) url1.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);
            String body = "{\n\"name\": \"Maks\",\n\"job\": \"student\"\n}";
            BufferedOutputStream wr = new BufferedOutputStream(connection.getOutputStream());
            wr.write(body.getBytes());
            wr.close();
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            response = in.readLine();
            in.close();
            System.out.println(response);
        } catch (MalformedURLException e) {
            System.out.println("Bad request");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}