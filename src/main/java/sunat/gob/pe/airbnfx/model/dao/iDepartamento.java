/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sunat.gob.pe.airbnfx.model.dao;

import java.util.List;
import sunat.gob.pe.airbnfx.model.entities.Departamento;

/**
 *
 * @author user
 */
public interface iDepartamento {
  List <Departamento>  busquedaDepartameto();
  Departamento  busquedaDepartametoPorId(Integer idDepartamento);
}
