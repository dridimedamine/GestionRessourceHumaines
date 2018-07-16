/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.service;

import java.util.List;
import model.DAO.ICongeMaladieDAO;
import model.pojo.CongeMaladie;
import model.pojo.Personnel;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pc
 */
public class CongeMaladieService implements ICongeMaladieService{
    private ICongeMaladieDAO congeMaladieDAO;
    private IPersonnelService personnelService;

    public ICongeMaladieDAO getCongeMaladieDAO() {
        return congeMaladieDAO;
    }

    public void setCongeMaladieDAO(ICongeMaladieDAO congeMaladieDAO) {
        this.congeMaladieDAO = congeMaladieDAO;
    }

    public IPersonnelService getPersonnelService() {
        return personnelService;
    }

    public void setPersonnelService(IPersonnelService personnelService) {
        this.personnelService = personnelService;
    }
   

    @Override
       @Transactional(readOnly = false)
    public List<CongeMaladie> getCongesMaladies() {
       return getCongeMaladieDAO().getCongesMaladies();
    }

    @Override
       @Transactional(readOnly = false)
    public void supprimerCongesMaladie(CongeMaladie congesMaladie) {
        getCongeMaladieDAO().supprimerCongesMaladie(congesMaladie);
    }

    @Override
       @Transactional(readOnly = false)
    public void addCongesMaladie(CongeMaladie congesMaladie) {
    getCongeMaladieDAO().addCongesMaladie(congesMaladie);}

    @Override
       @Transactional(readOnly = false)
    public void updateCongesMaladies(CongeMaladie congesMaladie) {
    getCongeMaladieDAO().updateCongesMaladies(congesMaladie);}

    
    
}
