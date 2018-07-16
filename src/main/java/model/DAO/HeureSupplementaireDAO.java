/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.DAO;

import java.util.List;
import model.pojo.HeureSupplementaire;
import org.hibernate.SessionFactory;

/**
 *
 * @author pc
 */
public class HeureSupplementaireDAO implements IHeureSupplementaireDAO{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<HeureSupplementaire> getHeureSupplementaire() {
        List l = getSessionFactory().getCurrentSession().createQuery("from HeureSupplementaire").list();
        return l;
    }

    @Override
    public void supprimerHeureSupplementaire(HeureSupplementaire heureSupplementaire) {
        getSessionFactory().getCurrentSession().delete(heureSupplementaire);
    }

    @Override
    public void addHeureSupplementaire(HeureSupplementaire heureSupplementaire) {
     getSessionFactory().getCurrentSession().save(heureSupplementaire);
    }

    @Override
    public void updateHeureSupplementaire(HeureSupplementaire heureSupplementaire) {
   getSessionFactory().getCurrentSession().update(heureSupplementaire);
    }
    
    
}
