/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Newpresensiukdw.local;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import static Newpresensiukdw.local.LoginController.con;
/**
 * FXML Controller class
 *
 * @author PPLK
 */
public class MenuKelasController implements Initializable {

    @FXML
    private TableView<daftarMatkul> daftarmatkul;
    @FXML
    private TableColumn<daftarMatkul, Integer> no;
    @FXML
    private TableColumn<daftarMatkul, String> matkul;
    @FXML
    private TableColumn<daftarMatkul, String> group;
    @FXML
    private TableColumn<daftarMatkul, String> waktu;
    
    ObservableList<daftarMatkul> listM;
    public String namakelas;
    String url = "jdbc:sqlite:DB\\test - Copy.db";
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tampildataTabel();
    }    
   
    
    public ObservableList<daftarMatkul> getMatkul(){
        ObservableList<daftarMatkul> list = FXCollections.observableArrayList();
        try {
            //Connection c = DriverManager.getConnection(url);
            PreparedStatement ps = con.prepareStatement("select * from matkul");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){   
                list.add(new daftarMatkul(Integer.parseInt(rs.getString("no")), rs.getString("matkul"), rs.getString("group"), rs.getString("waktu")));               
            }
            ps.close();
        } catch (SQLException e) {
            
        }
        return list;
    }
    
    public void back(ActionEvent event) throws IOException {
        App.setRoot("secondary");
    }
    
    public void next(ActionEvent event) throws IOException {
        String sql = "SELECT * FROM matkul "
                + "WHERE no = ?";
        int temp = 1+daftarmatkul.getSelectionModel().getSelectedIndex();
        try {
            //Connection c = DriverManager.getConnection(url);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, temp);
            ResultSet rs = ps.executeQuery();
            Namakelas.NAMAKELAS = rs.getString("matkul");
            ps.close();
            App.setRoot("presensi");
        } catch (SQLException e) {
            //App.setRoot("presensi");
        }
        //App.setRoot("presensi");
    }
    
    
    public void tampildataTabel(){
        no.setCellValueFactory(new PropertyValueFactory<daftarMatkul, Integer>("no"));
        matkul.setCellValueFactory(new PropertyValueFactory<daftarMatkul, String>("matkul"));
        group.setCellValueFactory(new PropertyValueFactory<daftarMatkul, String>("group"));
        waktu.setCellValueFactory(new PropertyValueFactory<daftarMatkul, String>("waktu"));
        listM = getMatkul();
        daftarmatkul.setItems(listM);
    }
    

    
}
