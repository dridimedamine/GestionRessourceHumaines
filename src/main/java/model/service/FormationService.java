/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.service;

import java.util.List;
import model.DAO.IFormationDAO;
import model.pojo.Formation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pc
 */
public class FormationService implements IFormationService{
    private IFormationDAO formationDAO;

    public IFormationDAO getFormationDAO() {
        return formationDAO;
    }

    public void setFormationDAO(IFormationDAO formationDAO) {
        this.formationDAO = formationDAO;
    }

    @Override
     @Transactional(readOnly = false)
    public List<Formation> getFormations() {
      return getFormationDAO().getFormations();}

    @Override
     @Transactional(readOnly = false)
    public void supprimerFormation(Formation formation) {
        getFormationDAO().supprimerFormation(formation);  }

    @Override
     @Transactional(readOnly = false)
    public void addFormation(Formation formation) {
 getFormationDAO().addFormation(formation);  }

    @Override
     @Transactional(readOnly = false)
    public void updateFormation(Formation formation) {
  getFormationDAO().updateFormation(formation);  }
    
}
