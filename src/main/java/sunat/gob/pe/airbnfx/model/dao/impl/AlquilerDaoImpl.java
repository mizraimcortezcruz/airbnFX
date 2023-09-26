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
import sunat.gob.pe.airbnfx.model.dao.IAlquilerDao;
import sunat.gob.pe.airbnfx.model.entities.Alquiler;
import sunat.gob.pe.airbnfx.model.util.Conexion;

/**
 *
 * @author mcortezc
 */
public class AlquilerDaoImpl implements IAlquilerDao{

    @Override
    public List<Alquiler> getListaAlquileres() {
        Conexion conexion = new Conexion();
        Connection conn = conexion.getConexion();
        PreparedStatement pstmt = null;
        List<Alquiler> listaAlquiler = new ArrayList<>();
        ResultSet rs = null;

        try {
            System.out.println("AlquilerDaoImpl getListaAlquileres inicio");
            String sql = "select idAlquiler,idUsuario,idDepartamento,FechaIni,FechaFin,MontoAlquiler from alquiler where idAlquiler = 1;";
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("AlquilerDaoImpl getListaAlquileres hay resultados 1"+rs.getInt(1));
                System.out.println("AlquilerDaoImpl getListaAlquileres hay resultados 2"+rs.getInt(2));
                System.out.println("AlquilerDaoImpl getListaAlquileres hay resultados 3"+rs.getInt(3));
                System.out.println("AlquilerDaoImpl getListaAlquileres hay resultados 4"+rs.getDate(4));
                System.out.println("AlquilerDaoImpl getListaAlquileres hay resultados 5"+rs.getDate(5));
                System.out.println("AlquilerDaoImpl getListaAlquileres hay resultados 6"+rs.getDouble(6));
                listaAlquiler.add(new Alquiler(
                        rs.getInt(1)
                        ,rs.getInt(2)
                        ,rs.getInt(3)
                        ,String.valueOf(rs.getDate(4))
                        ,rs.getDate(5)
                        ,rs.getDouble(6)
                        ,String.valueOf(rs.getInt(6))
                ));
                
            }
            System.out.println("AlquilerDaoImpl getListaAlquileres fin");
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

        return listaAlquiler;
    }
    
}
