/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Agentes;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public interface Int_Agente {

    public ArrayList<Agentes> getagentes_all(Connection c);

    public ArrayList<Agentes> getagentes_var(Connection c, String var);

    public boolean getagentes_id(Connection c, int id, String operacion);

    public boolean newagente(Connection c, Agentes a);

    public boolean Edit_Plazo(Connection c, int id, int plazo);

}
