/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.DAO;

import java.util.List;
import model.pojo.Projet;
import org.hibernate.SessionFactory;

/**
 *
 * @author pc
 */
public class ProjetDAO implements IProjetDAO{
    private  SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Projet> getProjet() {
    List l = getSessionFactory().getCurrentSession().createQuery("from Projet").list();
        return l; }

    @Override
    public void supprimerProjet(Projet projet) {
     getSessionFactory().getCurrentSession().delete(projet);}

    @Override
    public void addProjet(Projet projet) {
     getSessionFactory().getCurrentSession().save(projet);}

    @Override
    public void updateProjet(Projet projet) {
         getSessionFactory().getCurrentSession().update(projet);
    }
    
}
