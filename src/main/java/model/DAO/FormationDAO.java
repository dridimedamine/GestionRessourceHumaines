/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.DAO;

import java.util.List;
import model.pojo.Formation;
import org.hibernate.SessionFactory;

/**
 *
 * @author pc
 */
public class FormationDAO implements IFormationDAO{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Formation> getFormations() {
         List l = getSessionFactory().getCurrentSession().createQuery("from Formation").list();
        return l; }

    @Override
    public void supprimerFormation(Formation formation) {
   getSessionFactory().getCurrentSession().delete(formation);  }

    @Override
    public void addFormation(Formation formation) {
       getSessionFactory().getCurrentSession().save(formation);}

    @Override
    public void updateFormation(Formation formation) {
          getSessionFactory().getCurrentSession().update(formation);    }
    
}
