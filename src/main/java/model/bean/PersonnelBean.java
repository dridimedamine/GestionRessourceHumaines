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
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.Part;
import model.pojo.Absence;
import model.pojo.CongeMaladie;
import model.pojo.CongeNormal;

import model.pojo.HeureSupplementaire;

import model.pojo.Personnel;
import model.service.IPersonnelService;


/**
 *
 * @author pc
 */
@ManagedBean(name = "PersonnelMB")
@SessionScoped
public class PersonnelBean {
  
     private int idPersonnel;
     private String nomPrenomPersonnel;
     private String cin;
     private String adresse;
     private Integer numTelPersonnel;
     private Date dateNaissancePersonnel;
     private String post;
     private Double salaire;
     private String login;
     private String motpasse;
     private String cvPersonnel;
     private Set<HeureSupplementaire> heureSupplementaires = new HashSet<HeureSupplementaire>(0);
     private Set<CongeNormal> congeNormals = new HashSet<CongeNormal>(0);
     private Set<Absence> absences = new HashSet<Absence>(0);
     private Set<CongeMaladie> congeMaladies = new HashSet<CongeMaladie>(0);
   @ManagedProperty(value="#{PersonnelService}")
     IPersonnelService personnelService;
     private List<Personnel> listPersonnel;
      private List<Personnel> personneAuth;
    private List<SelectItem> mesPersonel;
    private int sp;
    private List<Personnel> filteredPers;
    private Personnel selectedPersonnel;
    private Part file;

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public Integer getNumTelPersonnel() {
        return numTelPersonnel;
    }

    public void setNumTelPersonnel(Integer numTelPersonnel) {
        this.numTelPersonnel = numTelPersonnel;
    }

    public Date getDateNaissancePersonnel() {
        return dateNaissancePersonnel;
    }

    public void setDateNaissancePersonnel(Date dateNaissancePersonnel) {
        this.dateNaissancePersonnel = dateNaissancePersonnel;
    }

    public String getCvPersonnel() {
        return cvPersonnel;
    }

    public void setCvPersonnel(String cvPersonnel) {
        this.cvPersonnel = cvPersonnel;
    }

    public Set<HeureSupplementaire> getHeureSupplementaires() {
        return heureSupplementaires;
    }

    public void setHeureSupplementaires(Set<HeureSupplementaire> heureSupplementaires) {
        this.heureSupplementaires = heureSupplementaires;
    }

    public Set<CongeNormal> getCongeNormals() {
        return congeNormals;
    }

    public void setCongeNormals(Set<CongeNormal> congeNormals) {
        this.congeNormals = congeNormals;
    }

    public Set<Absence> getAbsences() {
        return absences;
    }

    public void setAbsences(Set<Absence> absences) {
        this.absences = absences;
    }

    public Set<CongeMaladie> getCongeMaladies() {
        return congeMaladies;
    }

    public void setCongeMaladies(Set<CongeMaladie> congeMaladies) {
        this.congeMaladies = congeMaladies;
    }
    
      public int getIdPersonnel() {
        return idPersonnel;
    }

    public void setIdPersonnel(int idPersonnel) {
        this.idPersonnel = idPersonnel;
    }

    public String getNomPrenomPersonnel() {
        return nomPrenomPersonnel;
    }

