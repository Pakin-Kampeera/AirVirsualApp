package AirVisual.Model;

import org.json.JSONArray;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Forecast {
    private ArrayList<String> day;
    private ArrayList<String> min_temp;
    private ArrayList<String> max_temp;
    private ArrayList<String> icon;

    public void createObj(JSONArray data) throws ParseException {
        this.day = new ArrayList<>();
        this.min_temp = new ArrayList<>();
        this.max_temp = new ArrayList<>();
        this.icon = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            if (data.getJSONObject(i).getString("dt_txt").split(" ")[1].equals("12:00:00")) {
                this.day.add(convertDate(data.getJSONObject(i).getString("dt_txt").split(" ")[0]));
                this.min_temp.add(data.getJSONObject(i).getJSONObject("main").getInt("temp_min") / 10 + "°");
                this.max_temp.add(data.getJSONObject(i).getJSONObject("main").getInt("temp_max") / 10 + "°");
                this.icon.add(data.getJSONObject(i).getJSONArray("weather").getJSONObject(0).getString("icon"));
            }
        }
        System.out.println("-----------------------");
    }

    private String convertDate(String date) throws ParseException {
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-mm-dd");
        Date dt1 = format1.parse(date);
        DateFormat format2 = new SimpleDateFormat("EEEE");
        String finalDay = format2.format(dt1);
        return finalDay.substring(0, 3);
    }

    public ArrayList<String> getDay() {
        return day;
    }

    public ArrayList<String> getMin_temp() {
        return min_temp;
    }

    public ArrayList<String> getMax_temp() {
        return max_temp;
    }

    public ArrayList<String> getIcon() {
        return icon;
    }
}
