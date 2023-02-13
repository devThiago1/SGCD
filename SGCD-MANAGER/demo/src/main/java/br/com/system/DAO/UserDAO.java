package br.com.system.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import br.com.system.model.ConnSQL;
import br.com.system.model.User;

public class UserDAO extends ConnSQL{
    
    public Boolean Insert(User user) throws ClassNotFoundException {
        Connect();
        String sql = "INSERT INTO users(first_name_user,last_name_user,number_user,cpf_user,email_user,password_user)VALUES(?,?,?,?,?,?)";
        PreparedStatement stmt =  (PreparedStatement) Stmt_Return(sql, Statement.RETURN_GENERATED_KEYS);
       
            try {
                stmt.setString(1,user.getFirst_name());
                stmt.setString(2,user.getLast_name());
                stmt.setString(3,user.getNumber_phone());
                stmt.setString(4,user.getCpf_user());
                stmt.setString(5,user.getEmail_user());   
                stmt.setString(6,user.getPassword_user());
                stmt.execute();
            } catch (SQLException e) {
               java.util.logging.Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE,null,e);
            }
        Desconect();
        return true;
    }

    public List<User> getListUser() throws ClassNotFoundException{
        List<User> ListUser = new ArrayList<>();
       
        Connect();
        ResultSet results = null;
        PreparedStatement stmt = null;

        String sql = "SELECT * FROM users WHERE id_user";
         try {
            stmt = (PreparedStatement) Stmt(sql);   
            results = stmt.executeQuery();
            while(results.next()){
                User user = new User();
                user.setId_user(results.getInt(1));
                user.setFirst_name(results.getString(2));
                user.setLast_name(results.getString(3));
                user.setNumber_phone(results.getString(4));
                user.setCpf_user(results.getString(5));
                user.setEmail_user(results.getString(6));
                user.setCodeadress(results.getInt(8));
                ListUser.add(user);
            }
            
                System.out.println();
            
           
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Desconect();
        return ListUser;
    }

}