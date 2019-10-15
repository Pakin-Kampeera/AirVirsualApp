package AirVirsual.Controller;

import org.json.JSONObject;

public class Obj {
    private int aqi;
    private String downColor;
    private String quality;
    private String weather;
    private String mainLocation;
    private String location;
    private String icon;
    private String face;
    private String headColor;

    public void createObj(JSONObject data) {
        aqi = data.getJSONObject("current").getJSONObject("pollution").getInt("aqius");
        this.headColor = headColorQuality(aqi);
        this.downColor = downColorQuality(aqi);
        this.quality = airQuality(aqi);
        this.weather = data.getJSONObject("current").getJSONObject("weather").getInt("tp") + "°";
        this.mainLocation = data.getString("city");
        this.location = data.getString("state") + ", " + data.getString("country");
        this.icon = data.getJSONObject("current").getJSONObject("weather").getString("ic") + ".png";
        this.face = faceColor(aqi) + ".png";
        printData();
    }

    public void printData() {
        System.out.println(weather);
        System.out.println(quality);
        System.out.println(this.aqi + " US AQI");
        System.out.println(mainLocation);
        System.out.println(location);
        System.out.println(icon);
        System.out.println(face);
        System.out.println("-----------------------");
    }

    private String airQuality(int aqi) {
        if (aqi >= 0 && aqi <= 50) {
            return "Good";
        } else if (aqi >= 51 && aqi <= 100) {
            return "Moderate";
        } else if (aqi >= 101 && aqi <= 150) {
            return "Moderate\n" + "Unhealthy";
        } else if (aqi >= 151 && aqi <= 200) {
            return "Unhealthy";
        } else if (aqi >= 201 && aqi <= 300) {
            return "Very Unhealthy";
        } else if (aqi >= 301 && aqi <= 500) {
            return "Hazardous";
        }
        return null;
    }

    private String headColorQuality(int aqi) {
        if (aqi >= 0 && aqi <= 50) {
            return "9ED15C";
        } else if (aqi >= 51 && aqi <= 100) {
            return "E5C850";
        } else if (aqi >= 101 && aqi <= 150) {
            return "E5975D";
        } else if (aqi >= 151 && aqi <= 200) {
            return "E66C6B";
        } else if (aqi >= 201 && aqi <= 300) {
            return "FFFFFF";
        } else if (aqi >= 301 && aqi <= 500) {
            return "FFFFFF";
        }
        return null;
    }

    private String downColorQuality(int aqi) {
        if (aqi >= 0 && aqi <= 50) {
            return "A8E05F";
        } else if (aqi >= 51 && aqi <= 100) {
            return "FED64B";
        } else if (aqi >= 101 && aqi <= 150) {
            return "FE9B57";
        } else if (aqi >= 151 && aqi <= 200) {
            return "FE6A69";
        } else if (aqi >= 201 && aqi <= 300) {
            return "A97ABC";
        } else if (aqi >= 301 && aqi <= 500) {
            return "A87383";
        }
        return null;
    }

    private String faceColor(int aqi) {
        if (aqi >= 0 && aqi <= 50) {
            return "green";
        } else if (aqi >= 51 && aqi <= 100) {
            return "yellow";
        } else if (aqi >= 101 && aqi <= 150) {
            return "orange";
        } else if (aqi >= 151 && aqi <= 200) {
            return "red";
        } else if (aqi >= 201 && aqi <= 300) {
            return "purple";
        } else if (aqi >= 301 && aqi <= 500) {
            return "maroon";
        }
        return null;
    }

    public String getDownColor() {
        return downColor;
    }

    public String getQuality() {
        return quality;
    }

    public String getWeather() {
        return weather;
    }

    public String getMainLocation() {
        return mainLocation;
    }

    public String getLocation() {
        return location;
    }

    public String getIcon() {
        return icon;
    }

    public String getFace() {
        return face;
    }

    public String getHeadColor() {
        return headColor;
    }

    public int getAqi() {
        return aqi;
    }
}
