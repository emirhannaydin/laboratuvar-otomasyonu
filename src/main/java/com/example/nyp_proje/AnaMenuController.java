package com.example.nyp_proje;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.sql.Connection;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;

public class AnaMenuController extends TestController{


    @FXML
    public TextField kullanici_text,sifre_text;

    @FXML
    private Label kullanici_adi,sifre,baslik,cikti;
    @FXML
    private Pane pane;

    @FXML
    private Button hasta_giris,doktor_giris,kayit;

    @FXML
    private Line line;
    @FXML
    private ImageView tip_sembol;

    public void kayit() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("kayit.fxml"));
        Parent root = loader.load();
        KayitController controller = loader.getController();
        Stage stage = (Stage) kayit.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }





    public void validateLogin(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "SELECT count(1) from hasta where isim = '"+kullanici_text.getText()+"' and soyisim = '"+sifre_text.getText()+"';";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while ((queryResult.next())){
                if(queryResult.getInt(1)==1){
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("giris.fxml"));
                    Parent root = loader.load();
                    KayitController controller = loader.getController();
                    Stage stage = (Stage) kayit.getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();

                }
                else {
                    System.out.println("asdd");
                }

            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void hasta_girisi(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "SELECT count(1) from hasta where kullanici_adi = '"+kullanici_text.getText()+"' and password = '"+sifre_text.getText()+"';";
        try {
            Statement statement = connectDB.createStatement();

            ResultSet queryResult = statement.executeQuery(verifyLogin);


            while ((queryResult.next())){
                if (kullanici_text.getText().equals("") || (sifre_text.getText().equals(""))){
                    cikti.setText("Kullanıcı adı veya parola boş bırakılamaz");
                }
                else{
                    if(queryResult.getInt(1)==1){
                        cikti.setText("Giriş Başarılı");
                        TestController.setCurrHasta(kullanici_text.getText());
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("test.fxml"));
                        Parent root = loader.load();
                        TestController controller = loader.getController();
                        Stage stage = (Stage) hasta_giris.getScene().getWindow();
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();

                    }
                    else {
                        cikti.setText("Kullanıcı adı veya şifre yanlış");
                    }
                }

            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void doktor_girisi(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "SELECT count(1) from personel where kullanici_adi = '"+kullanici_text.getText()+"' and password = '"+sifre_text.getText()+"';";
        try {
            Statement statement = connectDB.createStatement();

            ResultSet queryResult = statement.executeQuery(verifyLogin);


            while ((queryResult.next())){
                if (kullanici_text.getText().equals("") || (sifre_text.getText().equals(""))){
                    cikti.setText("Kullanıcı adı veya parola boş bırakılamaz");
                }
                else{
                    if(queryResult.getInt(1)==1){
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("hasta_ekrani.fxml"));
                        Parent root = loader.load();
                        HastaController controller = loader.getController();
                        Stage stage = (Stage) doktor_giris.getScene().getWindow();
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();


                    }
                    else {
                        cikti.setText("Kullanıcı adı veya şifre yanlış");
                    }
                }

            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}