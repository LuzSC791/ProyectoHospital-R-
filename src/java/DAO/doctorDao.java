/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Doctores;
import java.util.List;

/**
 *
 * @author lux_5
 */
public interface doctorDao 
{
    public void insertarDoctor(Doctores doctores);
    public void modificaDoctor(Doctores doctores);
    public void eliminaDoctor(Doctores doctores);
    public Doctores getDoctorById(int idDoctor); 
    public List<Doctores> mostrarDoctores();
    public List<Doctores> getDoctoresByIdHospital(int idHospital); //Ponerlo siempre en plural (DOCTORES) 
    public List<Doctores> getDoctoresByIdArea(int idArea); //Ponerlo siempre en plural (DOCTORES) 
}
