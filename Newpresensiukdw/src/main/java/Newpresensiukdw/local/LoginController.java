/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Newpresensiukdw.local;

import java.io.IOException;
import java.sql.SQLException;

import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Window;


/**
 *
 * @author joedh
 */
public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button submitButton;

    @FXML
    public void login(ActionEvent event) throws SQLException, IOException {

        Window owner = submitButton.getScene().getWindow();

        System.out.println(usernameField.getText());
        System.out.println(passwordField.getText());
        
        if (usernameField.getText().isEmpty() && passwordField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Error!",
                "Please enter your username & password");
            return;
        }
        
        if (usernameField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Username Error!",
                "Please enter your username");
            return;
        }
        if (passwordField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Password Error!",
                "Please enter a password");
            return;
        }

        String username = usernameField.getText();
        String password = passwordField.getText();

        DBcon DBcon = new DBcon();
        boolean flag = DBcon.validate(username, password);
        
        String admin = "admin";
        
        if (!flag) {
            infoBox("Please enter correct Username and Password", null, "Failed");
        } else {
            if (username.equals(admin)){
                infoBox("Login Successful!", null, "Success");
                App.setRoot("secondary");
            }else{
                infoBox("Login Successful!", null, "Success");
                App.setRoot("primary");
            }
        }
        
    }

    public static void infoBox(String infoMessage, String headerText, String title) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }

    private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
}