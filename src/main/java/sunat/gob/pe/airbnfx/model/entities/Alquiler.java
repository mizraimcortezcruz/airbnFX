/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sunat.gob.pe.airbnfx.model.entities;

import java.util.Date;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author mcortezc
 */
public class Alquiler {
    private ObjectProperty<Integer> idAlquiler;
    private ObjectProperty<Integer> idUsuario;
    private ObjectProperty<Integer> idDepartamento;
    private StringProperty fechaInicio;
    private ObjectProperty<Date> fechaFinal;
    private ObjectProperty<Double> montoAlquiler;
    private StringProperty mto;

    public Alquiler() {
        this.idAlquiler = new SimpleObjectProperty<>(0);
        this.idUsuario = new SimpleObjectProperty<>(0);
        this.idDepartamento = new SimpleObjectProperty<>(0);
        this.fechaInicio = new SimpleStringProperty("");
        this.fechaFinal = new SimpleObjectProperty(new Date());
        this.montoAlquiler = new SimpleObjectProperty(0.0);
    }

    public Alquiler(Integer idAlquiler, Integer idUsuario, Integer idDepartamento, String fechaInicio, Date fechaFinal, Double montoAlquiler,String mto) {
        this.idAlquiler = new SimpleObjectProperty<>(idAlquiler);
        this.idUsuario = new SimpleObjectProperty<>(idUsuario);
        this.idDepartamento = new SimpleObjectProperty<>(idDepartamento);
        this.fechaInicio = new SimpleStringProperty(fechaInicio);
        this.fechaFinal = new SimpleObjectProperty<>(fechaFinal);
        this.montoAlquiler = new SimpleObjectProperty<>(montoAlquiler);
        this.mto=new SimpleStringProperty(mto);
    }

    @Override
    public String toString() {
        return "Alquiler{" + "idAlquiler=" + idAlquiler + ", idUsuario=" + idUsuario + ", idDepartamento=" + idDepartamento + ", fechaInicio=" + fechaInicio + ", fechaFinal=" + fechaFinal + ", montoAlquiler=" + montoAlquiler + '}';
    }
    
    public Integer getIdAlquiler() {
        return idAlquiler.get();
    }
    public ObjectProperty<Integer> getIdAlquiler1() {
        return idAlquiler;
    }

    public void setIdAlquiler(Integer idAlquiler) {
        this.idAlquiler.set(idAlquiler);
    }

    public Integer getIdUsuario() {
        return idUsuario.get();
    }
    
    public ObjectProperty<Integer> getIdUsuario1() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario.set(idUsuario);
    }

    public Integer getIdDepartamento() {
        return idDepartamento.get();
    }
    
    public ObjectProperty<Integer> getIdDepartamento1() {
        return idDepartamento;
    }

    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento.set(idDepartamento);
    }

    public String getFechaInicio() {
        return fechaInicio.get();
    }
    public StringProperty getFechaInicio1() {
        return fechaInicio;
    }
    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio.set(fechaInicio);
    }

    public Date getFechaFinal() {
        return fechaFinal.get();
    }
    public ObjectProperty<Date> getFechaFinal1() {
        return fechaFinal;
    }
    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal.set(fechaFinal);
    }

    public Double getMontoAlquiler() {
        return montoAlquiler.get();
    }
    
    public ObjectProperty<Double> getMontoAlquiler1() {
        return montoAlquiler;
    }
    
    public void setMontoAlquiler(Double montoAlquiler) {
        this.montoAlquiler.set(montoAlquiler);
    }

    public String getMto() {
        return mto.get();
    }

    public void setMto(String mto) {
        this.mto.set(mto);
    }
    
    public StringProperty getMto1() {
        return mto;
    }
    
}
