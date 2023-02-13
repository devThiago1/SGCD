package br.com.system;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class LoginSevlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String Login = request.getParameter("login");
       String Password = request.getParameter("password");
        if(Login.equals(Manager.getLogin()) && Password.equals(Manager.getPassword())){
            response.sendRedirect("/SGCD/system");
        }else{
            PrintWriter out = response.getWriter();
            out.println("<script>alert('Login ou Senha Invalida!!!')</script>");
        }
    }
}
