/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sunat.gob.pe.airbnfx.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import sunat.gob.pe.airbnfx.App;
import sunat.gob.pe.airbnfx.model.dao.IUsuarioDao;
import sunat.gob.pe.airbnfx.model.dao.impl.UsuarioDaoImpl;

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
        System.out.println(txtUsuarioAirbn.getText().trim());
        System.out.println(txtClaveAirbn.getText());
        IUsuarioDao usuariodao=new UsuarioDaoImpl();
        Map<Integer,Object> mapUsuario=usuariodao.validarUsuario(txtUsuarioAirbn.getText().trim()
                , txtClaveAirbn.getText());
        if(mapUsuario!=null){
            Iterator it = mapUsuario.keySet().iterator();
            while(it.hasNext()){
              Integer key = (Integer) it.next();
              System.out.println("Clave: " + key + " -> Valor: " + mapUsuario.get(key));
            }
        }
        
        FXMLLoader loader =  App.getFXMLLoader("busquedaAirbn");
            Parent busquedaAirbn = loader.load();
            App.scene.setRoot(busquedaAirbn);
               Window window = App.scene.getWindow();
            window.setWidth(900);
            window.setHeight(700);
        /*if(validarDatos()){
            FXMLLoader loader =  App.getFXMLLoader("dashboard");
            Parent dashboard = loader.load();
            App.scene.setRoot(dashboard);
            DashboardController dashboardController = loader.<DashboardController>getController();
            dashboardController.setMensaje(txtUsuario.getText());
        }*/  
       
    }   
    
}
