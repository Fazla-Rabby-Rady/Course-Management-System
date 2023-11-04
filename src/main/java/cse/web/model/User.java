package cse.web.model;

public class User {

    private String id;
    private  String reg;
    private String name;
    private  String email;
    private  String password;
    private  String dept;

    private  String role;
    public User(){

    }
    public  User(String id,String reg,String name,String email,String password,String dept,String role){
        this.id=id;
        this.reg=reg;
        this.name=name;
        this.email=email;
        this.password=password;
        this.dept=dept;
        this.role=role;


    }
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id=id;
    }

    public String getReg(){
        return reg;
    }
    public void setReg(String reg){
        this.reg=reg;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }

    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }

    public String getDept(){
        return dept;
    }
    public void setDept(String dept){
        this.dept=dept;
    }

    public String getRole(){
        return role;
    }
    public void setRole(String role){
        this.role=role;
    }

}
