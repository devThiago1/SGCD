package br.com.system;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/viewsMassage")
public class viewsMassageServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
       PrintWriter out = response.getWriter();
       out.println("<!DOCTYPE html>");
       out.println("<html lang='pr-br'>");
       out.println("<head><meta charset='UTF-8'><meta http-equiv='X-UA-Compatible' content='IE=edge'><meta name='viewport' content='width=device-width, initial-scale=1.0'><title>Editar Mensagens</title><link href='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65' crossorigin='anonymous'>");
       out.println("<style>.conteiner{margin-left: 1.5cm;margin-right: 1.5cm;}.btn{padding: 10px 50px 10px 50px;background: #fff;}.btn:hover{border: 1px solid #fff;background: none;transition: all .50s ease;transform: scale(1.01);color: #fff;}a{text-decoration: none; }.navbarul li{list-style: none;margin-top: 15px;margin-left: -10cm;}.a a{margin-right: 1cm;color: black;font-weight: 500;}.a a:hover{color: #fff;transition: all .50s ease;}header{background: #0394E7;}.navbar{background: #0394E7;}</style>");
       out.println("</head>");
       out.println("<body>");
       out.println("<header><div class='conteiner'><nav class='navbar'><div class='container-fluid'><a class='navbar-brand' href='#'><img src='images/Logo4.png' alt='SGCD' width='200px' height='90px'></a><ul class='navbarul'><li class='a'><a href='/SGCD/HomeSystem'>Home</a><a href='/SGCD/viewsMassage'>Editar Mensagem</a></li></ul><form class='d-flex' action='system'><input class='btn btn-outline ' type='submit' value='Recarregar Dados API'></input></form></div></nav></div></header>");
       out.println("<section class='text-center'><div class='card mx-4 mx-md-5 shadow-5-strong' style='margin-top: 40px;margin-bottom: 40px;background: hsla(0, 0%, 100%, 0.8);backdrop-filter: blur(30px);'><div class='card-body py-5 px-md-5'><div class='row d-flex justify-content-center'><div class='col-lg-8'><h2 class='fw-bold mb-5'>Edit Message</h2>");
       out.println("<form method='post' action='EditMassage'><!--Mensagens--><div class='form-outline mb-4'><select name='nivel' id=''class='form-control' for='form3Example3' style='background: #0394E7; padding: 10px 10px 10px 10px; cursor: pointer; color: black;'><option value=''>Mensagens</option><option value='1'>Nivel 1: "+ConnectionSevlet.getNivel01()+"</option><option value='2'>Nivel 2: "+ConnectionSevlet.getNivel02()+"</option><option value='3'>Nivel 3: "+ConnectionSevlet.getNivel03()+"</option><option value='4'>Nivel 4: "+ConnectionSevlet.getNivel04()+"</option></select></div><br>");
       out.println("<!--input type:text->name:massege-new --><div class='form-outline mb-4'><label class='form-label' for='form3Example1'>Digite a Nova Mensagem:</label><input type='text' id='form3Example1' class='form-control' name='message-new' placeholder='Nova Mensagem...' required /></div>");
       out.println("<!-- Checkbox --><div class='form-check d-flex justify-content-center mb-4'><input class='form-check-input me-2' type='checkbox' value='Editar' id='form2Example33' required checked /><label class='form-check-label' for='form2Example33'>Tenho certeza.</label></div><input type='submit' value='Editar' class='btn  btn-block mb-4' style='background:#0394E7; '></form></div></div></div></div>");
       out.println("</section>");
       out.println(" <footer><div class='containerF' style='padding: 20px 70px 20px 70px; background: #0394E7; align-items: center;'><p class='mb-1 ' style='padding: 20px 70px 20px 70px; margin-left: 10cm;'>Todos direiros Reservador | Qualquer Problema Contacte o suporte</p>  </div><script type='module' src='https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js'></script><script nomodule src='https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js'></script></footer>");
      out.println(" <script src='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js' integrity='sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4' crossorigin='anonymous'></script>");
      out.println("</body>");
      out.println("</html>");
      //metodo esperta para mandar a mensagem de comfirmação e direcionando
      String con = req.getParameter("conn");
      Boolean conn = Boolean.parseBoolean(con);
      if(conn){
        out.println("<script>alert('Mensagem Editada Com Sucesso!!!')</script>");
      }
      
      

    }
}
