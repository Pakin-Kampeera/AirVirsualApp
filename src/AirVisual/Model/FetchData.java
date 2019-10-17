package AirVisual.Model;

import AirVisual.Controller.Draw.DrawNewPane;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.ParseException;

public class FetchData {
    private JSONObject data1 = new JSONObject();
    private JSONObject data2 = new JSONObject();
    private AqiData aqiData = new AqiData();
    private DrawNewPane drawNewPane = new DrawNewPane();
    private Forecast forecast = new Forecast();

    private String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    private JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        System.out.println(url);
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    public void fetch(String city, String state, String country) throws IOException, ParseException {
        String city1 = city.replaceAll(" ", "%20");
        String state1 = state.replaceAll(" ", "%20");
        String country1 = country.replaceAll(" ", "%20");

        data1 = readJsonFromUrl(String.format("http://api.airvisual.com/v2/city?city=%s&state=%s&country=%s&key=1f2c4de8-8a05-407d-9eae-8b7aae4681aa", city1, state1, country1));
        String lat = data1.getJSONObject("data").getJSONObject("location").getJSONArray("coordinates").get(1).toString();
        String lon = data1.getJSONObject("data").getJSONObject("location").getJSONArray("coordinates").get(0).toString();
        data2 = readJsonFromUrl(String.format(String.format("http://api.openweathermap.org/data/2.5/forecast?lat=%s&lon=%s&appid=5f3ea741bfea7efee74331a0812a15c5", lat, lon)));

        JSONObject aqi = data1.getJSONObject("data");
        aqiData.createObj(aqi);

        JSONArray list = data2.getJSONArray("list");
        forecast.createObj(list);

        drawNewPane.createNewPane(aqiData, forecast);
    }
}
