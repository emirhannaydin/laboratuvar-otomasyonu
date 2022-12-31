package com.example.nyp_proje;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class HastaController implements Initializable{

    @FXML
    private TableView<Hasta> hasta;
    @FXML
    private TableColumn <Hasta,Integer> id;
    @FXML
    private TableColumn <Hasta,String> name;
    @FXML
    private TableColumn <Hasta,String> surname;
    @FXML
    private TableColumn <Hasta, Date> date;
    @FXML
    private TableColumn <Hasta,String> gender;
    @FXML
    private TableColumn <Hasta,Integer> weight;
    @FXML
    private TableColumn <Hasta,Integer> height;
    @FXML
    private Label label;
    @FXML
    private Button button1,button2,button3;


    public void ana_menu() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ana-menu.fxml"));
        Parent root = loader.load();
        AnaMenuController controller = loader.getController();
        Stage stage = (Stage) button1.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static ObservableList <Hasta> veri_cek() throws SQLException {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        ObservableList<Hasta> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = connectDB.prepareStatement("SELECT hasta_id,hasta_adi,hasta_soyadi,dogum_tarihi,cinsiyet,kilo,boy from hasta");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Hasta(Integer.parseInt(rs.getString("hasta_id")), rs.getString("hasta_adi"), (rs.getString("hasta_soyadi")), (rs.getDate("dogum_tarihi")), rs.getString("cinsiyet"), rs.getInt("kilo"), rs.getInt("boy")));
            }

        }
        catch (Exception e){

        }


        return list;


    }


    ObservableList<Hasta> listM;
    int index = -1;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setCellValueFactory(new PropertyValueFactory<Hasta,Integer>("id"));
        name.setCellValueFactory(new PropertyValueFactory<Hasta,String>("hasta_adi"));
        surname.setCellValueFactory(new PropertyValueFactory<Hasta,String>("hasta_soyadi"));
        date.setCellValueFactory(new PropertyValueFactory<Hasta, Date>("dogum_tarihi"));
        gender.setCellValueFactory(new PropertyValueFactory<Hasta,String>("Cinsiyet"));
        weight.setCellValueFactory(new PropertyValueFactory<Hasta,Integer>("Kilo"));
        height.setCellValueFactory(new PropertyValueFactory<Hasta,Integer>("Boy"));

        try {
            listM = veri_cek();
            hasta.setItems(listM);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void yeni_test() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("yeni_test.fxml"));
        Parent root = loader.load();
        YeniTestController controller = loader.getController();
        Stage stage = (Stage) button2.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    public void tum_testler() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Tum_Test.fxml"));
        Parent root = loader.load();
        TumTestController controller = loader.getController();
        Stage stage = (Stage) button3.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }




}
