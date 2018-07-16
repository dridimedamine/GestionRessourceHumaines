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
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;

import model.pojo.CongeMaladie;

import model.pojo.Personnel;
import model.service.ICongeMaladieService;
import model.service.IPersonnelService;


/**
 *
 * @author pc
 */

@ManagedBean(name = "CongesMaladiesMB")
@SessionScoped
public class CongesMaladieBean {
    
    @ManagedProperty(value="#{CongeMaladieService}")
    ICongeMaladieService congeMaladieService;
    
    @ManagedProperty(value="#{PersonnelService}")
    IPersonnelService personnelService;
    
     private List<CongeMaladie> listcongemaladies;
     
     private int idCongeMaladie;
     private Personnel personnel;
     private Date dateDebutCm;
     private Date dateFinCm;
     private String justification;
     private String descriptionEtType;
     private int selectedCM;


private CongeMaladie selectedcongemaladies;
private Part file;

    public int getSelectedCM() {
        return selectedCM;
    }

    public void setSelectedCM(int selectedCM) {
        this.selectedCM = selectedCM;
    }


    public IPersonnelService getPersonnelService() {
        return personnelService;
    }

    public void setPersonnelService(IPersonnelService personnelService) {
        this.personnelService = personnelService;
    }

    public ICongeMaladieService getCongeMaladieService() {
        return congeMaladieService;
    }

    public void setCongeMaladieService(ICongeMaladieService congeMaladieService) {
        this.congeMaladieService = congeMaladieService;
    }

    public List<CongeMaladie> getListcongemaladies() {
        listcongemaladies = new ArrayList<CongeMaladie>();
        listcongemaladies.addAll(getCongeMaladieService().getCongesMaladies());
        return listcongemaladies;
    }

    public void setListcongemaladies(List<CongeMaladie> listcongemaladies) {
        this.listcongemaladies = listcongemaladies;
    }

    public int getIdCongeMaladie() {
        return idCongeMaladie;
    }

    public void setIdCongeMaladie(int idCongeMaladie) {
        this.idCongeMaladie = idCongeMaladie;
    }

    public Personnel getPersonnel() {
        return personnel;
    }

    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }

    public Date getDateDebutCm() {
        return dateDebutCm;
    }

    public void setDateDebutCm(Date dateDebutCm) {
        this.dateDebutCm = dateDebutCm;
    }

    public Date getDateFinCm() {
        return dateFinCm;
    }

    public void setDateFinCm(Date dateFinCm) {
        this.dateFinCm = dateFinCm;
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    public String getDescriptionEtType() {
        return descriptionEtType;
    }

    public void setDescriptionEtType(String descriptionEtType) {
        this.descriptionEtType = descriptionEtType;
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    
    public CongeMaladie getSelectedcongesmaladies() {
        
        if( selectedcongemaladies ==null)
        {
            return new CongeMaladie();
        }
        else{
        return selectedcongemaladies;
    }}

    public void setSelectedcongemaladies(CongeMaladie selectedcongesmaladies) {
        this.selectedcongemaladies = selectedcongemaladies;
    }
public void reset()
{
   this.setDescriptionEtType("");
   this.setJustification("");
   this.setDateDebutCm(null);
   this.setDateFinCm(null);
   

}
    
public void addCongesMaladies() throws IOException{
    
        InputStream in = null;
        double d=Math.random()*(100-50);
         String d1=d+"";
         String nom=d1.substring(6);
         System.out.println(nom);
         nom = nom+".jpg";
         String path1 = "C:\\Users\\pc\\Documents\\Projet_GRH\\src\\main\\webapp\\ressources\\images\\"+nom;
         String path2="ressources/images/"+nom;
          
          CongeMaladie cm = new CongeMaladie();
          Personnel pe = new Personnel();
          pe = getPersonnelService().getPersonnelById(selectedCM);
            cm.setDescriptionEtType(getDescriptionEtType());
            cm.setDateDebutCm(getDateDebutCm());
            cm.setDateFinCm(getDateFinCm());
            cm.setJustification(path2);
            cm.setPersonnel(pe);
             in = file.getInputStream();
             
             byte [] data=new byte[in.available()];
             in.read(data);
             FileOutputStream out = new FileOutputStream(new File(path1));
             
             out.write(data);
             in.close();
             out.close();
                getCongeMaladieService().addCongesMaladie(cm);
            reset();
      
}
public void SupprimerCongesMaladies(CongeMaladie congesMaladie)
{
    getCongeMaladieService().supprimerCongesMaladie(congesMaladie);
  //  congesMaladieService.supprimerCongesMaladie(congesMaladie);
}
public void updatecongemaladie(CongeMaladie congeMaladie)
        
{
    getCongeMaladieService().updateCongesMaladies(congeMaladie);
}



}
