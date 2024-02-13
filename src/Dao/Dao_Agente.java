/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Agentes;
import Persistencia.sql_agente;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public class Dao_Agente implements Int_Agente {

    private final sql_agente s = new sql_agente();

    /**
     * Obtiene todos los agentes para su despliegue en una tabla, mostrará
     * incluso los dados de baja.
     *
     * @param c COnexion
     * @return Lista de agentes
     */
    @Override
    public ArrayList<Agentes> getagentes_all(Connection c) {
        return s.getagentes_all(c);
    }

    /**
     * Obtiene una lista de agentes dada por busqueda por el nombre y traera
     * todo lo que tenga, siempre y cuando sea estatus 1, si no, n lo mostrará.
     * Esta funcion maneja LIKE para la consulta
     *
     * @param c COnexion
     * @param var Variable o nombre capturado
     * @return Lista de agentes
     */
    @Override
    public ArrayList<Agentes> getagentes_var(Connection c, String var) {
        return s.getagentes_var(c, var);
    }

    /**
     * Busca un cliente en especifico y cambiará su estatus
     *
     * @param c conexion
     * @param id id del agente
     * @param operacion
     * @return booelan
     */
    @Override
    public boolean getagentes_id(Connection c, int id, String operacion) {
        return s.getagentes_id(c, id, operacion);
    }

    /**
     * Inserta nuevo agente a la bd
     *
     * @param c conexion
     * @param a agente
     * @return boolean
     */
    @Override
    public boolean newagente(Connection c, Agentes a) {
        return s.newagente(c, a);
    }

}