package br.com.system;

public class Manager {
    

    private static  String name= "Vinicius";
    private static String login = "vvv";
    private static String password= "007";
 

    public static String getName() {
        return name;
    }
    public static void setName(String name) {
        Manager.name = name;
    }
    public static String getLogin() {
        return login;
    }
    public static void setLogin(String loginN) {
        login = loginN;
    }
    public static String getPassword() {
        return password;
    }
    public static void setPassword(String password) {
        Manager.password = password;
    }
}


