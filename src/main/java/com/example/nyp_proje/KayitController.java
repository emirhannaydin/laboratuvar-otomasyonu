package com.example.nyp_proje;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class KayitController {

    @FXML
    private Label label1,label2,label3,label4,label5,label6,label7,label8;
    @FXML
    private PasswordField p1;

    @FXML
    private TextField t1,t3,t4,t5,t6,t7;

    @FXML
    private DatePicker date;

    @FXML
    private Button kayit_ol,sifirla,ana_menu;


    public void kayit(ActionEvent event) throws IOException, SQLException
    {

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        PreparedStatement statement = null;




        connectDB = connectNow.getConnection();

        String kayit ="INSERT INTO Hasta(Kullanici_Adi,Password,Hasta_Adi,Hasta_Soyadi,Dogum_Tarihi,Cinsiyet,Kilo,Boy)"+
                "Values (?,?,?,?,?,?,?,?)";

            statement = connectDB.prepareStatement(kayit);
            statement.setString(1,t1.getText());
            statement.setString(2,p1.getText());
            statement.setString(3,t3.getText());
            statement.setString(4,t4.getText());
            statement.setString(5,date.getValue().toString());
            statement.setString(6,t5.getText());
            statement.setString(7,t6.getText());
            statement.setString(8,t7.getText());

            statement.executeUpdate();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("ana-menu.fxml"));
                Parent root = loader.load();
                AnaMenuController controller = loader.getController();
                Stage stage = (Stage) kayit_ol.getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();



                }

    public void ana_menu() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ana-menu.fxml"));
        Parent root = loader.load();
        AnaMenuController controller = loader.getController();
        Stage stage = (Stage) ana_menu.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void sifirla() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("kayit.fxml"));
        Parent root = loader.load();
        KayitController controller = loader.getController();
        Stage stage = (Stage) sifirla.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

            }










