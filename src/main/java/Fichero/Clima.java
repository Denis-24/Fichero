package Fichero;

public class Clima {
    // import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
    public class CurrentWeather{
        public String time;
        public int interval;
        public double temperature;
        public double windspeed;
        public int winddirection;
        public int is_day;
        public int weathercode;
    }

    public class CurrentWeatherUnits{
        public String time;
        public String interval;
        public String temperature;
        public String windspeed;
        public String winddirection;
        public String is_day;
        public String weathercode;
    }

    public class Root{
        public double latitude;
        public double longitude;
        public double generationtime_ms;
        public int utc_offset_seconds;
        public String timezone;
        public String timezone_abbreviation;
        public double elevation;
        public CurrentWeatherUnits current_weather_units;
        public CurrentWeather current_weather;
    }


}
