/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.DAO;

import java.util.List;
import model.pojo.CongeMaladie;

import org.hibernate.SessionFactory;

/**
 *
 * @author pc
 */
public class CongeMaladieDAO implements ICongeMaladieDAO{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<CongeMaladie> getCongesMaladies() {
        List l =getSessionFactory().getCurrentSession().createQuery("from CongeMaladie").list();
    return l;
    }

    @Override
    public void supprimerCongesMaladie(CongeMaladie congesMaladie) {
       getSessionFactory().getCurrentSession().delete(congesMaladie);
    }

    @Override
    public void addCongesMaladie(CongeMaladie congesMaladie) {
       getSessionFactory().getCurrentSession().save(congesMaladie);   
    }

    @Override
    public void updateCongesMaladies(CongeMaladie congesMaladie) {
       getSessionFactory().getCurrentSession().update(congesMaladie);}

   
}
