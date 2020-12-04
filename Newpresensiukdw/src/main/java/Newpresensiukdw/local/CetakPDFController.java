/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Newpresensiukdw.local;

import Newpresensiukdw.local.App;
import static Newpresensiukdw.local.LoginController.con;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
//import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class CetakPDFController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
   /**
     * Initializes the controller class.
     */
     @FXML
    private TableView<Lpresensi> daftarmatkul;
    @FXML
    private TableColumn<Lpresensi, Integer> no;
    @FXML
    private TableColumn<Lpresensi, String> matkul;
    @FXML
    private TableColumn<Lpresensi, String> group;
    @FXML
    private TableColumn<Lpresensi, String> waktu;
    
    ObservableList<Lpresensi> listM;
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
   
    
    public ObservableList<Lpresensi> getMatkul(){
        ObservableList<Lpresensi> list = FXCollections.observableArrayList();
        try {
            //Connection c = DriverManager.getConnection(url);
            PreparedStatement ps = con.prepareStatement("select * from matkul");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){   
                list.add(new Lpresensi(Integer.parseInt(rs.getString("no")), rs.getString("matkul"), rs.getString("group"), rs.getString("waktu")));               
            }
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
            App.setRoot("presensi");
        } catch (SQLException e) {
            //App.setRoot("presensi");
        }
        //App.setRoot("presensi");
    }
    
    
    public void tampildataTabel(){
        no.setCellValueFactory(new PropertyValueFactory<Lpresensi, Integer>("no"));
        matkul.setCellValueFactory(new PropertyValueFactory<Lpresensi, String>("matkul"));
        group.setCellValueFactory(new PropertyValueFactory<Lpresensi, String>("group"));
        waktu.setCellValueFactory(new PropertyValueFactory<Lpresensi, String>("waktu"));
        listM = getMatkul();
        daftarmatkul.setItems(listM);
    }
    
   
    
    @FXML
    private void cetakpdf(ActionEvent event) throws IOException {
        App.setRoot("cetakPDF");
    }

    /**@FXML
   public void back(ActionEvent event) throws IOException {
        App.setRoot("secondary");
    }*/
    
}
