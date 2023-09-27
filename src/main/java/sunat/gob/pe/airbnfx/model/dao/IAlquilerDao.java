/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sunat.gob.pe.airbnfx.model.dao;

import java.util.List;
import sunat.gob.pe.airbnfx.model.entities.Alquiler;

/**
 *
 * @author mcortezc
 */
public interface IAlquilerDao {
    List<Alquiler> getListaAlquileres(Integer idDepartamento);
    void guardarAlquiler(Alquiler alquiler);
    void actualizarAlquiler(Alquiler alquiler);
}
