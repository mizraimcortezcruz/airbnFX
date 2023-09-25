/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sunat.gob.pe.airbnfx.controller;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.ObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    @FXML
    private TextField txtPrecio;
    @FXML
    private Button btnGuardar;
    
    private ObservableList<Alquiler> alquilerData = FXCollections.observableArrayList();
    
    private Alquiler alquilerActual = new Alquiler(0,0,0,new Date(),new Date(),0.0);
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("AlquilerController initialize");
        enlazarTabla();
        llenarDatosEnTabla();
        seleccionarElementoDeTabla();
    }
    
    private void enlazarTabla() {
        System.out.println("AlquilerController enlazarTabla");
        alquilerTable.setItems(alquilerData);
        
        //txtPrecio.textProperty().bindBidirectional(alquilerActual.getMontoAlquiler1());
        //txtPrecio.textProperty(String.valueOf(alquilerActual.getMontoAlquiler()));
        //txtPrecio.text
        ObjectProperty<Double> t=alquilerActual.getMontoAlquiler1();
        //txtPrecio.textProperty().bindBidirectional(t, sc);
        idAlquilerColumn.setCellValueFactory(rowData -> rowData.getValue().getIdAlquiler1());
        idUsuarioColumn.setCellValueFactory(rowData -> rowData.getValue().getIdUsuario1());
        idDepartamentoColumn.setCellValueFactory(rowData -> rowData.getValue().getIdDepartamento1());
        fechaInicioColumn.setCellValueFactory(rowData -> rowData.getValue().getFechaInicio1());
        fechaFinColumn.setCellValueFactory(rowData -> rowData.getValue().getFechaFinal1());
        montoAlquilerColumn.setCellValueFactory(rowData -> rowData.getValue().getMontoAlquiler1());
        //Bindings.bi
    }
    private void llenarDatosEnTabla() {
        System.out.println("AlquilerController llenarDatosEnTabla");
        IAlquilerDao alquilerDao = new AlquilerDaoImpl();
        alquilerData.addAll(alquilerDao.getListaAlquileres());
    }
    private void seleccionarElementoDeTabla() {
        System.out.println("AlquilerController seleccionarElementoDeTabla");
        alquilerTable.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Alquiler> ov, Alquiler alquilerAntiguo, Alquiler alquilerNuevo) -> {
            System.out.println("AlquilerController seleccionado");
            seleccionarAlumno(alquilerNuevo);
            StringBinding btnGuardarText = new StringBinding() {
                @Override
                protected String computeValue() {
                    System.out.println("AlquilerController guardar::"+alquilerActual.getIdAlquiler());
                    if (alquilerActual.getIdAlquiler() == 0) {
                        System.out.println("AlquilerController guardar");
                        return "Guardar";
                    }
                    System.out.println("AlquilerController actualizar");
                    return "Actualizar";
                }
            };
            btnGuardar.textProperty().bind(btnGuardarText);
        });   
    }
    private void seleccionarAlumno(Alquiler alquilerNuevo) {
        System.out.println("AlquilerController seleccionarAlumno");
        if (alquilerNuevo != null) {
            alquilerActual.setIdAlquiler(alquilerNuevo.getIdAlquiler());
            alquilerActual.setIdUsuario(alquilerNuevo.getIdUsuario());
            alquilerActual.setIdDepartamento(alquilerNuevo.getIdDepartamento());
            alquilerActual.setFechaInicio(alquilerNuevo.getFechaInicio());
            alquilerActual.setFechaFinal(alquilerNuevo.getFechaFinal());
            alquilerActual.setMontoAlquiler(alquilerNuevo.getMontoAlquiler());
        } else {
            alquilerActual = new Alquiler(0,0,0,new Date(),new Date(),0.0);
        }
    }
}
