/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Pacientes;
import Persistencia.NewHibernateUtil;
import static Persistencia.NewHibernateUtil.getSessionFactory;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author lux_5
 */
public class pacienteDaoImplement implements pacienteDao
{

    @Override
    public void insertarPaciente(Pacientes pacientes) 
    {
       Session session = null;
        try
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(pacientes);
            session.getTransaction().commit();
        }
        catch(HibernateException e){
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }finally{
            if (session != null)
            {
                session.close();
            }
        }
    }

    @Override
    public void modificaPaciente(Pacientes pacientes) 
     {
        Session session = null;
        try
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(pacientes);
            session.getTransaction().commit();
        }
        catch(HibernateException e){
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }finally{
            if (session != null)
            {
                session.close();
            }
        }
    }

    @Override
    public void eliminaPaciente(Pacientes pacientes) 
    {
        Session session = null;
        try
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(pacientes);
            session.getTransaction().commit();
        }
        catch(HibernateException e){
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }finally{
            if (session != null)
            {
                session.close();
            }
        }
    }
    
    @Override
    public Pacientes getPacienteById(int idPaciente) 
    {
       List list = getSessionFactory().getCurrentSession()
                .createQuery("from Pacientes where idPaciente=?")
                .setParameter(0, idPaciente).list();///CHECAR EN CASO DE FALLAR
        return (Pacientes) list;
    }

    @Override
    public List<Pacientes> mostrarPacientes() 
    {
       Session session = null;
        List<Pacientes> lista = null;
        try {
              session = NewHibernateUtil.getSessionFactory().openSession();
              Query query = session.createQuery("from Pacientes");//Alumnos viene del paquete model
              lista = (List<Pacientes>) query.list();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());           
        }finally{
            if (session != null)
            {
                session.close();
            }
        }
        return lista;
    }

    @Override
    public List<Pacientes> getPacientesByIdHospital(int idHospital) 
    {
        List list = getSessionFactory().getCurrentSession()
                .createQuery("from Pacientes where idHospital=?")
                .setParameter(0, idHospital).list();
        return list;
    }

    @Override
    public List<Pacientes> getPacientesByIdHistorial(int idHistorial) 
    {
       List list = getSessionFactory().getCurrentSession()
                .createQuery("from Pacientes where idHistorial=?")
                .setParameter(0, idHistorial).list();
        return list;
    }
    
}
