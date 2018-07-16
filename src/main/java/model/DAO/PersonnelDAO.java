/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.DAO;

import java.util.Iterator;
import java.util.List;
import model.pojo.Personnel;
import org.hibernate.SessionFactory;

/**
 *
 * @author pc
 */
public class PersonnelDAO implements IPersonnelDAO{
private  SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Personnel> getPersonnel() {
         List l = getSessionFactory().getCurrentSession().createQuery("from Personnel").list();
        return l;
    }

    @Override
    public void supprimerPersonnel(Personnel personnel) {
      getSessionFactory().getCurrentSession().delete(personnel); }

    @Override
    public void addPersonnel(Personnel personnel) {
        getSessionFactory().getCurrentSession().save(personnel);
    }
    
    @Override
    public void updatePersonnel(Personnel personnel) {
       getSessionFactory().getCurrentSession().update(personnel);}

 @Override
     public List<Personnel> valide(String nom,String cin){
     
         List clt = getSessionFactory().getCurrentSession().createQuery("from Personnel where login='"+nom+"' and motpasse='"+cin+"'").list();
         return clt;
     
     }

    @Override
    public Personnel getPersonnelById(int id) {
       List list = getSessionFactory().getCurrentSession()
           .createQuery("from Personnel where id_personnel=?")
                 .setParameter(0, id).list();
  return (Personnel)list.get(0); 
    }
}
