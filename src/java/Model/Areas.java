package Model;
// Generated 14/09/2021 08:00:16 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Areas generated by hbm2java
 */
public class Areas  implements java.io.Serializable {


     private Integer idArea;
     private String nombreArea;
     private String telefonoArea;
     private Set<Doctores> doctoreses = new HashSet<Doctores>(0);
     private Set<Enfermeros> enfermeroses = new HashSet<Enfermeros>(0);

    public Areas() {
    }

    public Areas(String nombreArea, String telefonoArea, Set<Doctores> doctoreses, Set<Enfermeros> enfermeroses) {
       this.nombreArea = nombreArea;
       this.telefonoArea = telefonoArea;
       this.doctoreses = doctoreses;
       this.enfermeroses = enfermeroses;
    }
   
    public Integer getIdArea() {
        return this.idArea;
    }
    
    public void setIdArea(Integer idArea) {
        this.idArea = idArea;
    }
    public String getNombreArea() {
        return this.nombreArea;
    }
    
    public void setNombreArea(String nombreArea) {
        this.nombreArea = nombreArea;
    }
    public String getTelefonoArea() {
        return this.telefonoArea;
    }
    
    public void setTelefonoArea(String telefonoArea) {
        this.telefonoArea = telefonoArea;
    }
    public Set<Doctores> getDoctoreses() {
        return this.doctoreses;
    }
    
    public void setDoctoreses(Set<Doctores> doctoreses) {
        this.doctoreses = doctoreses;
    }
    public Set<Enfermeros> getEnfermeroses() {
        return this.enfermeroses;
    }
    
    public void setEnfermeroses(Set<Enfermeros> enfermeroses) {
        this.enfermeroses = enfermeroses;
    }




}


