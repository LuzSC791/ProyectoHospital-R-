/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;


import DAO.hospitalDao;
import DAO.hospitalDaoImplement;
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

public class hospitalesBean 
{ 
    private Hospitales hospital;
    private List<Hospitales> hospitales;
    
    public Hospitales getHospital() {
        return hospital;
    }

    public void setHospital(Hospitales hospital) {
        this.hospital = hospital;
    }

    public List<Hospitales> getHospitales() 
    {
        hospitalDao dao = new hospitalDaoImplement();
        hospitales = dao.mostrarHospitales();
        return hospitales;
    }

    public void setHospitales(List<Hospitales> hospitales) {
        this.hospitales = hospitales;
    }

    /**
     * Creates a new instance of hospitalesBean
     */
    public hospitalesBean() 
    {
        hospital = new Hospitales();   
    }
    
    public void addMessage(String summary)
    {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,null);
        FacesContext.getCurrentInstance().addMessage(null, message);   
    }
    
    public void insertar()
    {
        hospitalDao dao = new hospitalDaoImplement();
        dao.insertarHospital(hospital); 
        hospital = new Hospitales(); 
        addMessage("Hospital Agregado");
    }
    
    public void modificar()
    {
        hospitalDao dao = new hospitalDaoImplement();
        dao.modificaHospital(hospital);
        hospital = new Hospitales();  
        addMessage("Hospital Actualizado");
    }
    
    public void eliminar()
    {
        hospitalDao dao = new hospitalDaoImplement();
        dao.eliminaHospital(hospital);
        hospital = new Hospitales();  
        addMessage("Hospital Elminadao");
    }
    
    public void getHospitalById(int idHospital)
    {        
        hospitalDao dao = new hospitalDaoImplement();
        dao.getHospitalById(idHospital);
    } 
}
