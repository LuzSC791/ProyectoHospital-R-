/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.areaDao;
import DAO.areaDaoImplement;
import DAO.doctorDao;
import DAO.doctorDaoImplement;
import DAO.hospitalDao;
import DAO.hospitalDaoImplement;
import Model.Areas;
import Model.Doctores;
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

public class doctoresBean 
{
    private Doctores doctor;
    private List<Doctores> doctores;
    private List<Hospitales> hospitales;
    private List<Areas> areas;
    private int idHospital;
    private int idArea;
    
    public Doctores getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctores doctor) {
        this.doctor = doctor;
    }

    public List<Doctores> getDoctores() 
    {
        doctorDao dao = new doctorDaoImplement();//Instancia
        doctores = dao.mostrarDoctores();//Trae metodo
        return doctores;
    }

    public void setDoctores(List<Doctores> doctores) {
        this.doctores = doctores;
    }

    public List<Hospitales> getHospitales() //LISTA HOSPITAL
    {
        hospitalDao dao = new hospitalDaoImplement();//QUITAR
        hospitales = dao.mostrarHospitales();//QUITAR
        return hospitales;
    }
    
    public void setHospitales(List<Hospitales> hospitales) {
        this.hospitales = hospitales;
    }

    public int getIdHospital() {
        return idHospital;
    }

    public void setIdHospital(int idHospital) {
        this.idHospital = idHospital;
    }
    
    public List<Areas> getAreas() //LISTA DE ARREAS
    {
        areaDao dao = new areaDaoImplement();
        areas = dao.mostrarAreas();
        return areas;
    }

    public void setAreas(List<Areas> areas) {
        this.areas = areas;
    }

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }
    
    /**
     * Creates a new instance of doctoresBean
     */
    public doctoresBean() 
    {
        doctor = new Doctores();
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
        doctor.setHospitales(hos);  
        //AREAS
        Areas are = new Areas();
        are.setIdArea(idArea);
        doctor.setAreas(are);
        //DOCTORES
        doctorDao dao = new doctorDaoImplement();
        dao.insertarDoctor(doctor);
        doctor = new Doctores();
        addMessage("Doctor Agregado");
    }
    
    public void modificar()
    {
        doctorDao dao = new doctorDaoImplement();
        dao.modificaDoctor(doctor);
        doctor = new Doctores();
        addMessage("Doctor Actualizado");
    }
    
    public void eliminar()
    {
        doctorDao dao = new doctorDaoImplement();
        dao.eliminaDoctor(doctor);
        doctor = new Doctores();
        addMessage("Doctor Elminada");
    }

    public void getDoctorById(int idDoctor)
    {      
        doctorDao dao = new doctorDaoImplement();
        dao.getDoctorById(idDoctor);
    } 

}
