package com.example.nyp_proje;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class YeniTestController {

    @FXML
    private Label hasta,test,birim,deger,label1,hata;

    @FXML
    private TextField text1,text2,text3,text4;

    @FXML
    private Button ana_menu,ekle;


    public void kayit(ActionEvent event) throws IOException, SQLException
    {


        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        PreparedStatement statement = null;




        connectDB = connectNow.getConnection();

        try{
        String kayit ="INSERT INTO Test(Hasta_ID,Test_Turu,Birim_Adi,Deger)"+
                "Values (?,?,?,?)";

        statement = connectDB.prepareStatement(kayit);
        statement.setString(1,text1.getText());
        statement.setString(2,text2.getText());
        statement.setString(3,text3.getText());
        statement.setString(4,text4.getText());


        statement.executeUpdate();



        FXMLLoader loader = new FXMLLoader(getClass().getResource("hasta_ekrani.fxml"));
        Parent root = loader.load();
        HastaController controller = loader.getController();
        Stage stage = (Stage) ekle.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();}

        catch (Exception e){
            hata.setText("Girilen ID'ye kayıtlı hasta bulunamamıştır.");
        }



    }

    public void ana_menu() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hasta_ekrani.fxml"));
        Parent root = loader.load();
        HastaController controller = loader.getController();
        Stage stage = (Stage) ana_menu.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }




}


