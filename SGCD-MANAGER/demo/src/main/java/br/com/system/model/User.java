package br.com.system.model;


public class User {
    private int id_user;
    private String first_name;
    private String last_name;
    private String number_phone;
    private String cpf_user;
    private String email_user;
    private String password_user;
    private int Codeadress;
    
    public int getCodeadress() {
        return Codeadress;
    }
    public void setCodeadress(int codeadress) {
        Codeadress = codeadress;
    }
    public int getId_user() {
        return id_user;
    }
    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
    public String getFirst_name() {
        return first_name;
    }
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    public String getLast_name() {
        return last_name;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    public String getNumber_phone() {
        return number_phone;
    }
    public void setNumber_phone(String number_phone) {
        this.number_phone = number_phone;
    }
    public String getCpf_user() {
        return cpf_user;
    }
    public void setCpf_user(String cpf_user) {
        this.cpf_user = cpf_user;
    }
     public String getEmail_user() {
        return email_user;
    }
    public void setEmail_user(String email_user) {
        this.email_user = email_user;
    }
    public String getPassword_user() {
        return password_user;
    }
    public void setPassword_user(String password_user) {
        this.password_user = password_user;
    }

}