package br.com.system;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.StyledEditorKit.BoldAction;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;

@WebServlet("/system")
public class ConnectionSevlet extends HttpServlet{
    private static String conditionString;
    private static String descripitionString;
    private static Double humidityDouble;
    private static Double windSpeedyDouble;
    private static Double pressureDouble;
    private static String datetimeString;
    private static Double windgustDouble;
    private static Boolean com = true;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        
       /* out.println("<h1>Hello World, Vinicius here!");
       pressure
        windSpeedy
        humidade
        condition
        windgust
        description*/ 
      HttpRequest request = HttpRequest.newBuilder()
       .uri(URI.create("https://bestweather.p.rapidapi.com/weather/Salvador%20BA/today"))
       .header("X-RapidAPI-Key", "f2f143bc54msh8c3040493d71cdbp1c6858jsnb949724e6234")
       .header("X-RapidAPI-Host", "bestweather.p.rapidapi.com")
       .method("GET", HttpRequest.BodyPublishers.noBody())
       .build();
       try {
          HttpResponse<String>  response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
           //System.out.println(response.body());
          JSONObject weather = new JSONObject(response.body());  
            conditionString = weather.getJSONArray("days").getJSONObject(0).getString("conditions");;
            descripitionString = weather.getJSONArray("days").getJSONObject(0).getString("description") ;
            humidityDouble = weather.getJSONArray("days").getJSONObject(0).getDouble("humidity");
            windSpeedyDouble = weather.getJSONArray("days").getJSONObject(0).getDouble("windspeed");
            pressureDouble = weather.getJSONArray("days").getJSONObject(0).getDouble("pressure");    
            datetimeString = weather.getJSONArray("days").getJSONObject(0).getString("datetime");;
            windgustDouble = weather.getJSONArray("days").getJSONObject(0).getDouble("windgust");    
             
          

       } catch (IOException | InterruptedException e) {
           e.printStackTrace();
           out.println("<script>alert('ERRO! Na Conexao da API!!!')</script>");
           com = false;

       } /**/   
       

       if(com){
        resp.sendRedirect("/SGCD/HomeSystem");
       }
        
    }

    public static String getConditionString() {
        return conditionString;
    }
    public static void setConditionString(String condition) {
        conditionString = condition;
    }
    public static String getDescripitionString() {
        return descripitionString;
    }
    public static void setDescripitionString(String descripition) {
        descripitionString = descripition;
    }
    public static Double getHumidityDouble() {
        return humidityDouble;
    }
    public static void setHumidityDouble(Double humidity) {
        humidityDouble = humidity;
    }
    public static Double getWindSpeedyDouble() {
        return windSpeedyDouble;
    }
    public static void setWindSpeedyDouble(Double windSpeedy) {
        windSpeedyDouble = windSpeedy;
    }
    public static Double getPressureDouble() {
        return pressureDouble;
    }
    public static void setPressureDouble(Double pressure) {
        pressureDouble = pressure;
    }
    public static String getDatetimeString() {
        return datetimeString;
    }
    public static void setDatetimeString(String datetime) {
        datetimeString = datetime;
    }
    public static Double getWindgustDouble() {
        return windgustDouble;
    }
    public static void setWindgustDouble(Double windgust) {
        windgustDouble = windgust;
    }
}
