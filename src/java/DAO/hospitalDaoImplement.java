/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Hospitales;
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
public class hospitalDaoImplement implements hospitalDao
{

    @Override
    public void insertarHospital(Hospitales hospitales) 
    {
        Session session = null;
        try
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(hospitales);
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
    public void modificaHospital(Hospitales hospitales) 
    {
        Session session = null;
        try
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(hospitales);
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
    public void eliminaHospital(Hospitales hospitales) 
    {
        Session session = null;
        try
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(hospitales);
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
    public Hospitales getHospitalById(int idHospital) ////////////////////CHECAR
    {
        List list = getSessionFactory().getCurrentSession()
                .createQuery("from Hospitales where idHospital=?")
                .setParameter(0, idHospital).list();
        return (Hospitales) list;
    }

    
    @Override
    public List<Hospitales> mostrarHospitales() 
    {
        Session session = null;
        List<Hospitales> lista = null;
        try {
              session = NewHibernateUtil.getSessionFactory().openSession();
              Query query = session.createQuery("from Hospitales");//Alumnos viene del paquete model
              lista = (List<Hospitales>) query.list();
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
    
}
