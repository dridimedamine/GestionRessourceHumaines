/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.DAO;

import java.util.List;
import model.pojo.Absence;

import org.hibernate.SessionFactory;

/**
 *
 * @author pc
 */
public class AbsenceDAO implements IAbsenceDAO{
    
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Absence> getAbsenceses() {
         List l = getSessionFactory().getCurrentSession().createQuery("from Absence").list();
        return l; }

    @Override
    public void supprimerAbsences(Absence absences) {
      getSessionFactory().getCurrentSession().delete(absences);
    }

    @Override
    public void addAbsences(Absence absences) {
    getSessionFactory().getCurrentSession().save(absences);
    }

    

    @Override
    public void updateAbsences(Absence absences) {
       getSessionFactory().getCurrentSession().update(absences);
    }

    


}

   
    

