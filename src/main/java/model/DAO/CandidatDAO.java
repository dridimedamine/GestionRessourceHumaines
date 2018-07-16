/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.DAO;

import java.util.List;
import model.pojo.Candidat;
import org.hibernate.SessionFactory;

/**
 *
 * @author pc
 */
public class CandidatDAO implements ICandidatDAO{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Candidat> getCondidat() {
  List l = getSessionFactory().getCurrentSession().createQuery("from Candidat").list();
        return l;    }

    @Override
    public void supprimerCondidat(Candidat condidat) {
  getSessionFactory().getCurrentSession().delete(condidat);  }

    @Override
    public void addCondidat(Candidat condidat) {
        getSessionFactory().getCurrentSession().save(condidat);
    }

    @Override
    public void updateCondidat(Candidat condidat) {
 getSessionFactory().getCurrentSession().update(condidat);
    }
    
    
}
