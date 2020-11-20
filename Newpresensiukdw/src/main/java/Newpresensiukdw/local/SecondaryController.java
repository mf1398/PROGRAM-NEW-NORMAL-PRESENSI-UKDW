/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Newpresensiukdw.local;

/**
 *
 * @author ferdinand
 */
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import Newpresensiukdw.local.App;
import Newpresensiukdw.local.App;

/**
 * FXML Controller class
 *
 * @author ferdinand
 */
public class SecondaryController implements Initializable {


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void kelas(ActionEvent event) throws IOException {
        App.setRoot("menu kelas");
    }

     public void laporankelas(ActionEvent event) throws IOException {
        App.setRoot("laporanpresensi");
    }
    
    public void logout(ActionEvent event) throws IOException {
       App.setRoot("login");
    }
   
}
