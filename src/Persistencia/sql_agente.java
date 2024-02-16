/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Agentes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Atencion que esta parte es de tpu y maquinaria, por lo tanto es necesario no
 * cerrar las conexiones si no va a tener problemas dentro de la aplicacion,
 * amenos que se haya preparado para poder cerrar la conexion sin problema se
 * implementaria.
 *
 * @author GATEWAY1-
 */
public class sql_agente {

    public ArrayList<Agentes> getagentes_all(Connection c) {
        ArrayList<Agentes> arr = new ArrayList<>();
        try {
            ResultSet rs;
            PreparedStatement st;
            String sql = "select * from Agente";
            st = c.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Agentes a = new Agentes();
                a.setIdagente(rs.getInt("id_agente"));
                a.setNombre(rs.getString("nombre"));
                a.setPlazo(rs.getInt("plazo"));
                a.setEstatus(rs.getString("estatus"));
                arr.add(a);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sql_agente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public ArrayList<Agentes> getagentes_var(Connection c, String var) {
        ArrayList<Agentes> arr = new ArrayList<>();
        try {
            ResultSet rs;
            PreparedStatement st;
            String sql = "select * from Agente "
                    + "where estatus='1' and nombre like '%" + var + "%'";
            st = c.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Agentes a = new Agentes();
                a.setIdagente(rs.getInt("id_agente"));
                a.setNombre(rs.getString("nombre"));
                a.setPlazo(rs.getInt("plazo"));
                arr.add(a);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sql_agente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public boolean getagentes_id(Connection c, int id, String operacion) {
        try {
            c.setAutoCommit(false);
            PreparedStatement st;
            String sql = "update agente set estatus =? where id_agente=?";
            st = c.prepareStatement(sql);
            st.setString(1, operacion);
            st.setInt(2, id);
            st.executeUpdate();
            c.commit();
            st.close();
            return true;
        } catch (SQLException ex) {
            try {
                c.rollback();
                Logger.getLogger(sql_agente.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(sql_agente.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }

    public boolean getagente_id(Connection c, int id) {
        boolean resp = false;
        try {
            ResultSet rs;
            PreparedStatement st;
            String sql = "select id_agente from Agente where id_agente=?";
            st = c.prepareStatement(sql);
            st.setInt(1, id);
            rs = st.executeQuery();
            while (rs.next()) {
                resp = true;
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sql_agente.class.getName()).log(Level.SEVERE, null, ex);
            resp = false;
        }
        return resp;
    }

    public boolean edit_Plazo(Connection c, int id, int plazo) {
        try {
            c.setAutoCommit(false);
            PreparedStatement st;
            String sql = "update agente set plazo =? where id_agente=?";
            st = c.prepareStatement(sql);
            st.setInt(1, plazo);
            st.setInt(2, id);
            st.executeUpdate();
            c.commit();
            st.close();
            return true;
        } catch (SQLException ex) {
            try {
                c.rollback();
                Logger.getLogger(sql_agente.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(sql_agente.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }

    public boolean edit_Nombre(Connection c, int id, String nombre) {
        try {
            c.setAutoCommit(false);
            PreparedStatement st;
            String sql = "update agente set nombre =? where id_agente=?";
            st = c.prepareStatement(sql);
            st.setString(1, nombre);
            st.setInt(2, id);
            st.executeUpdate();
            c.commit();
            st.close();
            return true;
        } catch (SQLException ex) {
            try {
                c.rollback();
                Logger.getLogger(sql_agente.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(sql_agente.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }

    public boolean newagente(Connection c, Agentes a) {
        try {
            c.setAutoCommit(false);
            PreparedStatement st;
            String sql = "insert into agente"
                    + " values(?,?,?,?,?)";
            st = c.prepareStatement(sql);
            st.setInt(1, a.getIdagente());
            st.setString(2, a.getNombre());
            st.setInt(3, a.getIdcanal());
            st.setDouble(4, 0);
            st.setString(5, "1");
            st.setInt(6, a.getPlazo());
            st.setString(7, "");
            st.executeUpdate();
            c.commit();
            st.close();
            return true;
        } catch (SQLException ex) {
            try {
                c.rollback();
                Logger.getLogger(sql_agente.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(sql_agente.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }
}
