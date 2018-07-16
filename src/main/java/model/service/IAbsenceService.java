/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.service;

import java.util.List;
import model.pojo.Absence;



/**
 *
 * @author pc
 */
public interface IAbsenceService {
    public List<Absence> getAbsenceses();
    
    public void supprimerAbsences(Absence absences);
    public void addAbsences(Absence absences);
    public void updateAbsences(Absence absences);
  
  
}
