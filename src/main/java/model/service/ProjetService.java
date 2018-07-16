/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.service;

import java.util.List;
import model.DAO.IProjetDAO;
import model.pojo.Projet;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pc
 */
public class ProjetService implements IProjetService{
     IProjetDAO projetDAO;

    public IProjetDAO getProjetDAO() {
        return projetDAO;
    }

    public void setProjetDAO(IProjetDAO projetDAO) {
        this.projetDAO = projetDAO;
    }

    @Override
    @Transactional(readOnly = false)
    public List<Projet> getProjet() {
       
    return getProjetDAO().getProjet();
    }

        @Override
    @Transactional(readOnly = false)
    public void supprimerProjet(Projet projet) {
  getProjetDAO().supprimerProjet(projet);
    
    
    }

       @Override
    @Transactional(readOnly = false)
    public void addProjet(Projet projet) {
    
    getProjetDAO().addProjet(projet);
    
    }

        @Override
    @Transactional(readOnly = false)
    public void updateProjet(Projet projet) {
  getProjetDAO().updateProjet(projet);
    
    
    }
    
}
