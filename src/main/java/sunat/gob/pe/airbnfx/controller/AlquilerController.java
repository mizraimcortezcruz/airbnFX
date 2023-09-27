/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sunat.gob.pe.airbnfx.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import sunat.gob.pe.airbnfx.App;
import sunat.gob.pe.airbnfx.model.dao.IAlquilerDao;
import sunat.gob.pe.airbnfx.model.dao.iDepartamento;
import sunat.gob.pe.airbnfx.model.dao.impl.AlquilerDaoImpl;
import sunat.gob.pe.airbnfx.model.dao.impl.DepartamentoDaoImpl;
import sunat.gob.pe.airbnfx.model.entities.Alquiler;
import sunat.gob.pe.airbnfx.model.entities.Departamento;

/**
 * FXML Controller class
 *
 * @author mcortezc
 */
public class AlquilerController implements Initializable {

    @FXML
    private TableView<Alquiler> alquilerTable;
    @FXML
    private TableColumn<Alquiler, Integer> idAlquilerColumn;
    @FXML
    private TableColumn<Alquiler, Integer> idUsuarioColumn;
    @FXML
    private TableColumn<Alquiler, Integer> idDepartamentoColumn;
    @FXML
    private TableColumn<Alquiler, String> fechaInicioColumn;
    @FXML
    private TableColumn<Alquiler, Date> fechaFinColumn;
    @FXML
    private TableColumn<Alquiler, String> montoAlquilerColumn;

    @FXML
    private TableColumn<Alquiler, String> dniColumn;
    @FXML
    private TableColumn<Alquiler, String> solicitanteColumn;

    @FXML
    private Label lblDistrito;
    @FXML
    private Label lblDireccion;
    @FXML
    private Label lblHabitaciones;
    @FXML
    private Label lblDescripcion;
    @FXML
    private Label lblPrecioNoche;

    @FXML
    private TextField txtSolicitante;
    @FXML
    private TextField txtDni;
    @FXML
    private DatePicker txtFechaInicio;
    @FXML
    private DatePicker txtFechaFin;
    @FXML
    private TextField txtPrecio;
    @FXML
    private TextField txtCodigoDepartamento;

    @FXML
    private Button btnGuardar;

    private ObservableList<Alquiler> alquilerData = FXCollections.observableArrayList();

