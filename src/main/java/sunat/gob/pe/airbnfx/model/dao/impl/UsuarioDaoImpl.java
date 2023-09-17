/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sunat.gob.pe.airbnfx.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import sunat.gob.pe.airbnfx.model.dao.IUsuarioDao;
import sunat.gob.pe.airbnfx.model.entities.Usuario;
import sunat.gob.pe.airbnfx.model.util.Conexion;

/**
 *
 * @author mcortezc
 */
public class UsuarioDaoImpl implements IUsuarioDao{

    @Override
    public Map<Integer, Object> validarUsuario(String email, String clave) {
        Conexion conexion = new Conexion();
        Connection conn = conexion.getConexion();
        PreparedStatement pstmt = null;
        Usuario usuario;
        ResultSet rs = null;
        Map<Integer, Object> respuesta = null;
        try {
            String sql = "select u.idUsuario,u.DNI,u.Clave,u.Estado,u.codPerfil,u.Nombre,u.Apellido,u.Email,u.Edad,u.Sexo from usuario u where u.Email = ? ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            
            rs = pstmt.executeQuery();
            
            respuesta = new HashMap<>();

            if (rs.next()) {
                if(rs.getString(3).equals(clave)){
                    
                    if("A".equals(rs.getString(4))){
                        usuario=new Usuario(rs.getInt(1),rs.getString(2),rs.getString(3)
                            ,rs.getString(4),rs.getString(5),rs.getString(6)
                            ,rs.getString(7),rs.getString(8),rs.getInt(9)
                            ,rs.getString(10));
                        respuesta.put(4, usuario);
                    }else{
                        System.out.println("Usuario no esta activo");
                        respuesta.put(1, "Usuario no esta activo.");
                    }
                    
                }else{
                    System.out.println("Clave incorrecta");
                    respuesta.put(2, "Clave incorrecta.");
                }
            }else{
                System.out.println("Usuario no existe");
                respuesta.put(3, "Usuario no existe.");
            }

        } catch (SQLException se) {
            System.out.println(se.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException se) {
                System.out.println(se.getMessage());
            }
        }

        return respuesta;
    }
    
}
