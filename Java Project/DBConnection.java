package com.sjprogramming.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    static Connection con;   //global declaration of variable

    public static Connection createConnection(){       

        try{
            Class.forName("com.mysql.jdbc.Driver");      //used to get instance of the class with specified class name
            String user="root";                          //user name of my sql
            String pass="May 11 2004";                   //password of my sql
            String url = "jdbc:mysql://localhost:3306/student?autoReconnect=true&useSSL=false"; //provides a way of identifying a database so that the appropriate driver recognizes it and connects to it

            con= DriverManager.getConnection(url,user,pass);  //Driver manager class attempts to establish a connection to the database

           
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

        return con;
    }

}