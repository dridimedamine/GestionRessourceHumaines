/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.service;

import java.util.List;
import model.DAO.FormateurDAO;
import model.DAO.IFormateurDAO;
import model.pojo.Formateur;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pc
 */
public class FormateurService implements IFormateurService{
    private IFormateurDAO FormateurDAO;

    public IFormateurDAO getFormateurDAO() {
        return FormateurDAO;
    }

    public void setFormateurDAO(IFormateurDAO FormateurDAO) {
        this.FormateurDAO = FormateurDAO;
    }

    @Override
     @Transactional(readOnly = false)
    public List<Formateur> getFormateurs() {
        return getFormateurDAO().getFormateurs();
    }

    @Override
     @Transactional(readOnly = false)
    public void supprimerFormateur(Formateur Formateur) {
        getFormateurDAO().supprimerFormateur(Formateur);
    }

    @Override
     @Transactional(readOnly = false)
    public void addFormateur(Formateur Formateur) {
       getFormateurDAO().addFormateur(Formateur);
    }

    @Override
     @Transactional(readOnly = false)
    public void updateFormateur(Formateur Formateur) {
       getFormateurDAO().updateFormateur(Formateur);
    }

   
    
    
}
