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
 * @author user
 */
public class Departamento {
    
       private StringProperty correo;

    private ObjectProperty<Integer> estado;
    
   private ObjectProperty<Integer>  idDepartamento;
   private StringProperty Departamento;
   private StringProperty Provincia;
   private StringProperty Distrito;
   private StringProperty Direccion;
   private ObjectProperty<Integer>  Espacio;
   private StringProperty Descripcion;
   private ObjectProperty<Integer>  NumHabitacion;
   private ObjectProperty<Integer>  NumBanios;
   private ObjectProperty<Integer>  NumCochera;
   private ObjectProperty<Integer>  Capacidad;
   private ObjectProperty<Double>  PrecioNoche;
   private Date  Checkout;
   private Date Checkin;
   
      public Departamento() {
        this.idDepartamento = new SimpleObjectProperty<>(0);
        this.Provincia = new SimpleStringProperty("");
        this.Distrito = new SimpleStringProperty("");
        this.Direccion = new SimpleStringProperty("");
        this.Espacio = new SimpleObjectProperty<>(0);
        this.Descripcion = new SimpleStringProperty("");
        this.NumBanios = new SimpleObjectProperty<>(0);
        this.NumHabitacion = new SimpleObjectProperty<>(0);
        this.NumCochera = new SimpleObjectProperty<>(0);
        this.PrecioNoche = new SimpleObjectProperty<>(0D);
        
    }

    public Departamento(int idDepartamento, String Distrito, String Direccion, int Espacio, String Descripcion, int NumHabitacion, int NumBanios, int NumCochera, int Capacidad, double PrecioNoche) {
        this.idDepartamento = new SimpleObjectProperty<>(idDepartamento);
        this.Distrito = new SimpleStringProperty(Distrito);
        this.Direccion = new SimpleStringProperty(Direccion);
        this.Espacio = new SimpleObjectProperty<>(Espacio);
        this.Descripcion = new SimpleStringProperty(Descripcion);
        this.NumHabitacion = new SimpleObjectProperty<>(NumHabitacion);
        this.NumBanios = new SimpleObjectProperty<>(NumBanios);
        this.NumCochera = new SimpleObjectProperty<>(NumCochera);
        this.Capacidad = new SimpleObjectProperty<>(Capacidad);
        this.PrecioNoche = new SimpleObjectProperty<>(PrecioNoche);
        
        
        
    }

    public StringProperty getCorreo1() {
        return correo;
    }
        
    public String getCorreo() {
        return correo.get();
    }

    public void setCorreo1(StringProperty correo) {
        this.correo = correo;
    }
     public void setCorreo(String correo) {
        this.correo.set(correo);
    }

    public ObjectProperty<Integer> getEstado1() {
        return estado;
    }
    
     public Integer getEstado() {
        return estado.get();
    }

    public void setEstado1(ObjectProperty<Integer> estado) {
        this.estado = estado;
    }
    
      public void setEstado(Integer estado) {
        this.estado.set(estado);
    }

    public ObjectProperty<Integer> getIdDepartamento1() {
        return idDepartamento;
    }
    
       public Integer getIdDepartamento() {
        return idDepartamento.get();
    }

    public void setIdDepartamento1(ObjectProperty<Integer> idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
    
    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento.set(idDepartamento);
    }

    public StringProperty getDepartamento1() {
        return Departamento;
    }
    
     public String getDepartamento() {
        return Departamento.get();
    }

    public void setDepartamento1(StringProperty Departamento) {
        this.Departamento = Departamento;
    }
    
    public void setDepartamento(String Departamento) {
        this.Departamento.set(Departamento);
    }

    public StringProperty getProvincia1() {
        return Provincia;
    }
    public String getProvincia() {
        return Provincia.get();
    }
    public void setProvincia1(StringProperty Provincia) {
        this.Provincia = Provincia;
    }
    public void setProvincia(String Provincia) {
        this.Provincia.set(Provincia);
    }

