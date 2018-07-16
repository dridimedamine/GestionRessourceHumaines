/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.service;


import java.util.List;
import model.DAO.IPersonnelDAO;
import model.pojo.Personnel;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pc
 */
public class PersonnelService implements IPersonnelService{
    private IPersonnelDAO personnelDAO;

    public IPersonnelDAO getPersonnelDAO() {
        return personnelDAO;
    }

    public void setPersonnelDAO(IPersonnelDAO personnelDAO) {
        
        this.personnelDAO = personnelDAO;
    }

    @Override
    @Transactional(readOnly = false)
    public List<Personnel> getPersonnel() {
        return getPersonnelDAO().getPersonnel();
    }

    @Override
    @Transactional(readOnly = false)
    public void supprimerPersonnel(Personnel personnel) {
       getPersonnelDAO().supprimerPersonnel(personnel);}

    @Override
    @Transactional(readOnly = false)
    public void addPersonnel(Personnel personnel) {
       
        
    getPersonnelDAO().addPersonnel(personnel);
    }

      @Override
    @Transactional(readOnly = false)
    public void updatePersonnel(Personnel personnel) {
        getPersonnelDAO().updatePersonnel(personnel);}
    
     @Override
     @Transactional(readOnly = false)
    public List<Personnel> valide(String login,String motpasse) {
       return getPersonnelDAO().valide(login,motpasse);
    }

    @Override
    @Transactional(readOnly = false)
    public Personnel getPersonnelById(int id) {
       return getPersonnelDAO().getPersonnelById(id);
    }
    
    
}
