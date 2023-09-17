/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sunat.gob.pe.airbnfx.model.dao;

import java.util.Map;

/**
 *
 * @author mcortezc
 */
public interface IUsuarioDao {
    Map<Integer,Object> validarUsuario(String email,String clave);
}
