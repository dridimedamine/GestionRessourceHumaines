/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.service;

import java.util.List;
import model.DAO.ICandidatDAO;
import model.pojo.Candidat;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pc
 */
public class CandidatService implements ICandidatService{
    private ICandidatDAO candidatDAO;

    public ICandidatDAO getCandidatDAO() {
        return candidatDAO;
    }

    public void setCandidatDAO(ICandidatDAO candidatDAO) {
        this.candidatDAO = candidatDAO;
    }

    
    @Override
    @Transactional(readOnly = false)
    public List<Candidat> getCondidat() {
 return getCandidatDAO().getCondidat();
    }

    @Override
    @Transactional(readOnly = false)
    public void supprimerCondidat(Candidat condidat) {
 getCandidatDAO().supprimerCondidat(condidat);
    }

    @Override
    @Transactional(readOnly = false)
    public void addCondidat(Candidat condidat) {
 getCandidatDAO().addCondidat(condidat);    }

    @Override
    @Transactional(readOnly = false)
    public void updateCondidat(Candidat condidat) {
 getCandidatDAO().updateCondidat(condidat);   }
    
    
}
