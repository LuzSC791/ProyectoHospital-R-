/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Model.Doctores;
import Model.Hospitales;
import java.util.List;

/**
 *
 * @author lux_5
 */
public interface ManttoService 
{
    //Mantenimiento a Historial
    public void insertarHospital(Hospitales hospitales);
    public void modificaHospital(Hospitales hospitales);
    public void eliminaHospital(Hospitales hospitales);
    public Hospitales getHospitalById(int idHospital);
    public List<Hospitales> mostrarHospitales();

    //Mantenimiento aDoctor
    public void insertarDoctor(Doctores doctores);
    public void modificaDoctor(Doctores doctores);
    public void eliminaDoctor(Doctores doctores);
    public Doctores getDoctorById(int idDoctor); 
    public List<Doctores> mostrarDoctores();
    public List<Doctores> getDoctoresByIdHospital(int idHospital); 
    
    
}
