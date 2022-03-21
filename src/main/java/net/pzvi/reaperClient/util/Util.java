package net.pzvi.reaperClient.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jna.WString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Util {

    public static String[] searchYT(String words) throws IOException, InterruptedException {
        words = words.replace(" ", "+");
        String url = "https://www.googleapis.com/youtube/v3/search?part=snippet&maxResults=1&order=relevance&q=" + words + "&key=AIzaSyAzh9xSdl57vQWvRvqUdyohqCnRcYUawak";
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(response.body());
        return new String[]{node.findValue("videoId").asText(),node.findValue("title").asText()};
    }

    public static void makeUselessConnection(String videoId) throws IOException, InterruptedException {
        try {
            ProcessBuilder builder = new ProcessBuilder(
                    "cmd.exe", "/c", "cd \"C:\\Users\\megae\" && yt-dlp --extract-audio --audio-format mp3 https://www.youtube.com/watch?v=" + videoId);

            builder.redirectErrorStream(true);
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while (true) {
                line = r.readLine();
                if (line == null) {
                    break;
                }
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}








   // POST https://youtube.michaelbelgium.me/api/converter/convert

       // PARAMETER	TYPE	REQUIRED	DETAILS
        //url	string	Required	The youtube url from a video that needs to be converted
        //format	string	Optional	The format to convert to. Possible options: mp3, mp4. Defaults to mp3.
        //api_token	string	Optional	Your generated token that authenticates yourself. Either pass the token via this parameter or use it as a Bearer token in the Authorization header of the request.
