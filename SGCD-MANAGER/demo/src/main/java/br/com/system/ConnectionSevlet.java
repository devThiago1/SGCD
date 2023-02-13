package br.com.system;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//imports para o consumo da api
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;
//
import br.com.system.DAO.UserDAO;
import br.com.system.model.User;
//imports para o metodo sms
import java.net.*;
import java.util.Base64;
import java.util.List;
import java.io.*;   
//
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

    private static String nivel01 = "Faça suas Malas de Emergencia";
    private static String nivel02 = "Liguem para Autoridades para saber os Locais de Refugio";
    private static String nivel03 = "Se Dirija para o Local de Refugio Mais Porximo";
    private static String nivel04 = "Saia Imediatamente de Casa";
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        
        HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create("https://bestweather.p.rapidapi.com/weather/Salvador%20BA/today"))
        .header("X-RapidAPI-Key", "f2f143bc54msh8c3040493d71cdbp1c6858jsnb949724e6234")
        .header("X-RapidAPI-Host", "bestweather.p.rapidapi.com")
        .method("GET", HttpRequest.BodyPublishers.noBody())
        .build();
        try {
            HttpResponse<String>  response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            JSONObject weather = new JSONObject(response.body());  
                conditionString = weather.getJSONArray("days").getJSONObject(0).getString("conditions");;
                descripitionString = weather.getJSONArray("days").getJSONObject(0).getString("description") ;
                humidityDouble = weather.getJSONArray("days").getJSONObject(0).getDouble("humidity");
                System.out.println(windSpeedyDouble = weather.getJSONArray("days").getJSONObject(0).getDouble("windspeed"));
                pressureDouble = weather.getJSONArray("days").getJSONObject(0).getDouble("pressure");    
                datetimeString = weather.getJSONArray("days").getJSONObject(0).getString("datetime");;
                windgustDouble = weather.getJSONArray("days").getJSONObject(0).getDouble("windgust");   
             
            //select para pegar o numero dos usuarios e mandar sms
            UserDAO userDAO = new UserDAO();
            List<User> ListUser = userDAO.getListUser();
            //
                //Decisoes sobre o clima com resposta de mandar sms para os usuarios cadastrados
                try { 
                    
                    if(ConnectionSevlet.getWindgustDouble() >= 15.0 && ConnectionSevlet.getWindSpeedyDouble() >= 14.0 && ConnectionSevlet.getHumidityDouble() >=70.0){        
                        ConnectionSevlet.SendMessage("viny_user", "86588528Carvalho", "+"+ListUser.get(1).getNumber_phone(), nivel01);  

                    }else if(ConnectionSevlet.getWindgustDouble() >= 17.0 && ConnectionSevlet.getWindSpeedyDouble() >= 16.0 && ConnectionSevlet.getHumidityDouble() >=70.5){               
                        ConnectionSevlet.SendMessage("viny_user", "86588528Carvalho", "+"+ListUser.get(2).getNumber_phone(), nivel02);
                
                    }else if(ConnectionSevlet.getWindgustDouble() >= 18.6 && ConnectionSevlet.getWindSpeedyDouble() >= 18.0 && ConnectionSevlet.getHumidityDouble() >=70.8){
                        ConnectionSevlet.SendMessage("viny_user", "86588528Carvalho", "+"+ListUser.get(3).getNumber_phone(), nivel03);
                    
                    }else   if(ConnectionSevlet.getWindgustDouble() >= 19.0 && ConnectionSevlet.getWindSpeedyDouble() >= 19.0 && ConnectionSevlet.getHumidityDouble() >=71.2){
                        ConnectionSevlet.SendMessage("viny_user", "86588528Carvalho", "+"+ListUser.get(4).getNumber_phone(), nivel04);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //

        } catch ( IOException | InterruptedException e) {
            e.printStackTrace();
            out.println("<script>alert('ERRO! Na Conexao da API!!!')</script>");
            com = false;

        } catch (Exception e) {
            e.printStackTrace();
        }  
        
        
        if(com){
            resp.sendRedirect("/SGCD/HomeSystem");
        }
        
    }

        //getters e setters dos dados da api
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
        //
        
        //Metodo para enciar sms para os usuarios 
        public static void SendMessage(String userName, String password, String  to_phoneNumber, String message)throws Exception {
          String myURI = "https://api.bulksms.com/v1/messages";
          String myUsername = ""+userName+"";
          String myPassword = ""+password+"";
          String myData = "{to: \""+to_phoneNumber+"\", encoding: \"UNICODE\", body: \""+message+"\"}";

          URL url = new URL(myURI);
          HttpURLConnection request = (HttpURLConnection) url.openConnection();
          request.setDoOutput(true);

          String authStr = myUsername + ":" + myPassword;
          String authEncoded = Base64.getEncoder().encodeToString(authStr.getBytes());
          request.setRequestProperty("Authorization", "Basic " + authEncoded);

          request.setRequestMethod("POST");
          request.setRequestProperty( "Content-Type", "application/json");

          OutputStreamWriter out = new OutputStreamWriter(request.getOutputStream());
          out.write(myData);
          out.close();
      
          try {
           
            InputStream response = request.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(response));
            String replyText;
            while ((replyText = in.readLine()) != null) {
              System.out.println(replyText);
            }
            in.close();
          } catch (IOException ex) {
            System.out.println("An error occurred:" + ex.getMessage());
            BufferedReader in = new BufferedReader(new InputStreamReader(request.getErrorStream()));
            // print the detail that comes with the error
            String replyText;
            while ((replyText = in.readLine()) != null) {
              System.out.println(replyText);
            }
            in.close();
          }
          request.disconnect();
        }
      
  
        
        //getter e setter das mensagens de alerta
        public static String getNivel01() {
            return nivel01;
        }
        public static void setNivel01(String nivel01) {
            ConnectionSevlet.nivel01 = nivel01;
        }
        public static String getNivel02() {
            return nivel02;
        }
        public static void setNivel02(String nivel02) {
            ConnectionSevlet.nivel02 = nivel02;
        }
        public static String getNivel03() {
            return nivel03;
        }
        public static void setNivel03(String nivel03) {
            ConnectionSevlet.nivel03 = nivel03;
        }
        public static String getNivel04() {
            return nivel04;
        }
        public static void setNivel04(String nivel04) {
            ConnectionSevlet.nivel04 = nivel04;
        }
}


