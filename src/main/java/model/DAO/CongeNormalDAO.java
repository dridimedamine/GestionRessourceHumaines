/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.DAO;

import java.util.List;
import model.pojo.CongeNormal;
import org.hibernate.SessionFactory;

/**
 *
 * @author pc
 */
public class CongeNormalDAO implements ICongeNormalDAO{
private SessionFactory sessionFactory;    

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addCongesNormal(CongeNormal congesNormal) {
        getSessionFactory().getCurrentSession().save(congesNormal);
    }

    @Override
    public List<CongeNormal> getCongesNormals() {
        List l = getSessionFactory().getCurrentSession().createQuery("from CongeNormal").list();
        return l;
    }

    @Override
    public void supprimerCongesNormal(CongeNormal congesNormal) {
      getSessionFactory().getCurrentSession().delete(congesNormal);
    }

    @Override
    public void updatecongesnormal(CongeNormal congesNormal) {
       getSessionFactory().getCurrentSession().update(congesNormal);
    }
}
