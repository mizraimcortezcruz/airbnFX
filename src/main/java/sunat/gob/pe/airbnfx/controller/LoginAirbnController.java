/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sunat.gob.pe.airbnfx.controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author mcortezc
 */
public class LoginAirbnController{

    @FXML
    private TextField txtUsuarioAirbn;

    @FXML
    private PasswordField txtClaveAirbn;
    
    @FXML
    public void autenticarUsuarioAirbn(ActionEvent actionEvent) throws IOException {
        System.out.println(txtUsuarioAirbn.getText());
        System.out.println(txtClaveAirbn.getText());
        /*if(validarDatos()){
            FXMLLoader loader =  App.getFXMLLoader("dashboard");
            Parent dashboard = loader.load();
            App.scene.setRoot(dashboard);
            DashboardController dashboardController = loader.<DashboardController>getController();
            dashboardController.setMensaje(txtUsuario.getText());
        }*/  
       
    }   
    
}
