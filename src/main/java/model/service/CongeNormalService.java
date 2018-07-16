/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.service;

import java.util.List;
import model.DAO.ICongeNormalDAO;
import model.pojo.CongeNormal;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pc
 */
public class CongeNormalService implements ICongeNormalService{
    private ICongeNormalDAO congeNormalDAO;

    public ICongeNormalDAO getCongeNormalDAO() {
        return congeNormalDAO;
    }

    public void setCongeNormalDAO(ICongeNormalDAO congeNormalDAO) {
        this.congeNormalDAO = congeNormalDAO;
    }
    
@Override
     @Transactional(readOnly = false)
    public void addCongesNormal(CongeNormal congesNormal) {
       getCongeNormalDAO().addCongesNormal(congesNormal);
    }

@Override
     @Transactional(readOnly = false)
    public List<CongeNormal> getCongesNormals() {
        return getCongeNormalDAO().getCongesNormals();
    }

   @Override
     @Transactional(readOnly = false)
    public void supprimerCongesNormal(CongeNormal congesNormal) {
    getCongeNormalDAO().supprimerCongesNormal(congesNormal);}

    @Override
    @Transactional (readOnly = false)
    public void updatecongesnormal(CongeNormal congesNormal) {
    getCongeNormalDAO().updatecongesnormal(congesNormal);    }
    
}
