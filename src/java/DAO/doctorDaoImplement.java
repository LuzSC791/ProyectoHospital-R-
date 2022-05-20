/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Doctores;
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
public class doctorDaoImplement implements doctorDao
{

    @Override
    public void insertarDoctor(Doctores doctores) 
    {
        Session session = null;
        try
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(doctores);
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
    public void modificaDoctor(Doctores doctores) 
    {
        Session session = null;
        try
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(doctores);
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
    public void eliminaDoctor(Doctores doctores) 
    {
        Session session = null;
        try
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(doctores);
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
    public Doctores getDoctorById(int idDoctor) 
    { ////TENEMOS QUE EDITARLO
        List list = getSessionFactory().getCurrentSession()
                .createQuery("from Doctores where idDoctor=?")
                .setParameter(0, idDoctor).list();
        return (Doctores) list;
    }

    @Override
    public List<Doctores> mostrarDoctores() 
    {
        Session session = null;
        List<Doctores> lista = null;
        try {
              session = NewHibernateUtil.getSessionFactory().openSession();
              Query query = session.createQuery("from Doctores");//Alumnos viene del paquete model
              lista = (List<Doctores>) query.list();
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
    public List<Doctores> getDoctoresByIdHospital(int idHospital) 
    {
        List list = getSessionFactory().getCurrentSession()
                .createQuery("from Doctores where idHospital=?")
                .setParameter(0, idHospital).list();
        return list;
    }

    @Override
    public List<Doctores> getDoctoresByIdArea(int idArea) 
    {
        List list = getSessionFactory().getCurrentSession()
                .createQuery("from Doctores where idArea=?")
                .setParameter(0, idArea).list();///CHECAR EN CASO DE FALLAR
        return list;  
    }
    
}
