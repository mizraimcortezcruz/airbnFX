/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sunat.gob.pe.airbnfx.controller;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sunat.gob.pe.airbnfx.model.dao.IAlquilerDao;
import sunat.gob.pe.airbnfx.model.dao.impl.AlquilerDaoImpl;
import sunat.gob.pe.airbnfx.model.entities.Alquiler;

/**
 * FXML Controller class
 *
 * @author mcortezc
 */
public class AlquilerController implements Initializable {
    
    @FXML
    private TableView<Alquiler> alquilerTable;
    @FXML
    private TableColumn<Alquiler,Integer> idAlquilerColumn;
    @FXML
    private TableColumn<Alquiler,Integer> idUsuarioColumn;
    @FXML
    private TableColumn<Alquiler,Integer> idDepartamentoColumn;
    @FXML
    private TableColumn<Alquiler,Date> fechaInicioColumn;
    @FXML
    private TableColumn<Alquiler,Date> fechaFinColumn;
    @FXML
    private TableColumn<Alquiler,Double> montoAlquilerColumn;
    
    private ObservableList<Alquiler> alquilerData = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        enlazarTabla();
        llenarDatosEnTabla();
    }
    
    private void enlazarTabla() {
        
        idAlquilerColumn.setCellValueFactory(rowData -> rowData.getValue().getIdAlquiler1());
        idUsuarioColumn.setCellValueFactory(rowData -> rowData.getValue().getIdUsuario1());
        idDepartamentoColumn.setCellValueFactory(rowData -> rowData.getValue().getIdDepartamento1());
        fechaInicioColumn.setCellValueFactory(rowData -> rowData.getValue().getFechaInicio1());
        fechaFinColumn.setCellValueFactory(rowData -> rowData.getValue().getFechaFinal1());
        montoAlquilerColumn.setCellValueFactory(rowData -> rowData.getValue().getMontoAlquiler1());
                
    }
    
    private void llenarDatosEnTabla() {
        IAlquilerDao alquilerDao = new AlquilerDaoImpl();
        alquilerData.addAll(alquilerDao.getListaAlquileres());
    }    
    
    
}
