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
import sunat.gob.pe.airbnfx.model.dao.Igrafico;
import sunat.gob.pe.airbnfx.model.entities.Departamento;
import sunat.gob.pe.airbnfx.model.entities.barra;
import sunat.gob.pe.airbnfx.model.util.Conexion;

/**
 *
 * @author user
 */
public class graficoDaoImpl implements Igrafico {

      private List<barra> listaBarra = new ArrayList<>();
      private PreparedStatement pstmt = null;
      private ResultSet rs = null;
      
    @Override
    public List<barra> grafico1() {
      Conexion conexion = new Conexion();
        Connection conn = conexion.getConexion();
        PreparedStatement pstmt = null;
      
          try {

             String sql = "SELECT Departamento, COUNT(1) as count FROM departamento GROUP BY Departamento";
          
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                listaBarra.add(new barra(rs.getString(1), rs.getInt(2) ));
                    System.out.println("DISTRITO:" + rs.getString(1)+ ": " + rs.getInt(2));
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
        return listaBarra;
        
    }
    
}