    public void setNomPrenomPersonnel(String nomPrenomPersonnel) {
        this.nomPrenomPersonnel = nomPrenomPersonnel;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Double getSalaire() {
        return salaire;
    }

    public void setSalaire(Double salaire) {
        this.salaire = salaire;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMotpasse() {
        return motpasse;
    }

    public void setMotpasse(String motpasse) {
        this.motpasse = motpasse;
    }

    public int getSp() {
        return sp;
    }

    public void setSp(int sp) {
        this.sp = sp;
    }

    
     public Personnel getSelectedPersonnel() {
         if(selectedPersonnel == null){
           
        return new Personnel();
        }
        else{
            return selectedPersonnel;
        }
        
    }

    public void setSelectedPersonnel(Personnel selectedPersonnel) {
        this.selectedPersonnel = selectedPersonnel;
    }
     
     
    public List<Personnel> getFilteredPers() {
        return filteredPers;
    }

    public void setFilteredPers(List<Personnel> filteredPers) {
        this.filteredPers = filteredPers;
    }

    
     public List<Personnel> getPersonneAuth() {
        return personneAuth;
    }

    public void setPersonneAuth(List<Personnel> personneAuth) {
        this.personneAuth = personneAuth;
    }
     
 

    
     public List<SelectItem> getMesPersonel() {
        if (mesPersonel == null) {
            mesPersonel = new ArrayList<SelectItem>();
            for (Personnel obj : getListPersonnel()) {
                 mesPersonel.add(new SelectItem(obj.getIdPersonnel(),obj.getNomPrenomPersonnel()));

            }
        }
        
        return mesPersonel;    }

    public void setMesPersonel(List<SelectItem> mesPersonel) {
        this.mesPersonel = mesPersonel;
    }
    
    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }


    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

  
    public IPersonnelService getPersonnelService() {
        return personnelService;
    }

    public void setPersonnelService(IPersonnelService personnelService) {
        this.personnelService = personnelService;
    }

    public List<Personnel> getListPersonnel() {
        listPersonnel = new ArrayList<Personnel>();
        
        listPersonnel.addAll(getPersonnelService().getPersonnel());
        return listPersonnel;
    }

    public void setListPersonnel(List<Personnel> listPersonnel) {
        this.listPersonnel = listPersonnel;
    }
     
    
     public void supprimerPersonnel(Personnel personnel){
         getPersonnelService().supprimerPersonnel(personnel);
     
     }
      public void addPersonnel( Personnel personnel) throws IOException{
        InputStream in = null;
        double d=Math.random()*(100-50);
         String d1=d+"";
         String nom=d1.substring(6);
         System.out.println(nom);
         nom = nom+".jpg";
         String path1 = "C:\\Users\\pc\\Documents\\Projet_GRH\\src\\main\\webapp\\ressources\\images\\"+nom;
         String path2="ressources/images/"+nom;
         Personnel pe = new Personnel();
         pe.setDateNaissancePersonnel(getDateNaissancePersonnel());
         pe.setCin(getCin());
         pe.setCvPersonnel(path2);
         pe.setPost(getPost());
         pe.setNomPrenomPersonnel(getNomPrenomPersonnel());
         pe.setNumTelPersonnel(getNumTelPersonnel());
         pe.setAdresse(getAdresse());
         pe.setSalaire(getSalaire());
          in = file.getInputStream();
             
             byte [] data=new byte[in.available()];
             in.read(data);
             FileOutputStream out = new FileOutputStream(new File(path1));
             
             out.write(data);
             in.close();
             out.close();
             FacesContext context = FacesContext.getCurrentInstance();
             context.addMessage(null, new FacesMessage("Succes", "Ajout est termine"));
         getPersonnelService().addPersonnel(pe);
         reset();
      }
     public void reset(){
         this.setAdresse(""); 
         this.setCin("");
      this.setDateNaissancePersonnel(null);
          this.setPost("");
          this.setNomPrenomPersonnel("");
          this.setNumTelPersonnel(null);
          this.setLogin("");
          this.setMotpasse("");
         this.setSalaire(0.0);
         
     }
     
    /**
     * Creates a new instance of PersonnelBN
   
    public PersonnelBean() {
    }
      */
      public String connecter() 
    {   personneAuth=new ArrayList<Personnel>();
        personneAuth.addAll(getPersonnelService().valide(login, motpasse));
        if(personneAuth.size()>0){
            Personnel c=personneAuth.get(0);
           
               
           
        return "application"
                ;}
        
        
        else
        {
            return "errorAuth";

       }
}
      public void upadtePersonnel(Personnel pr){
          FacesContext context = FacesContext.getCurrentInstance();
             context.addMessage(null, new FacesMessage("Succes", "Modification est termine"));
       getPersonnelService().updatePersonnel(pr);
        
    }
      
      
      
} // Fin Bean
