package AirVirsual.Controller;

import AirVirsual.Controller.Draw.DrawNewPane;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

public class FetchData {
    private JSONObject object = new JSONObject();
    private Obj obj = new Obj();
    private DrawNewPane drawNewPane = new DrawNewPane();

    private String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    private JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
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

    public void fetch(String city, String state, String country) throws IOException {
        String city1 = city.replaceAll(" ", "%20");
        String state1 = state.replaceAll(" ", "%20");
        String country1 = country.replaceAll(" ", "%20");

        object = readJsonFromUrl(String.format("http://api.airvisual.com/v2/city?city=%s&state=%s&country=%s&key=cad42f09-3279-438d-837b-c22424fccedd", city1, state1, country1));
        System.out.println(object.toString());
        JSONObject data = object.getJSONObject("data");

        obj.createObj(data);
        drawNewPane.createNewPane(obj);
    }
}
