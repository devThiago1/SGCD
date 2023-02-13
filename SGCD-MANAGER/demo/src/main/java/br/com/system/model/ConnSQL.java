package br.com.system.model;


import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

public class ConnSQL  {
   private Connection conn = null;
    public  Boolean Connect() {
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost/sgcd","root","");
          
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERRO: "+e.getMessage());
            return false;
        }
        return true;
    }

    public Boolean Desconect() {
        try{
            if(this.conn.isClosed() == false){
                this.conn.close();
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERRO: "+e.getMessage());
            return false;
        }
        return true;       
    }
    public PreparedStatement Stmt_Return(String ComandSQL, int RETURN_GENERATED_KEYS){
        try {
            return (PreparedStatement) this.conn.prepareStatement(ComandSQL,RETURN_GENERATED_KEYS);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        }
    }

    public PreparedStatement Stmt(String ComandSQL){
        try {
            return (PreparedStatement) this.conn.prepareStatement(ComandSQL);
        } catch (Exception e) {
            return null;
        }
    }




}

