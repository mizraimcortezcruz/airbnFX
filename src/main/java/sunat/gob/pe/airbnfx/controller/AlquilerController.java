/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sunat.gob.pe.airbnfx.controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
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
    private TableColumn<Alquiler,String> fechaInicioColumn;
    @FXML
    private TableColumn<Alquiler,Date> fechaFinColumn;
    @FXML
    private TableColumn<Alquiler,String> montoAlquilerColumn;
    @FXML
    private TextField txtPrecio;
    
    @FXML
    private DatePicker txtFechaInicio;
    
    @FXML
    private Button btnGuardar;
    
    private ObservableList<Alquiler> alquilerData = FXCollections.observableArrayList();
    
    private Alquiler alquilerActual = new Alquiler(0,0,0,"",new Date(),0.0,"");
    
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
        StringProperty monto = new SimpleStringProperty(alquilerActual.getMontoAlquiler().toString());
        System.out.println("AlquilerController enlazarTabla seteando..."+monto);
        //Binding
        txtPrecio.textProperty().bindBidirectional(alquilerActual.getMto1());
        
        txtFechaInicio.setValue(LocalDate.of(2000, Month.JANUARY, 1));
        
        //Llenado de la grilla
        idAlquilerColumn.setCellValueFactory(rowData -> rowData.getValue().getIdAlquiler1());
        idUsuarioColumn.setCellValueFactory(rowData -> rowData.getValue().getIdUsuario1());
        idDepartamentoColumn.setCellValueFactory(rowData -> rowData.getValue().getIdDepartamento1());
        fechaInicioColumn.setCellValueFactory(rowData -> rowData.getValue().getFechaInicio1());
        fechaFinColumn.setCellValueFactory(rowData -> rowData.getValue().getFechaFinal1());
        montoAlquilerColumn.setCellValueFactory(rowData -> rowData.getValue().getMto1());
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
            seleccionarAlquiler(alquilerNuevo);
            StringBinding btnGuardarText = new StringBinding() {
                @Override
                protected String computeValue() {
                    System.out.println("AlquilerController guardar::"+alquilerActual.getIdAlquiler());
                    System.out.println("AlquilerController guardar::.........."+alquilerActual.toString());
                    if (alquilerActual.getIdAlquiler() == 0) {
                        System.out.println("AlquilerController guardar");
                        return "Guardar";
                    }
                    //txtPrecio.setText(alquilerActual.getMto().get());
                    //txtPrecio.textProperty().bindBidirectional(alquilerActual.getMto());
                    System.out.println("AlquilerController actualizar");
                    return "Actualizar";
                }
            };
            btnGuardar.textProperty().bind(btnGuardarText);
        });   
    }
    private void seleccionarAlquiler(Alquiler alquilerNuevo) {
        System.out.println("AlquilerController seleccionarAlumno");
        if (alquilerNuevo != null) {
            alquilerActual.setIdAlquiler(alquilerNuevo.getIdAlquiler());
            alquilerActual.setIdUsuario(alquilerNuevo.getIdUsuario());
            alquilerActual.setIdDepartamento(alquilerNuevo.getIdDepartamento());
            alquilerActual.setFechaInicio(alquilerNuevo.getFechaInicio());
            alquilerActual.setFechaFinal(alquilerNuevo.getFechaFinal());
            alquilerActual.setMontoAlquiler(alquilerNuevo.getMontoAlquiler());
            alquilerActual.setMto(alquilerNuevo.getMto());
        } else {
            alquilerActual = new Alquiler(0,0,0,"",new Date(),0.0,"");
        }
    }
    
    private void mostrarAlertas(String header, String content, Alert.AlertType type){
        Alert dialogo = new Alert(type);        
        dialogo.setHeaderText(header);
        dialogo.setContentText(content);
        dialogo.show();
    }
}
