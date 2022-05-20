/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Areas;
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
public class areaDaoImplement implements areaDao
{

    @Override
    public void insertarArea(Areas areas) 
    {
       Session session = null;
        try
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(areas);
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
    public void modificaArea(Areas areas) 
    {
        Session session = null;
        try
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(areas);
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
    public void eliminaArea(Areas areas) 
    {
        Session session = null;
        try
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(areas);
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
    public Areas getAreaById(int idArea) 
    {
        List list = getSessionFactory().getCurrentSession()
                .createQuery("from Areas where idArea=?")
                .setParameter(0, idArea).list();///CHECAR EN CASO DE FALLAR
        return (Areas) list;       
    }
    
    @Override
    public List<Areas> mostrarAreas() 
    {
        Session session = null;
        List<Areas> lista = null;
        try {
              session = NewHibernateUtil.getSessionFactory().openSession();
              Query query = session.createQuery("from Areas");//Alumnos viene del paquete model
              lista = (List<Areas>) query.list();
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
