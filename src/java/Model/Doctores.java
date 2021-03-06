package Model;
// Generated 14/09/2021 08:00:16 PM by Hibernate Tools 4.3.1



/**
 * Doctores generated by hbm2java
 */
public class Doctores  implements java.io.Serializable {


     private Integer idDoctor;
     private Areas areas;
     private Hospitales hospitales;
     private String nombreDoctor;
     private String apaternoDoctor;
     private String amaternoDoctor;
     private String sexoDoctor;
     private Integer edadDoctor;
     private String telefonoDoctor;
     private String direccionDoctor;
     private String correoDoctor;
     private Double sueldoDoctor;

    public Doctores() {
    }

    public Doctores(Areas areas, Hospitales hospitales, String nombreDoctor, String apaternoDoctor, String amaternoDoctor, String sexoDoctor, Integer edadDoctor, String telefonoDoctor, String direccionDoctor, String correoDoctor, Double sueldoDoctor) {
       this.areas = areas;
       this.hospitales = hospitales;
       this.nombreDoctor = nombreDoctor;
       this.apaternoDoctor = apaternoDoctor;
       this.amaternoDoctor = amaternoDoctor;
       this.sexoDoctor = sexoDoctor;
       this.edadDoctor = edadDoctor;
       this.telefonoDoctor = telefonoDoctor;
       this.direccionDoctor = direccionDoctor;
       this.correoDoctor = correoDoctor;
       this.sueldoDoctor = sueldoDoctor;
    }
   
    public Integer getIdDoctor() {
        return this.idDoctor;
    }
    
    public void setIdDoctor(Integer idDoctor) {
        this.idDoctor = idDoctor;
    }
    public Areas getAreas() {
        return this.areas;
    }
    
    public void setAreas(Areas areas) {
        this.areas = areas;
    }
    public Hospitales getHospitales() {
        return this.hospitales;
    }
    
    public void setHospitales(Hospitales hospitales) {
        this.hospitales = hospitales;
    }
    public String getNombreDoctor() {
        return this.nombreDoctor;
    }
    
    public void setNombreDoctor(String nombreDoctor) {
        this.nombreDoctor = nombreDoctor;
    }
    public String getApaternoDoctor() {
        return this.apaternoDoctor;
    }
    
    public void setApaternoDoctor(String apaternoDoctor) {
        this.apaternoDoctor = apaternoDoctor;
    }
    public String getAmaternoDoctor() {
        return this.amaternoDoctor;
    }
    
    public void setAmaternoDoctor(String amaternoDoctor) {
        this.amaternoDoctor = amaternoDoctor;
    }
    public String getSexoDoctor() {
        return this.sexoDoctor;
    }
    
    public void setSexoDoctor(String sexoDoctor) {
        this.sexoDoctor = sexoDoctor;
    }
    public Integer getEdadDoctor() {
        return this.edadDoctor;
    }
    
    public void setEdadDoctor(Integer edadDoctor) {
        this.edadDoctor = edadDoctor;
    }
    public String getTelefonoDoctor() {
        return this.telefonoDoctor;
    }
    
    public void setTelefonoDoctor(String telefonoDoctor) {
        this.telefonoDoctor = telefonoDoctor;
    }
    public String getDireccionDoctor() {
        return this.direccionDoctor;
    }
    
    public void setDireccionDoctor(String direccionDoctor) {
        this.direccionDoctor = direccionDoctor;
    }
    public String getCorreoDoctor() {
        return this.correoDoctor;
    }
    
    public void setCorreoDoctor(String correoDoctor) {
        this.correoDoctor = correoDoctor;
    }
    public Double getSueldoDoctor() {
        return this.sueldoDoctor;
    }
    
    public void setSueldoDoctor(Double sueldoDoctor) {
        this.sueldoDoctor = sueldoDoctor;
    }




}


