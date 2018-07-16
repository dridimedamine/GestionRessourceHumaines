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
import static java.lang.System.in;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import javax.servlet.http.Part;

import model.pojo.Formateur;
import model.pojo.Formation;
import model.pojo.Personnel;

import model.service.IFormateurService;

/**
 *
 * @author pc
 */

@ManagedBean(name = "FormateurMB")
@SessionScoped
public class FormateurBean {
     
     @ManagedProperty(value="#{FormateurService}")
     IFormateurService formateurService;
     
  
     private List<Formateur> listformateur;
  
     private int idFormateur;
     private String nomPrenomFormateur;
     private String cinFormateur;
     private String adresseFormateur;
     private Integer numTelFormatur;
     private String cv;
     private Set<Formation> formations = new HashSet<Formation>(0);
   private Formateur selectedformateur;
  private Part file;
  private List<SelectItem> mesFormateurs;

    public List<SelectItem> getMesFormateurs() {
        if (mesFormateurs == null) {
            mesFormateurs = new ArrayList<SelectItem>();
            for (Formateur obj : getListformateur()) {
                 mesFormateurs.add(new SelectItem(obj.getIdFormateur(),obj.getNomPrenomFormateur()));

            }
        }
        
        
        return mesFormateurs;
    }

    public void setMesFormateurs(List<SelectItem> mesFormateurs) {
        this.mesFormateurs = mesFormateurs;
    }

    public IFormateurService getFormateurService() {
        return formateurService;
    }

    public void setFormateurService(IFormateurService formateurService) {
        this.formateurService = formateurService;
    }
  

   

    public List<Formateur> getListformateur() {
        listformateur = new ArrayList<Formateur>();
        listformateur.addAll(getFormateurService().getFormateurs());
        return listformateur;
    }

    public void setListformateur(List<Formateur> listformateur) {
        this.listformateur = listformateur;
    }

    public int getIdFormateur() {
        return idFormateur;
    }

    public void setIdFormateur(int idFormateur) {
        this.idFormateur = idFormateur;
    }

    public String getNomPrenomFormateur() {
        return nomPrenomFormateur;
    }

    public void setNomPrenomFormateur(String nomPrenomFormateur) {
        this.nomPrenomFormateur = nomPrenomFormateur;
    }

    public String getCinFormateur() {
        return cinFormateur;
    }

    public void setCinFormateur(String cinFormateur) {
        this.cinFormateur = cinFormateur;
    }

    public String getAdresseFormateur() {
        return adresseFormateur;
    }

    public void setAdresseFormateur(String adresseFormateur) {
        this.adresseFormateur = adresseFormateur;
    }

    public Integer getNumTelFormatur() {
        return numTelFormatur;
    }

    public void setNumTelFormatur(Integer numTelFormatur) {
        this.numTelFormatur = numTelFormatur;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public Set<Formation> getFormations() {
        return formations;
    }

    public void setFormations(Set<Formation> formations) {
        this.formations = formations;
    }

    public Formateur getSelectedformateur() {
        if(selectedformateur ==null)
        {
            return new Formateur();
            
        }
        else{
        return selectedformateur;
    }}

    public void setSelectedformateur(Formateur selectedformateur) {
        this.selectedformateur = selectedformateur;
    }
  

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }
    public void reset()
    {
        this.setAdresseFormateur("");
        this.setCinFormateur("");
        this.setCv("");
       this.setNomPrenomFormateur("");
       this.setNumTelFormatur(null);
    }
    public void addDossierFormateur() throws IOException{
         InputStream in = null;
            
             double d=Math.random()*(100-50);
             String d1=d+"";
             String nom=d1.substring(6);
             System.out.println(nom);
             nom = nom+".jpg";
             //String path1="C:\\Users\\pc\\Documents\\NetBeansProjects\\Application_GRH\\src\\main\\webapp\\ressources\\images\\"+nom;
             String path1 = "C:\\Users\\pc\\Documents\\Projet_GRH\\src\\main\\webapp\\ressources\\images\\"+nom;
             String path2="ressources/images/"+nom;
         Formateur f = new Formateur();
         Formation fr = new Formation();
         f.setNomPrenomFormateur(getNomPrenomFormateur());
         f.setCinFormateur(getCinFormateur());
         f.setCv(path2);
         f.setAdresseFormateur("");
         f.setNumTelFormatur(0);
        
         
             
             // pro.setIdProjet(0);
             in = file.getInputStream();
             
             byte [] data=new byte[in.available()];
             in.read(data);
             FileOutputStream out = new FileOutputStream(new File(path1));
             
             out.write(data);
             in.close();
             out.close();
             
           getFormateurService().addFormateur(f);
             
             reset();
         
    }
    public void supprimerFormateur(Formateur Formateur)
    {
        getFormateurService().supprimerFormateur(Formateur);
        //dossierFormateurService.supprimerDossierFormateur(dossierFormateur);
    }
    public void updateFormateur(Formateur Formateur)
    {
        getFormateurService().updateFormateur(Formateur);
    }
}
