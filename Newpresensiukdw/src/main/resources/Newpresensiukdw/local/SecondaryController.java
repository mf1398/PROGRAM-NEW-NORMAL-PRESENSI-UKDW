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

/**
 * FXML Controller class
 *
 * @author joedh
 */
public class SecondaryController implements Initializable {

    @FXML
    private Button tambahSiswa;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void tambahSiswa(ActionEvent event) throws IOException {
        App.setRoot("tambahSiswa");
    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
       App.setRoot("login");
    }
    
}
