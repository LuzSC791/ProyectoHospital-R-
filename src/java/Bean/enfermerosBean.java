/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.areaDao;
import DAO.areaDaoImplement;
import DAO.enfermeroDao;
import DAO.enfermeroDaoImplement;
import DAO.hospitalDao;
import DAO.hospitalDaoImplement;
import Model.Areas;
import Model.Enfermeros;
import Model.Hospitales;
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

public class enfermerosBean 
{
    private Enfermeros enfermero;
    private List<Enfermeros> enfermeros;
    private List<Hospitales> hospitales;
    private List<Areas> areas;
    private int idHospital;
    private int idArea;

    public Enfermeros getEnfermero() {
        return enfermero;
    }

    public void setEnfermero(Enfermeros enfermero) {
        this.enfermero = enfermero;
    }

    public List<Enfermeros> getEnfermeros() 
    {
        enfermeroDao dao = new enfermeroDaoImplement();
        enfermeros = dao.mostrarEnfermeros();
        return enfermeros;
    }

    public void setEnfermeros(List<Enfermeros> enfermeros) {
        this.enfermeros = enfermeros;
    }
    
    public List<Hospitales> getHospitales() //HOSPITAL
    {
        hospitalDao dao = new hospitalDaoImplement();//QUITAR
        hospitales = dao.mostrarHospitales();//QUITAR
        return hospitales;
    }

    public void setHospitales(List<Hospitales> hospitales) {
        this.hospitales = hospitales;
    }

    public List<Areas> getAreas() //ARREA
    {
        areaDao dao = new areaDaoImplement();
        areas = dao.mostrarAreas();
        return areas;
    }

    public void setAreas(List<Areas> areas){
        this.areas = areas;
    }

    public int getIdHospital() 
    {
        
        return idHospital;
    }

    public void setIdHospital(int idHospital) {
        this.idHospital = idHospital;
    }

    public int getIdArea() 
    {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }


    /**
     * Creates a new instance of enfermerosBean
     */
    public enfermerosBean() 
    {
        enfermero = new Enfermeros();
    }
    
    public void addMessage(String summary)
    {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,null);
        FacesContext.getCurrentInstance().addMessage(null, message);   
    }
    
    public void insertar()
    {
        //HOSPITALES
        Hospitales hos = new Hospitales();
        hos.setIdHospital(idHospital);
        enfermero.setHospitales(hos);  
        //AREAS
        Areas are = new Areas();
        are.setIdArea(idArea);
        enfermero.setAreas(are);
        //ENFERMEROS
        enfermeroDao dao = new enfermeroDaoImplement();
        dao.insertarEnfermero(enfermero);
        enfermero = new Enfermeros();
        addMessage("Enfermero Agregado");
    }
    
    public void modificar()
    {
        enfermeroDao dao = new enfermeroDaoImplement();
        dao.modificaEnfermero(enfermero);
        enfermero = new Enfermeros();
        addMessage("Enfermero Actualizado");
    }
    
    public void eliminar()
    {
        enfermeroDao dao = new enfermeroDaoImplement();
        dao.eliminaEnfermero(enfermero);
        enfermero = new Enfermeros();
        addMessage("Enfermero Elminado");
    }
    
    public void getEnfermeroById(int idEnfermero)
    {      
        enfermeroDao dao = new enfermeroDaoImplement();
        dao.getEnfermeroById(idEnfermero);
    } 
}
