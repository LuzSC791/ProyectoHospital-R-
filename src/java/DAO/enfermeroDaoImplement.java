/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Enfermeros;
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
public class enfermeroDaoImplement implements enfermeroDao
{

    @Override
    public void insertarEnfermero(Enfermeros enfermeros) 
    {
        Session session = null;
        try
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(enfermeros);
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
    public void modificaEnfermero(Enfermeros enfermeros)
    {
        Session session = null;
        try
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(enfermeros);
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
    public void eliminaEnfermero(Enfermeros enfermeros) 
    {
        Session session = null;
        try
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(enfermeros);
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
    public Enfermeros getEnfermeroById(int idEnfermero) 
    {
        List list = getSessionFactory().getCurrentSession()
                .createQuery("from Enfermeros where idEnfermero=?")
                .setParameter(0, idEnfermero).list();///CHECAR EN CASO DE FALLAR
        return (Enfermeros) list; 
    }

    @Override
    public List<Enfermeros> mostrarEnfermeros() 
    {
        Session session = null;
        List<Enfermeros> lista = null;
        try {
              session = NewHibernateUtil.getSessionFactory().openSession();
              Query query = session.createQuery("from Enfermeros");//Alumnos viene del paquete model
              lista = (List<Enfermeros>) query.list();
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
    public List<Enfermeros> getEnfermerosByIdHospital(int idHospital) 
    {
        List list = getSessionFactory().getCurrentSession()
                .createQuery("from Enfermeros where idHospital=?")
                .setParameter(0, idHospital).list();
        return list;
    }

    @Override
    public List<Enfermeros> getEnfermerosByIdArea(int idArea) 
    {
        List list = getSessionFactory().getCurrentSession()
                .createQuery("from Enfermeros where idArea=?")
                .setParameter(0, idArea).list();///CHECAR EN CASO DE FALLAR
        return list;
    }
 
}
