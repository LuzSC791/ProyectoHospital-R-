/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.areaDao;
import DAO.areaDaoImplement;
import Model.Areas;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author lux_5
 */
@ManagedBean
@ViewScoped //DEPENDENCISA LAS QUE LLEVAN @ van antes de iniciar la clase
public class areasBean 
{
    private Areas area;
    private List<Areas> areas;

    public Areas getArea() {
        return area;
    }

    public void setArea(Areas area) {
        this.area = area;
    }

    public List<Areas> getAreas() 
    {
        areaDao dao = new areaDaoImplement();
        areas = dao.mostrarAreas();
        return areas;
    }

    public void setAreas(List<Areas> areas) {
        this.areas = areas;
    }
    /**
     * Creates a new instance of areasBean
     */
    public areasBean() 
    {
        area = new Areas();
    }
    
     public void addMessage(String summary)
    {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,null);
        FacesContext.getCurrentInstance().addMessage(null, message);   
    }
    
    public void insertar()
    {
        areaDao dao = new areaDaoImplement();
        dao.insertarArea(area);
        area = new Areas();
        addMessage("Area Agregada");
    }
    
    public void modificar()
    {
        areaDao dao = new areaDaoImplement();
        dao.modificaArea(area);
        area = new Areas();
        addMessage("Area Actualizada");
    }
    
    public void eliminar()
    {
        areaDao dao = new areaDaoImplement();
        dao.eliminaArea(area);
        area = new Areas();
        addMessage("Area Elminada");
    }
    
    public void getAreaById(int idArea)
    {        
        areaDao dao = new areaDaoImplement();
        dao.getAreaById(idArea);
    } 
    
}
