/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Pacientes;
import java.util.List;

/**
 *
 * @author lux_5
 */
public interface pacienteDao 
{
    public void insertarPaciente(Pacientes pacientes);
    public void modificaPaciente(Pacientes pacientes);
    public void eliminaPaciente(Pacientes pacientes);
    public Pacientes getPacienteById(int idPaciente);
    public List<Pacientes> mostrarPacientes();
    public List<Pacientes> getPacientesByIdHospital(int idHospital); //Ponerlo siempre en plural (Paciente)
    public List<Pacientes> getPacientesByIdHistorial(int idHistorial); //Ponerlo siempre en plural (Paciente)
}
