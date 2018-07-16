/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.service;

import java.util.List;
import model.DAO.IHeureSupplementaireDAO;
import model.pojo.HeureSupplementaire;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pc
 */
public class HeureSupplementaireService implements IHeureSupplementaireService{
    
    
    private IHeureSupplementaireDAO iHeureSupplementaireDAO;

    public IHeureSupplementaireDAO getiHeureSupplementaireDAO() {
        return iHeureSupplementaireDAO;
    }

    public void setiHeureSupplementaireDAO(IHeureSupplementaireDAO iHeureSupplementaireDAO) {
        this.iHeureSupplementaireDAO = iHeureSupplementaireDAO;
    }

  
    @Override
     @Transactional(readOnly = false)
    public List<HeureSupplementaire> getHeureSupplementaire() {
        return getiHeureSupplementaireDAO().getHeureSupplementaire();
    }

    @Override
     @Transactional(readOnly = false)
    public void supprimerHeureSupplementaire(HeureSupplementaire heureSupplementaire) {
  getiHeureSupplementaireDAO().supprimerHeureSupplementaire(heureSupplementaire);
    }

    @Override
     @Transactional(readOnly = false)
    public void addHeureSupplementaire(HeureSupplementaire heureSupplementaire) {
       getiHeureSupplementaireDAO().addHeureSupplementaire(heureSupplementaire);
    }

    @Override
     @Transactional(readOnly = false)
    public void updateHeureSupplementaire(HeureSupplementaire heureSupplementaire) {
    getiHeureSupplementaireDAO().updateHeureSupplementaire(heureSupplementaire);
    }
    
}
