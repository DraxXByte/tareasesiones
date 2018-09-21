/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;
import java.sql.*;


/**
 *
 * @author Alumno
 */
public class Conexion {
    String url;
    String User;
    String Pass;
    Connection con;
    Statement sta;
    ResultSet res;
    
    public Conexion(){
        url="jdbc:mysql://localhost/lab3";
        User="root";
        Pass="n0m3l0";
    }
    
    public String Con(String nombre, String contra){
        String k="No";
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url, User, Pass);
            sta=con.createStatement();
            
            res=sta.executeQuery("select * from Usuario where Usuario='"+nombre+"' and Contraseña='"+contra+"';");
            if(res.next()){
                k="Listo";
            }
            else{
                k="Falso";
            }
        }
        
        catch(Exception e){
            System.out.println(e.getMessage());
        }
         
        return k;
    }
}
