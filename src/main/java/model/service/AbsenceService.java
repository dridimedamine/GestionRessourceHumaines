/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.service;

import java.util.List;
import model.DAO.IAbsenceDAO;
import model.pojo.Absence;

import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pc
 */
public class AbsenceService implements IAbsenceService{
    private IAbsenceDAO absenceDAO;

    

    public IAbsenceDAO getAbsenceDAO() {
        return absenceDAO;
    }

    public void setAbsenceDAO(IAbsenceDAO absenceDAO) {
        this.absenceDAO = absenceDAO;
    }


    
   
 @Override
     @Transactional(readOnly = false)
    public List<Absence> getAbsenceses() {
      return getAbsenceDAO().getAbsenceses();}

    @Override
     @Transactional(readOnly = false)
    public void supprimerAbsences(Absence absences) {
       getAbsenceDAO().supprimerAbsences(absences);
    }

    
    @Override
     @Transactional(readOnly = false)
    public void addAbsences(Absence absences) {
       getAbsenceDAO().addAbsences(absences);
    }

   

    @Override
    @Transactional(readOnly = false)
    public void updateAbsences(Absence absences) {
        getAbsenceDAO().updateAbsences(absences);
    }

    
    
}
