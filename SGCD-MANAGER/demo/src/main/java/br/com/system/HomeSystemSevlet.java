package br.com.system;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HomeSystem")
public class HomeSystemSevlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
       PrintWriter out = response.getWriter();

      out.println("<!DOCTYPE html>");
      out.println("<html lang='pt-br'>");
      out.println("<head><meta charset='UTF-8'><meta http-equiv='X-UA-Compatible' content='IE=edge'><meta name='viewport' content='width=device-width, initial-scale=1.0'><link href='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65' crossorigin='anonymous'><title>System::Gestor</title>");
      out.println("<style>");
      out.println(" .conteiner{margin-left: 1.5cm;margin-right: 1.5cm;}.btn{padding: 10px 50px 10px 50px;background: #fff;}.btn:hover{border: 1px solid #fff;background: none;transition: all .50s ease;transform: scale(1.01);color: #fff;}a{text-decoration: none; }.navbarul li{list-style: none;margin-top: 15px;margin-left: -10cm;}.a a{margin-right: 1cm;color: black;font-weight: 500;}.a a:hover{color: rgba(255, 255, 255, 0.349);transition: all .50s ease;}header{background: #0394E7;}.navbar{background: #0394E7;}.cards{margin-left: 6cm;margin-right: 6cm;}.threeCard{ margin-bottom: 1cm;margin-top: 1cm;}.color{font-size: 18px;}");
      out.println("</style>");
      out.println("</head>");
      out.println("<body>");
      out.println("<header>");
      out.println("<div class='conteiner'><nav class='navbar'><div class='container-fluid'><a class='navbar-brand' href='#'><img src='images/Logo4.png' alt='SGCD' width='200px' height='90px'></a><ul class='navbarul'><li class='a'><a href='/SGCD/HomeSystem'>Home</a><a href='/SGCD/viewsMassage'>Editar Mensagem</a></li></ul><form class='d-flex' action='system'><input class='btn btn-outline ' type='submit' value='Recarregar Dados API'></input></form></div></nav></div>");
      out.println("</header>");
      out.println("<div class='cards d-block'>");
          out.println("<div class='threeCard d-flex justify-content-between'>");
              out.println("<div class='card text-bg-dark' style='width: 290px; height: 200px;'><img src='images/pressure.avif' class='card-img' alt='...' height='200px;' style='opacity: 0.3;'><div class='card-img-overlay'><div class='color'><h4 class='card-title '>Pressure</h4><p class='card-text'>"+ConnectionSevlet.getPressureDouble()+" mb</p><p class='card-text'><small> Ultima Atualizacao: " +ConnectionSevlet.getDatetimeString()+"</small></p></div></div></div>");
              out.println(" <div class='card text-bg-dark' style='width: 290px; height: 200px;'><img src='images/windSpeedy.jpg' class='card-img' alt='...' height='200px;' style='opacity: 0.3;'><div class='card-img-overlay'><div class='color'><h4 class='card-title '>WindSpeedy</h4><p class='card-text'>"+ConnectionSevlet.getWindSpeedyDouble()+" m/s</p><p class='card-text'><small> Ultima Atualizacao: " +ConnectionSevlet.getDatetimeString()+"</small></p></div></div></div>");
              out.println("<div class='card text-bg-dark' style='width: 290px; height: 200px;'><img src='images/humidity.jpg' class='card-img' alt='...' height='200px;' style='opacity: 0.3;'><div class='card-img-overlay'><div class='color'><h4 class='card-title'>Humidity</h4><p class='card-text'>"+ConnectionSevlet.getHumidityDouble()+"%</p><p class='card-text'><small> Ultima Atualizacao:"+ConnectionSevlet.getDatetimeString()+"</small></p></div></div></div></div>");
          out.println("<div class='threeCard d-flex justify-content-between'>");
              out.println(" <div class='card text-bg-dark' style='width: 290px; height: 200px;'><img src='images/condition.jpg' class='card-img' alt='...' height='200px;' style='opacity: 0.3;'><div class='card-img-overlay'><div class='color'><h4 class='card-title '>Condition</h4><p class='card-text'>"+ConnectionSevlet.getConditionString()+"</p><p class='card-text'><small> Ultima Atualizacao: " +ConnectionSevlet.getDatetimeString()+"</small></p></div></div></div>");
              out.println("<div class='card text-bg-dark' style='width: 290px; height: 200px;'><img src='images/windgust.jpg' class='card-img' alt='...' height='200px;' style='opacity: 0.3;'><div class='card-img-overlay'><div class='color'><h4 class='card-title '>WindGust</h4><p class='card-text'>"+ConnectionSevlet.getWindgustDouble()+" m/s</p><p class='card-text'><small> Ultima Atualizacao: " +ConnectionSevlet.getDatetimeString()+"</small></p></div></div></div>");
              out.println("<div class='card text-bg-dark' style='width: 290px; height: 200px;'><img src='images/description.jpg' class='card-img' alt='...' height='200px;' style='opacity: 0.3;'><div class='card-img-overlay'><div class='color'><h5 class='card-title '>Description</h5><p class='card-text'>"+ConnectionSevlet.getDescripitionString()+"</p><p class='card-text'><small> Ultima Atualizacao: " +ConnectionSevlet.getDatetimeString()+"</small></p></div></div></div></div>");
          out.println("</div>");
      out.println("</div>");
      out.println(" <footer><div class='containerF' style='padding: 15px 70px 20px 70px; background: #0394E7; align-items: center;'><p class='mb-1 ' style='padding: 10px 70px 20px 70px; margin-left: 10cm;'>Todos direiros Reservador | Qualquer Problema Contacte o suporte</p>  </div><script type='module' src='https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js'></script><script nomodule src='https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js'></script></footer>");
      out.println(" <script src='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js' integrity='sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4' crossorigin='anonymous'></script>");
      out.println("</body>");
      out.println("</html>");
      out.println("");
      out.println("");

    }
}