    public StringProperty getDistrito1() {
        return Distrito;
    }
    public String getDistrito() {
        return Distrito.get();
    }

    public void setDistrito(StringProperty Distrito) {
        this.Distrito = Distrito;
    }

     public void setDistrito(String Distrito) {
        this.Distrito.set(Distrito);
    }
    
    public StringProperty getDireccion1() {
        return Direccion;
    }

        public String getDireccion() {
        return Direccion.get();
    }
    
    public void setDireccion1(StringProperty Direccion) {
        this.Direccion = Direccion;
    }
    
      public void setDireccion(String Direccion) {
        this.Direccion.set(Direccion); ;
    }

    public ObjectProperty<Integer> getEspacio1() {
        return Espacio;
    }
    
    public Integer getEspacio() {
        return Espacio.get();
    }

    public void setEspacio1(ObjectProperty<Integer> Espacio) {
        this.Espacio = Espacio;
    }
    
    public void setEspacio(Integer Espacio) {
        this.Espacio.set(Espacio);
    }

    public StringProperty getDescripcion1() {
        return Descripcion;
    }

    public String getDescripcion() {
        return Descripcion.get();
    }
    
    public void setDescripcion(StringProperty Descripcion) {
        this.Descripcion = Descripcion;
    }
    
    public void setDescripcion(String Descripcion) {
        this.Descripcion.set(Descripcion);
    }

    public ObjectProperty<Integer> getNumHabitacion1() {
        return NumHabitacion;
    }
    
     public Integer getNumHabitacion() {
        return NumHabitacion.get();
    }

    public void setNumHabitacion1(ObjectProperty<Integer> NumHabitacion) {
        this.NumHabitacion = NumHabitacion;
    }
    
     public void setNumHabitacion(Integer NumHabitacion) {
        this.NumHabitacion.set(NumHabitacion);
    }

    public ObjectProperty<Integer> getNumBanios1() {
        return NumBanios;
    }
    
    public Integer getNumBanios() {
        return NumBanios.get();
    }

    public void setNumBanios1(ObjectProperty<Integer> NumBanios) {
        this.NumBanios = NumBanios;
    }
    
    public void setNumBanios(Integer NumBanios) {
        this.NumBanios.set(NumBanios); ;
    }

    public ObjectProperty<Integer> getNumCochera1() {
        return NumCochera;
    }
    
     public Integer getNumCochera() {
        return NumCochera.get();
    }

    public void setNumCochera1(ObjectProperty<Integer> NumCochera) {
        this.NumCochera = NumCochera;
    }
    
       public void setNumCochera(Integer NumCochera) {
        this.NumCochera.set(NumCochera);
    }

    public ObjectProperty<Integer> getCapacidad1() {
        return Capacidad;
    }
    
 public Integer getCapacidad() {
        return Capacidad.get();
    }
    
    public void setCapacidad1(ObjectProperty<Integer> Capacidad) {
        this.Capacidad = Capacidad;
    }
    
    public void setCapacidad(Integer Capacidad) {
        this.Capacidad.set(Capacidad);
    }

    public ObjectProperty<Double> getPrecioNoche1() {
        return PrecioNoche;
    }
      public Double getPrecioNoche() {
        return PrecioNoche.get();
    }

    public void setPrecioNoche1(ObjectProperty<Double> PrecioNoche) {
        this.PrecioNoche = PrecioNoche;
    }
    
     public void setPrecioNoche(Double PrecioNoche) {
        this.PrecioNoche.set(PrecioNoche);
    }
   
   

    public Date getCheckout() {
        return Checkout;
    }

    public void setCheckout(Date Checkout) {
        this.Checkout = Checkout;
    }

    public Date getCheckin() {
        return Checkin;
    }

    public void setCheckin(Date Checkin) {
        this.Checkin = Checkin;
    }
   
   
}
