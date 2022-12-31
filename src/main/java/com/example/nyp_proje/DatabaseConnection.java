package com.example.nyp_proje;

import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public Connection databaselink;

    public Connection getConnection(){
        String databaseName = "NYP_PROJE";
        String databaseUser = "root";
        String databasePassword = "Em_10526084354";
        String url = "jdbc:mysql://localhost/"+databaseName;

        try{
          Class.forName("com.mysql.cj.jdbc.Driver");
          databaselink = DriverManager.getConnection(url,databaseUser,databasePassword);

    } catch (Exception e) {
            e.printStackTrace();
        }
        return  databaselink;

    }


}
