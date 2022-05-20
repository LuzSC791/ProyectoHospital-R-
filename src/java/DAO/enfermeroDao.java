/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Enfermeros;
import java.util.List;

/**
 *
 * @author lux_5
 */
public interface enfermeroDao 
{
    public void insertarEnfermero(Enfermeros enfermeros);
    public void modificaEnfermero(Enfermeros enfermeros);
    public void eliminaEnfermero(Enfermeros enfermeros);
    public Enfermeros getEnfermeroById(int idEnfermero);
    public List<Enfermeros> mostrarEnfermeros();   
    public List<Enfermeros> getEnfermerosByIdHospital(int idHospital); //Ponerlo siempre en plural (EMFERMEROS) 
    public List<Enfermeros> getEnfermerosByIdArea(int idArea); //Ponerlo siempre en plural (EMFERMEROS) 
}