    private Alquiler alquilerActual = new Alquiler(0, 0, 0, "", new Date(), 0.0, "", "", "", new Date());
    private Departamento departamentoActual = new Departamento();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("AlquilerController initialize");
        enlazarTabla();
        //llenarDatosEnTabla();
        seleccionarElementoDeTabla();
    }

    public void setMensaje(String idDepartamento) {
        System.out.println("AlquilerController setMensaje idDepartamento:" + idDepartamento);
        iDepartamento iDepartamento = new DepartamentoDaoImpl();
        Departamento objDepartamento = iDepartamento.busquedaDepartametoPorId(Integer.parseInt(idDepartamento));
        llenarDatosDepartamento(objDepartamento);
        departamentoActual.setIdDepartamento(Integer.parseInt(idDepartamento));
        txtCodigoDepartamento.setText(idDepartamento);
        llenarDatosEnTabla();
    }

    private void llenarDatosDepartamento(Departamento objDepartamento) {
        System.out.println("AlquilerController setMensaje objDepartamento:" + objDepartamento.getDistrito());
        lblDistrito.setText(objDepartamento.getDistrito());
        lblDireccion.setText(objDepartamento.getDireccion());
        lblHabitaciones.setText(String.valueOf(objDepartamento.getNumHabitacion()));
        lblDescripcion.setText(objDepartamento.getDescripcion());
        lblPrecioNoche.setText(String.valueOf(objDepartamento.getPrecioNoche()));
    }

    private void enlazarTabla() {
        System.out.println("AlquilerController enlazarTabla");
        alquilerTable.setItems(alquilerData);
        StringProperty monto = new SimpleStringProperty(alquilerActual.getMontoAlquiler().toString());
        System.out.println("AlquilerController enlazarTabla seteando..." + monto);
        //Binding
        txtPrecio.textProperty().bindBidirectional(alquilerActual.getMto1());

        //txtFechaInicio.setValue(LocalDate.of(2000, Month.JANUARY, 1));
        //Llenado de la grilla
        idAlquilerColumn.setCellValueFactory(rowData -> rowData.getValue().getIdAlquiler1());
        idUsuarioColumn.setCellValueFactory(rowData -> rowData.getValue().getIdUsuario1());
        idDepartamentoColumn.setCellValueFactory(rowData -> rowData.getValue().getIdDepartamento1());
        fechaInicioColumn.setCellValueFactory(rowData -> rowData.getValue().getFechaInicio1());
        fechaFinColumn.setCellValueFactory(rowData -> rowData.getValue().getFechaFinal1());
        montoAlquilerColumn.setCellValueFactory(rowData -> rowData.getValue().getMto1());
        dniColumn.setCellValueFactory(rowData -> rowData.getValue().getDni1());
        solicitanteColumn.setCellValueFactory(rowData -> rowData.getValue().getSolicitante1());
    }

    private void llenarDatosEnTabla() {

        System.out.println("AlquilerController llenarDatosEnTabla cod. dpto...::" + txtCodigoDepartamento.getText());
        //alquilerData = FXCollections.observableArrayList();
        IAlquilerDao alquilerDao = new AlquilerDaoImpl();
        alquilerData.clear();
        alquilerData.addAll(alquilerDao.getListaAlquileres(Integer.parseInt(txtCodigoDepartamento.getText())));
    }

    private void seleccionarElementoDeTabla() {
        System.out.println("AlquilerController seleccionarElementoDeTabla");
        alquilerTable.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Alquiler> ov, Alquiler alquilerAntiguo, Alquiler alquilerNuevo) -> {
            System.out.println("AlquilerController seleccionado");
            seleccionarAlquiler(alquilerNuevo);
            StringBinding btnGuardarText = new StringBinding() {
                @Override
                protected String computeValue() {
                    System.out.println("AlquilerController guardar::" + alquilerActual.getIdAlquiler());
                    System.out.println("AlquilerController guardar::.........." + alquilerActual.toString());
                    if (alquilerActual.getIdAlquiler() == 0) {
                        System.out.println("AlquilerController guardar");
                        return "Guardar";
                    }
                    //txtPrecio.setText(alquilerActual.getMto().get());
                    //txtPrecio.textProperty().bindBidirectional(alquilerActual.getMto());

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

                    String dateInicio = alquilerActual.getFechaInicio();
                    String[] splittedInicio = dateInicio.split("-");
                    dateInicio = splittedInicio[2] + "/" + splittedInicio[1] + "/" + splittedInicio[0];
                    //convert String to LocalDate
                    LocalDate localDateInicio = LocalDate.parse(dateInicio, formatter);
                    txtFechaInicio.setValue(localDateInicio);

                    String dateFinal = String.valueOf(alquilerActual.getFechaFinal());
                    String[] splittedFin = dateFinal.split("-");
                    dateFinal = splittedFin[2] + "/" + splittedFin[1] + "/" + splittedFin[0];
                    //convert String to LocalDate
                    LocalDate localDateFinal = LocalDate.parse(dateFinal, formatter);
                    txtFechaFin.setValue(localDateFinal);

                    System.out.println("AlquilerController actualizar" + alquilerActual.toString());

                    txtSolicitante.setText(alquilerActual.getSolicitante());
                    txtDni.setText(alquilerActual.getDni());

                    System.out.println("AlquilerController actualizar" + alquilerActual.getFechaInicio());
                    System.out.println("AlquilerController actualizar" + alquilerActual.getFechaFinal());
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
            alquilerActual.setDni(alquilerNuevo.getDni());
            alquilerActual.setSolicitante(alquilerNuevo.getSolicitante());
        } else {
            alquilerActual = new Alquiler(0, 0, 0, "", new Date(), 0.0, "", "", "", new Date());
        }
    }

    private void mostrarAlertas(String header, String content, Alert.AlertType type) {
        Alert dialogo = new Alert(type);
        dialogo.setHeaderText(header);
        dialogo.setContentText(content);
        dialogo.show();
    }

    public void cancelarAlquiler(ActionEvent event) {
        System.out.println("AlquilerController cancelarAlquiler...");
        try {
            FXMLLoader loader = App.getFXMLLoader("busquedaAirbn");
            Parent dashboard = loader.load();
            App.scene.setRoot(dashboard);
            BusquedaAirbnController busquedaController = loader.<BusquedaAirbnController>getController();
            busquedaController.setMensaje("retorno desde alquiler controller");
        } catch (IOException ex) {
            System.out.println("AlquilerController cancelarAlquiler..." + ex.getMessage());

        }
    }

    public boolean validarFormulario() {
        LocalDate dateInicio = txtFechaInicio.getValue();
        if (txtFechaInicio.getValue() == null) {
            mostrarAlertas("Warning", "Ingrese Fecha Inicio", Alert.AlertType.WARNING);
            return true;
        }
        LocalDate dateFinal = txtFechaFin.getValue();
        if (dateFinal == null) {
            mostrarAlertas("Warning", "Ingrese Fecha Fin", Alert.AlertType.WARNING);
            return true;
        }
        System.out.println("AlquilerController guardarAlquiler dateInicio..." + dateInicio);
        System.out.println("AlquilerController guardarAlquiler dateInicio..." + dateInicio.toString());
        System.out.println("AlquilerController guardarAlquiler dateFin..." + dateFinal);
        System.out.println("AlquilerController guardarAlquiler dateFin..." + dateFinal.toString());
        if ("".equals(txtSolicitante.getText().trim())) {
            mostrarAlertas("Warning", "Ingrese Solicitante", Alert.AlertType.WARNING);
            return true;
        }
        if ("".equals(txtDni.getText().trim())) {
            mostrarAlertas("Warning", "Ingrese Dni", Alert.AlertType.WARNING);
            return true;
        }
        if ("".equals(txtPrecio.getText().trim())) {
            mostrarAlertas("Warning", "Ingrese Precio total", Alert.AlertType.WARNING);
            return true;
        }
        return false;
    }

    public void guardarAlquiler(ActionEvent event) {
        System.out.println("AlquilerController guardarAlquiler..." + alquilerActual.toString());
        if (!validarFormulario()) {
            LocalDate dateInicio = txtFechaInicio.getValue();
            LocalDate dateFinal = txtFechaFin.getValue();

            //convertir el LocalDate del datepicker a Date
            Date dtdInicio = Date.from(dateInicio.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
            Date dtdFinal = Date.from(dateFinal.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());

            System.out.println("AlquilerController guardarAlquiler dateInicio time..." + dtdInicio.getTime());
            System.out.println("AlquilerController guardarAlquiler dateFinal time..." + dtdFinal.getTime());

            //llenar los datos
            alquilerActual.setFechaInicial(dtdInicio);
            alquilerActual.setFechaFinal(dtdFinal);

            alquilerActual.setSolicitante(txtSolicitante.getText().trim());
            alquilerActual.setDni(txtDni.getText().trim());
            alquilerActual.setMto(txtPrecio.getText().trim());
            alquilerActual.setIdDepartamento(departamentoActual.getIdDepartamento());

            IAlquilerDao alquilerDao = new AlquilerDaoImpl();

            if (alquilerActual.getIdAlquiler() == 0) {
                alquilerDao.guardarAlquiler(alquilerActual);
                mostrarAlertas("Informacion", "Se guardo exitosamente", Alert.AlertType.INFORMATION);
            } else {
                alquilerDao.actualizarAlquiler(alquilerActual);
                System.out.println("AlquilerController actualizandoAlquiler..." + alquilerActual.toString());
                alquilerActual.setIdAlquiler(0);
                
                mostrarAlertas("Informacion", "Se actualizo exitosamente!", Alert.AlertType.INFORMATION);
            }

            llenarDatosEnTabla();
        }

    }
}
