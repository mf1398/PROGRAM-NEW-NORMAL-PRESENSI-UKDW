/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Newpresensiukdw.local;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import static Newpresensiukdw.local.LoginController.con;

/**
 * FXML Controller class
 *
 * @author PPLK
 */
public class PresensiController implements Initializable {

    @FXML
    private TableColumn<presensi, Integer> id;
    @FXML
    private TableColumn<presensi, String> foto;
    @FXML
    private TableColumn<presensi, String> nim;
    @FXML
    private TableColumn<presensi, String> nama;
    @FXML
    private TableColumn<presensi, String> statuspresensi;
    @FXML
    private TableColumn<tanggal, String> tanggal;
    @FXML
    private TableColumn<matkul, String> matkul;
    @FXML
    private Button absen;
    @FXML
    private Button present;
    @FXML
    private Button hapusmahasiswa;
    @FXML
    private TableView<presensi> presensi;
    
    
    ObservableList<presensi> listM;
    String index;
    String namamatkul;
    String url = "jdbc:sqlite:DB\\test - Copy.db";
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tampildataTabel();
    }    
    
    public ObservableList<presensi> getPresensi(){
        ObservableList<presensi> list = FXCollections.observableArrayList();
        MenuKelasController mk = new MenuKelasController();
        namamatkul = Namakelas.NAMAKELAS;
        System.out.println(namamatkul);
        try {
            PreparedStatement ps = con.prepareStatement("select * from presensi WHERE matkul = ? ");
            ps.setString(1, namamatkul);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){   
                list.add(new presensi(Integer.parseInt(rs.getString("id")), rs.getString("foto"), rs.getString("nim"), rs.getString("nama"), rs.getString("presensi"), rs.getString("tanggal"), rs.getString("matkul")));               
            }
            ps.close();
        } catch (SQLException e) {
            
        }
        return list;
    }
    
    public void tampildataTabel(){
        id.setCellValueFactory(new PropertyValueFactory<presensi, Integer>("id"));
        foto.setCellValueFactory(new PropertyValueFactory<presensi, String>("foto"));
        nim.setCellValueFactory(new PropertyValueFactory<presensi, String>("nim"));
        nama.setCellValueFactory(new PropertyValueFactory<presensi, String>("nama"));
        statuspresensi.setCellValueFactory(new PropertyValueFactory<presensi, String>("presensi"));
        tanggal.setCellValueFactory(new PropertyValueFactory<tanggal, String>("tanggal"));
        matkul.setCellValueFactory(new PropertyValueFactory<matkul, String>("matkul"));
        listM = getPresensi();
        presensi.setItems(listM);
    }
    
    public void absen(){
        String sql = "UPDATE 'presensi' SET "
                + "presensi = 'Absen'"
                + "WHERE id=(SELECT id from 'presensi' WHERE matkul = ? ORDER BY id LIMIT ?,1)";
        int x = presensi.getSelectionModel().getSelectedIndex();
        try (
              PreparedStatement ps = con.prepareStatement(sql)) {
              ps.setString(1, namamatkul);
              ps.setInt(2, x);
              ps.executeUpdate();
              ps.close();
        }catch( SQLException e ) {
           System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
       tampildataTabel();
    }
    
    public void present(){
        String sql = "UPDATE 'presensi' SET "
                + "presensi = 'Hadir'"
                + "WHERE id=(SELECT id from 'presensi' WHERE matkul = ? ORDER BY id LIMIT ?,1)";
        int x = presensi.getSelectionModel().getSelectedIndex();
        try (
              //Connection c = DriverManager.getConnection(url);
              PreparedStatement ps = con.prepareStatement(sql)) {
              ps.setString(1, namamatkul);
              ps.setInt(2, x);
              ps.executeUpdate();
              ps.close();
        }catch( SQLException e ) {
           System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
       tampildataTabel();
    }
    
    public void hapusmahasiswa(){
        String sql = "DELETE FROM 'presensi' "
                + "WHERE id=(SELECT id from 'presensi' WHERE matkul = ? ORDER BY id LIMIT ?,1)";
        int x = presensi.getSelectionModel().getSelectedIndex();
        try (
              //Connection c = DriverManager.getConnection(url);
              PreparedStatement ps = con.prepareStatement(sql)) {
              ps.setString(1, namamatkul);
              ps.setInt(2, x);
              ps.executeUpdate();
              ps.close();
        }catch( SQLException e ) {
           System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
       tampildataTabel();
    }
    
    public void back(ActionEvent event) throws IOException {
        App.setRoot("menu kelas");
    }
    
    public void tambahmanusia(ActionEvent event) throws IOException {
        App.setRoot("TambahSiswa");
    }

    private static class tanggal {

        public tanggal() {
        }
    }

    private static class matkul {

        public matkul() {
        }
    }

}
