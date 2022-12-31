package com.example.nyp_proje;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;


public class TumTestController implements Initializable{
    public static String currHasta;
    public static void setCurrHasta(String currHasta) {
        TestController.currHasta = currHasta;
    }


    @FXML
    private TableView<HastaTest> hasta;
    @FXML
    private TableColumn<HastaTest,Integer> id;
    @FXML
    private TableColumn <HastaTest,String> name;
    @FXML
    private TableColumn <HastaTest,String> surname;
    @FXML
    private TableColumn <HastaTest,String> cinsiyet;
    @FXML
    private TableColumn <HastaTest,String> test_turu;
    @FXML
    private TableColumn <HastaTest,String> birim_adi;
    @FXML
    private TableColumn <HastaTest,Integer> deger;
    @FXML
    private Label label;
    @FXML
    private Button button1;

    public void ana_menu() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hasta_ekrani.fxml"));
        Parent root = loader.load();
        HastaController controller = loader.getController();
        Stage stage = (Stage) button1.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }




    public static ObservableList<HastaTest> veri_cek() throws SQLException {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        ObservableList<HastaTest> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = connectDB.prepareStatement("select hasta.hasta_id,hasta_adi,hasta_soyadi,cinsiyet,test_turu,birim_adi,deger from hasta,test where test.hasta_id = hasta.hasta_id order by hasta.hasta_id");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new HastaTest(rs.getInt("hasta_id"), rs.getString("hasta_adi"), (rs.getString("hasta_soyadi")), rs.getString("cinsiyet"), rs.getString("Test_turu"),rs.getString("Birim_adi"),rs.getInt("Deger")));
            }

        }
        catch (Exception e){

        }


        return list;


    }

    ObservableList<HastaTest> listM;
    int index = -1;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        if(this.hasta!=null){
            id.setCellValueFactory(new PropertyValueFactory<HastaTest,Integer>("id"));
            name.setCellValueFactory(new PropertyValueFactory<HastaTest,String>("hasta_adi"));
            surname.setCellValueFactory(new PropertyValueFactory<HastaTest,String>("hasta_soyadi"));
            cinsiyet.setCellValueFactory(new PropertyValueFactory<HastaTest, String >("Cinsiyet"));
            test_turu.setCellValueFactory(new PropertyValueFactory<HastaTest,String>("Test_turu"));
            birim_adi.setCellValueFactory(new PropertyValueFactory<HastaTest,String >("Birim_adi"));
            deger.setCellValueFactory(new PropertyValueFactory<HastaTest,Integer>("Deger"));

            try {
                listM = veri_cek();
                hasta.setItems(listM);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
