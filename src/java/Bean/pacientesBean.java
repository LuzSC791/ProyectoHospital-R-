/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.historialDao;
import DAO.historialDaoImplement;
import DAO.hospitalDao;
import DAO.hospitalDaoImplement;
import DAO.pacienteDao;
import DAO.pacienteDaoImplement;
import Model.Historiales;
import Model.Hospitales;
import Model.Pacientes;
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

public class pacientesBean 
{
    private Pacientes paciente;
    private List<Pacientes> pacientes;
    private List<Hospitales> hospitales;
    private List<Historiales> historiales;
    private int idHospital;
    private int idHistorial;

    public Pacientes getPaciente() {
        return paciente;
    }

    public void setPaciente(Pacientes paciente) {
        this.paciente = paciente;
    }

    public List<Pacientes> getPacientes() 
    {
        pacienteDao dao = new pacienteDaoImplement();
        pacientes = dao.mostrarPacientes();
        return pacientes;
    }

    public void setPacientes(List<Pacientes> pacientes) {
        this.pacientes = pacientes;
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
    
    public List<Historiales> getHistoriales() 
    {
        historialDao dao = new historialDaoImplement();
        historiales = dao.mostrarHistoriales();
        return historiales;
    }

    public void setHistoriales(List<Historiales> historiales) {
        this.historiales = historiales;
    }

    public int getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(int idHistorial) {
        this.idHistorial = idHistorial;
    }

    public int getIdHospital() {
        return idHospital;
    }

    public void setIdHospital(int idHospital) {
        this.idHospital = idHospital;
    }


    /**
     * Creates a new instance of pacientesBean
     */
   public pacientesBean() 
    {
        paciente = new Pacientes();
    }
    
    public void addMessage(String summary)
    {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,null);
        FacesContext.getCurrentInstance().addMessage(null, message);   
    }
    
    public void insertar()
    {

        pacienteDao dao = new pacienteDaoImplement();
        dao.insertarPaciente(paciente);
        paciente = new Pacientes();
        addMessage("Paciente Agregado");
    }
    
    
    public void modificar()
    {
        pacienteDao dao = new pacienteDaoImplement();
        dao.modificaPaciente(paciente);
        paciente = new Pacientes();
        addMessage("Paciente Actualizado");
    }
    
    public void eliminar()
    {
        pacienteDao dao = new pacienteDaoImplement();
        dao.eliminaPaciente(paciente);
        paciente = new Pacientes();
        addMessage("Paciente Elminado");
    }


    public void getPacienteById(int idPaciente)
    {      
        pacienteDao dao = new pacienteDaoImplement();
        dao.getPacienteById(idPaciente);
    } 
}
