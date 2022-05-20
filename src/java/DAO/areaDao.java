/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Areas;
import java.util.List;

/**
 *
 * @author lux_5
 */
public interface areaDao 
{
    public void insertarArea(Areas areas);
    public void modificaArea(Areas areas);
    public void eliminaArea (Areas areas);
    public Areas getAreaById(int idArea);
    public List<Areas> mostrarAreas();
    
}
