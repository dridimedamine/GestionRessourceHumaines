/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.bean;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import model.pojo.Formateur;
import model.pojo.Formation;
import model.service.IFormationService;

/**
 *
 * @author pc
 */

@ManagedBean(name = "FormationMB")
@SessionScoped
public class FormationBean {
    
     private int idFormation;
     private Formateur formateur;
     private Integer nombreHeure;
     private String domaine;
     private Date dateDebutFormation;
     private Date dateFinFormation;

 @ManagedProperty(value="#{FormationService}")
     IFormationService formationService;
  private List<Formation> listformation;
  private Formation selectedformation;

    public Formateur getFormateur() {
        return formateur;
    }

    public void setFormateur(Formateur formateur) {
        this.formateur = formateur;
    }

    public Integer getNombreHeure() {
        return nombreHeure;
    }

    public void setNombreHeure(Integer nombreHeure) {
        this.nombreHeure = nombreHeure;
    }

    public Date getDateDebutFormation() {
        return dateDebutFormation;
    }

    public void setDateDebutFormation(Date dateDebutFormation) {
        this.dateDebutFormation = dateDebutFormation;
    }

    public Date getDateFinFormation() {
        return dateFinFormation;
    }

    public void setDateFinFormation(Date dateFinFormation) {
        this.dateFinFormation = dateFinFormation;
    }

    public Formation getSelectedformation() {
        if(selectedformation ==null)
        {
            return new Formation();
        }            
        else{
        return selectedformation;
    }}

    public void setSelectedformation(Formation selectedformation) {
        this.selectedformation = selectedformation;
    }
    public List<Formation> getListformation() {
       listformation = new ArrayList<Formation>();
       listformation.addAll(getFormationService().getFormations());
        return listformation;
    }

    public void setListformation(List<Formation> listformation) {
        this.listformation = listformation;
    }
  
  public int getIdFormation() {
        return idFormation;
    }

    public void setIdFormation(int idFormation) {
        this.idFormation = idFormation;
    }
    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }


    public IFormationService getFormationService() {
        return formationService;
    }

    public void setFormationService(IFormationService formationService) {
        this.formationService = formationService;
    }
     
    
  public void addFormation(){
      Formation fr = new Formation();
      
        
        // fr.personnel.setIdPersonnel(0);
     // fr.dossierFormateur.setIdDossierFormateur(0);
       fr.setDateDebutFormation(getDateDebutFormation());
       fr.setDateFinFormation(getDateFinFormation());
       fr.setDomaine(getDomaine());
      fr.setNombreHeure(getNombreHeure());
            
      
      getFormationService().addFormation(fr);
         
         reset();
      }
      public void reset(){
         this.setDomaine("");
          this.setNombreHeure(null);
          this.setDateDebutFormation(null);
          this.setDateFinFormation(null);
               
         
         
     }
    
     public void delateFormation(Formation formation){
         getFormationService().supprimerFormation(formation);
     
     }
     public void updateFormation(Formation  formation)
     {
         getFormationService().updateFormation(formation);
     }
    
  }
