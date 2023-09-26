/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sunat.gob.pe.airbnfx.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sunat.gob.pe.airbnfx.model.dao.iDepartamento;
import sunat.gob.pe.airbnfx.model.dao.impl.DepartamentoDaoImpl;
import sunat.gob.pe.airbnfx.model.entities.Departamento;

/**
 * FXML Controller class
 *
 * @author user
 */
public class BusquedaAirbnController implements Initializable {

    /**
     * Initializes the controller class.
     * 
     * 
     */
    
     @FXML
    private TableView<Departamento> departamentoTable;

    @FXML
    private TableColumn<Departamento, Integer> idColumn;

    @FXML
    private TableColumn<Departamento, String> distritoColumn;

    @FXML
    private TableColumn<Departamento, String> direccionColumn;

    @FXML
    private TableColumn<Departamento, Integer> capacidadColumn;

    @FXML
    private TableColumn<Departamento, Integer> habitacionesColumn;
    
        @FXML
    private TableColumn<Departamento, String> descripcionColumn;

   @FXML
    private TableColumn<Departamento, Double> precioColumn;
    
    private Departamento deparActual =new Departamento(0,"","",0,"",0,0,0,0,0);
   
    
     private ObservableList<Departamento> departamentoData = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO    
      //  enlazarTabla();
      //  llenarDatosEnTabla();
    }    
      private void enlazarTabla() {
        departamentoTable.setItems(departamentoData);

      idColumn.setCellValueFactory(rowData -> rowData.getValue().getIdDepartamento1());
         distritoColumn.setCellValueFactory(rowData -> rowData.getValue().getDistrito1());
        direccionColumn.setCellValueFactory(rowData -> rowData.getValue().getDireccion1());

        capacidadColumn.setCellValueFactory(rowData -> rowData.getValue().getCapacidad1());
        habitacionesColumn.setCellValueFactory(rowData -> rowData.getValue().getNumHabitacion1());
        descripcionColumn.setCellValueFactory(rowData -> rowData.getValue().getDescripcion1());
        //precioColumn.setCellValueFactory(rowData -> rowData.getValue().getPrecioNoche1());
      
    }

    private void llenarDatosEnTabla() {        
        iDepartamento departamentoDao = new DepartamentoDaoImpl();
        departamentoData.addAll(departamentoDao.busquedaDepartameto()) ;
    }
    
      @FXML
    public void buscarDepartamento(ActionEvent actionEvent) throws IOException {
         
        llenarDatosEnTabla();
        enlazarTabla();
    }
}
