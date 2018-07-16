/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.DAO;

import java.util.List;
import model.pojo.Formateur;
import org.hibernate.SessionFactory;

/**
 *
 * @author pc
 */
public class FormateurDAO implements IFormateurDAO{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Formateur> getFormateurs() {
   List l = getSessionFactory().getCurrentSession().createQuery("from Formateur").list();
        return l;  
    }

    @Override
    public void supprimerFormateur(Formateur Formateur) {
     getSessionFactory().getCurrentSession().delete(Formateur);
    }

    @Override
    public void addFormateur(Formateur Formateur) {
       getSessionFactory().getCurrentSession().save(Formateur);
    }

    @Override
    public void updateFormateur(Formateur Formateur) {
    getSessionFactory().getCurrentSession().update(Formateur);
    }

   
    
}
