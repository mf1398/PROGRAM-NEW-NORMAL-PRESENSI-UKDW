/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Newpresensiukdw.local;

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
 * @author Acer
 */
public class LaporanpresensiController implements Initializable {

    /**
     * Initializes the controller class.
     */
    public void back(ActionEvent event) throws IOException {
        App.setRoot("secondary");
    }
    public void cetakpdf(ActionEvent event) throws IOException {
        App.setRoot("CetakPDF");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

 
    
}
