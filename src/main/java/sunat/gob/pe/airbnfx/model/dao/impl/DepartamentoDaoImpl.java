/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sunat.gob.pe.airbnfx.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sunat.gob.pe.airbnfx.model.entities.Departamento;
import sunat.gob.pe.airbnfx.model.dao.iDepartamento;
import sunat.gob.pe.airbnfx.model.util.Conexion;

/**
 *
 * @author user
 */
public class DepartamentoDaoImpl implements iDepartamento {

    @Override
    public List<Departamento> busquedaDepartameto() {
        
          Conexion conexion = new Conexion();
        Connection conn = conexion.getConexion();
        PreparedStatement pstmt = null;
        List<Departamento> listaDepartamento = new ArrayList<>();
        ResultSet rs = null;

        try {

            String sql = "Select idDepartamento, Distrito, Direccion, Espacio, Descripcion, NumHabitacion, NumBanios, NumCochera,Capacidad,PrecioNoche from departamento";
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                listaDepartamento.add(new Departamento(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getDouble(10)));
                    System.out.println("Depa:" + rs.getString(2));
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

        return listaDepartamento;
    }

    @Override
    public Departamento busquedaDepartametoPorId(Integer idDepartamento) {
        Conexion conexion = new Conexion();
        Connection conn = conexion.getConexion();
        PreparedStatement pstmt = null;
        Departamento objDepartamento = null;
        ResultSet rs = null;
        System.out.println("DepartamentoDaoImpl busquedaDepartametoPorId");
        try {
            
            String sql = "Select idDepartamento,Departamento,Provincia,Distrito, Direccion, Espacio, Descripcion, NumHabitacion, NumBanios, NumCochera,Capacidad,PrecioNoche from departamento where idDepartamento = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, idDepartamento);
            
            rs = pstmt.executeQuery();
            if (rs.next()) {
                objDepartamento = new Departamento();
                objDepartamento.setDistrito(rs.getString(4));
                objDepartamento.setDireccion(rs.getString(5));
                objDepartamento.setDescripcion(rs.getString(7));
                objDepartamento.setNumHabitacion(rs.getInt(8));
                objDepartamento.setPrecioNoche(rs.getDouble(12));
            }
           
        } catch (SQLException se) {
            System.out.println("DepartamentoDaoImpl error:"+se.getMessage());
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

        return objDepartamento;
    }

    
      
}
