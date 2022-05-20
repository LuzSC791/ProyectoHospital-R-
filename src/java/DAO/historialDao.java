/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Historiales;
import java.util.List;

/**
 *
 * @author lux_5
 */
public interface historialDao 
{
    public void insertarHistorial(Historiales historiales);
    public void modificaHistorial(Historiales historiales);
    public void eliminaHistorial(Historiales historiales);
    public Historiales getHistorialById(int idHistorial);
    public List<Historiales> mostrarHistoriales();
}
