/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Newpresensiukdw.local;

import static Newpresensiukdw.local.LoginController.con;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author Acer
 */
public class TambahSiswaController implements Initializable {


    @FXML
    private TextField usernameField;
    @FXML
    private TextField usernameField1;
    @FXML
    private TextField usernameField2;
    @FXML
    private Button submitButton;
    @FXML
    private Button submitButton1;
    /**
     * Initializes the controller class.
     */
    String sql ="";
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void back(ActionEvent event) throws IOException {
        App.setRoot("presensi");
    }
    public void tambah(ActionEvent event) throws IOException{
        sql = "INSERT INTO 'presensi' (nim, nama, matkul, presensi) VALUES (?, ?, ?, 'Hadir')";
        String nim = usernameField1.getText();
        String nama = usernameField2.getText();
        String matkul = usernameField.getText();
        try{
                
                PreparedStatement ps = con.prepareStatement(sql); 
                ps.setString(1, nim);
                ps.setString(2, nama);
                ps.setString(3, matkul);
                System.out.println("play");
                ps.executeUpdate();
                System.out.println("sukses");
                ps.close();
            }catch( SQLException e ) {
           System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }

}
