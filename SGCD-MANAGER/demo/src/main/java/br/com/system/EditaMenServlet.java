package br.com.system;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EditMassage")
public class EditaMenServlet extends HttpServlet {
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    PrintWriter out = response.getWriter();
    String nivel = request.getParameter("nivel");
    String message = request.getParameter("message-new");
    int nivelInt = Integer.parseInt(nivel);
    if(UpdateMessage(nivelInt, message)){
    response.sendRedirect("/SGCD/viewsMassage?conn="+true);
    }else{
    out.println("<script>alert('ERRO! Na Edição da Mensagem!!!')</script>");
    }
    

}
   
    public Boolean UpdateMessage(int nivelInt, String message) {
        if(nivelInt == 1){
            ConnectionSevlet.setNivel01(message);
            return true;
        }else if(nivelInt == 2){
            ConnectionSevlet.setNivel02(message);
            return true;
        }else if(nivelInt == 3){
            ConnectionSevlet.setNivel03(message);
            return true;
        }else if(nivelInt == 4){
            ConnectionSevlet.setNivel04(message);
            return true;
        }else
            return false;

        
    } 
}

