/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Hospitales;
import java.util.List;

/**
 *
 * @author lux_5
 */
public interface hospitalDao 
{
    public void insertarHospital(Hospitales hospitales);
    public void modificaHospital(Hospitales hospitales);
    public void eliminaHospital(Hospitales hospitales);
    public Hospitales getHospitalById(int idHospital); 
    public List<Hospitales> mostrarHospitales();
    
}
