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

import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;

import model.pojo.Candidat;
import model.service.ICandidatService;

/**
 *
 * @author pc
 */

@ManagedBean(name = "CondidatMB")
@SessionScoped
public class CondidatBean {
       
    private int idCandidat;
     private String nomPrenomCandidat;
     private String cinCandidat;
     private Integer numTelCandidat;
     private String adresseCandidat;
     private Date dateNaissanceCandidat;
     private String cv;
     private String motivation;
     private Part file;

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

       @ManagedProperty(value="#{CandidatService}")
               ICandidatService candidatService;
       private List<Candidat> listcndidat;
       private Candidat selectedcndidat;

    public int getIdCandidat() {
        return idCandidat;
    }

    public void setIdCandidat(int idCandidat) {
        this.idCandidat = idCandidat;
    }

    public String getNomPrenomCandidat() {
        return nomPrenomCandidat;
    }

    public void setNomPrenomCandidat(String nomPrenomCandidat) {
        this.nomPrenomCandidat = nomPrenomCandidat;
    }

    public String getCinCandidat() {
        return cinCandidat;
    }

    public void setCinCandidat(String cinCandidat) {
        this.cinCandidat = cinCandidat;
    }

    public Integer getNumTelCandidat() {
        return numTelCandidat;
    }

    public void setNumTelCandidat(Integer numTelCandidat) {
        this.numTelCandidat = numTelCandidat;
    }

    public String getAdresseCandidat() {
        return adresseCandidat;
    }

    public void setAdresseCandidat(String adresseCandidat) {
        this.adresseCandidat = adresseCandidat;
    }

    public Date getDateNaissanceCandidat() {
        return dateNaissanceCandidat;
    }

    public void setDateNaissanceCandidat(Date dateNaissanceCandidat) {
        this.dateNaissanceCandidat = dateNaissanceCandidat;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getMotivation() {
        return motivation;
    }

    public void setMotivation(String motivation) {
        this.motivation = motivation;
    }

    public ICandidatService getCandidatService() {
        return candidatService;
    }

    public void setCandidatService(ICandidatService candidatService) {
        this.candidatService = candidatService;
    }

    public List<Candidat> getListcndidat() {
         
        listcndidat = new ArrayList<Candidat>();
        listcndidat.addAll(getCandidatService().getCondidat());
        
    
        return listcndidat;
    }

    public void setListcndidat(List<Candidat> listcndidat) {
        this.listcndidat = listcndidat;
    }

    public Candidat getSelectedcndidat() {
        if(selectedcndidat ==null)
        {
            return new Candidat();
        }
        else{
        return selectedcndidat;
    }}

    public void setSelectedcndidat(Candidat selectedcndidat) {
        this.selectedcndidat = selectedcndidat;
    }

   
       
       public void addCondidat() throws IOException
       {
            InputStream in = null;
        double d=Math.random()*(100-50);
         String d1=d+"";
         String nom=d1.substring(6);
         System.out.println(nom);
         nom = nom+".jpg";
         String path1 = "C:\\Users\\pc\\Documents\\Projet_GRH\\src\\main\\webapp\\ressources\\images\\"+nom;
         String path2="ressources/images/"+nom;
          
            
            Candidat co = new Candidat();
            co.setAdresseCandidat(getAdresseCandidat());
            co.setCinCandidat(getCinCandidat());
            co.setCv(path2);
            co.setDateNaissanceCandidat(getDateNaissanceCandidat());
            co.setMotivation(getMotivation());
            co.setNomPrenomCandidat(getNomPrenomCandidat());
            co.setNumTelCandidat(getNumTelCandidat());
            byte [] data=new byte[in.available()];
             in.read(data);
             FileOutputStream out = new FileOutputStream(new File(path1));
             
             out.write(data);
             in.close();
             out.close();
            getCandidatService().addCondidat(co);
            //  condidatService.addCondidat(co);
            
            reset();
        
          
       }
       public void reset(){
           this.setAdresseCandidat(null);
          this.setCinCandidat(null);
          this.setMotivation(null);
          this.setNomPrenomCandidat(null);
          this.setNumTelCandidat(null);
          this.setCv(null);
       
       }
       public void supprimerCondidat(Candidat condidat){
           getCandidatService().supprimerCondidat(condidat);
       }
       public void updateCondidat(Candidat condidat)
       {
           getCandidatService().updateCondidat(condidat);
       }
       
}
