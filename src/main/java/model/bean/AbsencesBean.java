/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.bean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import model.pojo.Absence;
import model.pojo.Personnel;
import model.service.IAbsenceService;
import model.service.IPersonnelService;

/**
 *
 * @author pc
 */

@ManagedBean(name = "AbsencesMB")
@SessionScoped
public class AbsencesBean {
    
    
     private int idAbsence;
     private Personnel personnel;
     private Integer nombreJourAbsence;
     private int selectedAbs;

      @ManagedProperty(value="#{AbsenceService}")
      IAbsenceService absencesService;
      @ManagedProperty(value="#{PersonnelService}")
      IPersonnelService personnelService;

    public int getSelectedAbs() {
        return selectedAbs;
    }

    public void setSelectedAbs(int selectedAbs) {
        this.selectedAbs = selectedAbs;
    }
    
      
  private List<Absence> listabsences;
  private List<Personnel> listpersonnel;
  private Absence selectedabsence;

    public Personnel getPersonnel() {
        return personnel;
    }

    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }

    public Integer getNombreJourAbsence() {
        return nombreJourAbsence;
    }

    public void setNombreJourAbsence(Integer nombreJourAbsence) {
        this.nombreJourAbsence = nombreJourAbsence;
    }

    public IAbsenceService getAbsencesService() {
        return absencesService;
    }

    public void setAbsencesService(IAbsenceService absencesService) {
        this.absencesService = absencesService;
    }

    public Absence getSelectedabsence() {
        if(selectedabsence == null)
        {
            return new Absence();
        }
        else {
        return selectedabsence;
    }
    }
    public void setSelectedabsence(Absence selectedabsence) {
        this.selectedabsence = selectedabsence;
    }

    public int getIdAbsence() {
        return idAbsence;
    }

    public void setIdAbsence(int idAbsence) {
        this.idAbsence = idAbsence;
    }

    public List<Personnel> getListpersonnel() {
        listpersonnel = new ArrayList<Personnel>();
        listpersonnel.addAll(getPersonnelService().getPersonnel());
        
        return listpersonnel;
    }

    public void setListpersonnel(List<Personnel> listpersonnel) {
        this.listpersonnel = listpersonnel;
    }

    public IPersonnelService getPersonnelService() {
       
        return personnelService;
    }

    public void setPersonnelService(IPersonnelService personnelService) {
        this.personnelService = personnelService;
    }

    public List<Absence> getListabsences() {
        
        listabsences = new ArrayList<Absence>();
        listabsences.addAll(getAbsencesService().getAbsenceses());
        return listabsences;
    }

    public void setListabsences(List<Absence> listabsences) {
        this.listabsences = listabsences;
    }
    
    public void addAbsences(){
        Absence ab = new Absence();
        Personnel p = new Personnel();
        p = getPersonnelService().getPersonnelById(selectedAbs);
        ab.setNombreJourAbsence(getNombreJourAbsence());
       
        ab.setPersonnel(p);
      
        getAbsencesService().addAbsences(ab);
        reset();
        //System.out.println("hhhhhhhhh"+selectedAbs);
       
    }
    public void reset(){
    this.setNombreJourAbsence(null);
    }
    public void supprimerAbsences(Absence absences)
    {
        getAbsencesService().supprimerAbsences(absences);
    }
    
    public String a(){
        return "2";
    }
    public void updateAbsences(Absence absences)
    {
        getAbsencesService().updateAbsences(absences);
        
        
    }
    
}
