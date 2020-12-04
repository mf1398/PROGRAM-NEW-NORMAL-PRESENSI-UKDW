/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Newpresensiukdw.local;

import Newpresensiukdw.local.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class CetakPDFController implements Initializable {

    /**
     * Initializes the controller class.
     */
    public void back(ActionEvent event) throws IOException {
        App.setRoot("secondary");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     
    
}
