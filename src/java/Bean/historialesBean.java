/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;


import DAO.historialDao;
import DAO.historialDaoImplement;
import Model.Historiales;
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

public class historialesBean 
{
    
    private Historiales historial;
    private List<Historiales> historiales;

    public Historiales getHistorial() {
        return historial;
    }

    public void setHistorial(Historiales historial) {
        this.historial = historial;
    }

    public List<Historiales> getHistoriales() 
    {
        historialDao dao = new historialDaoImplement();
        historiales = dao.mostrarHistoriales();
        return historiales;
    }

    public void setHistoriales(List<Historiales> historiales) {
        this.historiales = historiales;
    }
    
    /**
     * Creates a new instance of historialesBean
     */
    public historialesBean() 
    {
        historial = new Historiales();
    }
    
    public void addMessage(String summary)
    {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,null);
        FacesContext.getCurrentInstance().addMessage(null, message);   
    }
    
    public void insertar()
    {
        historialDao dao = new historialDaoImplement();
        dao.insertarHistorial(historial);
        historial = new Historiales();
        addMessage("Historial Agregado");
    }
    
    public void modificar()
    {
        historialDao dao = new historialDaoImplement();
        dao.modificaHistorial(historial);
        historial = new Historiales();
        addMessage("Historial Actualizado");
    }
    
    public void eliminar()
    {
        historialDao dao = new historialDaoImplement();
        dao.eliminaHistorial(historial);
        historial = new Historiales();
        addMessage("Historial Elminado");
    }
    
}
