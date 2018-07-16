/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.bean;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;


import model.pojo.Personnel;

import model.pojo.Projet;
import model.service.IProjetService;
import model.service.ProjetService;


/**
 *
 * @author pc
 */
@ManagedBean(name = "ProjetMB")
@SessionScoped
public class ProjetBean {
   
     @ManagedProperty(value="#{ProjetService}")
     IProjetService projetService;


       private int idProjet;
     private String titreProjet;
     private Integer dureProjet;
     private Double budget;
     private Integer nbrPersonnel;
     private String planProjet;
   private  ArrayList<Personnel> listPersonnel ; 
private List<Projet> listProjet;
private Projet selectetedProjet; 
private Part file;

    public IProjetService getProjetService() {
        return projetService;
    }

    public void setProjetService(IProjetService projetService) {
        this.projetService = projetService;
    }

    public int getIdProjet() {
        return idProjet;
    }

    public void setIdProjet(int idProjet) {
        this.idProjet = idProjet;
    }

    public String getTitreProjet() {
        return titreProjet;
    }

    public void setTitreProjet(String titreProjet) {
        this.titreProjet = titreProjet;
    }

    public Integer getDureProjet() {
        return dureProjet;
    }

    public void setDureProjet(Integer dureProjet) {
        this.dureProjet = dureProjet;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public Integer getNbrPersonnel() {
        return nbrPersonnel;
    }

    public void setNbrPersonnel(Integer nbrPersonnel) {
        this.nbrPersonnel = nbrPersonnel;
    }

    public String getPlanProjet() {
        return planProjet;
    }

    public void setPlanProjet(String planProjet) {
        this.planProjet = planProjet;
    }

    public ArrayList<Personnel> getListPersonnel() {
        return listPersonnel;
    }

    public void setListPersonnel(ArrayList<Personnel> listPersonnel) {
        this.listPersonnel = listPersonnel;
    }

    public List<Projet> getListProjet() {
        listProjet = new ArrayList<Projet>();
        listProjet.addAll(getProjetService().getProjet());
        return listProjet;
    }

    public void setListProjet(List<Projet> listProjet) {
        this.listProjet = listProjet;
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public Projet getSelectetedProjet() {
        
        if(selectetedProjet ==null)
        {
            return new Projet();
            
        }
        else {
        
        return selectetedProjet;
        }
        
    }

    public void setSelectetedProjet(Projet selectetedProjet) {
        this.selectetedProjet = selectetedProjet;
    }
   
      public void addProjet(){
        
             InputStream in = null;
              try {
             double d=Math.random()*(100-50);
             String d1=d+"";
             String nom=d1.substring(6);
             System.out.println(nom);
             nom = nom+".jpg";
             String path1="C:\\Users\\pc\\Documents\\Projet_GRH\\src\\main\\webapp\\ressources\\images\\"+nom;
             //String path1 = "E:\\G\\NetBeansProjectsar\\Projet_GRH\\src\\main\\webapp\\ressources\\images\\"+nom;
             String path2="ressources/images/"+nom;
             
             Projet pro = new Projet();
             pro.setBudget(getBudget());
             pro.setTitreProjet(getTitreProjet());
             pro.setPlanProjet(path2);
             pro.setNbrPersonnel(getNbrPersonnel());
             pro.setDureProjet(getDureProjet());
             
             // pro.setIdProjet(0);
             in = file.getInputStream();
             
             byte [] data=new byte[in.available()];
             in.read(data);
             FileOutputStream out = new FileOutputStream(new File(path1));
             
             out.write(data);
             in.close();
             out.close();
             FacesContext context = FacesContext.getCurrentInstance();
             context.addMessage(null, new FacesMessage("Succes", "Ajout est termine"));
              getProjetService().addProjet(pro);
             reset();
           
         } catch (IOException ex) {
             Logger.getLogger(ProjetBean.class.getName()).log(Level.SEVERE, null, ex);
         }
              
     
      
      
      }
      public void reset()
      {
         this.setBudget(null);
          this.setDureProjet(null);
          this.setPlanProjet("");
          
          setNbrPersonnel(null);
          setTitreProjet("");
          
      }
    public void SupprimerProjet(Projet projet){
         getProjetService().supprimerProjet(projet);
         
    }
   public void updateProjet (Projet projet)
   {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Succes", "Modification est termine"));
       getProjetService().updateProjet(projet);
   }
}
