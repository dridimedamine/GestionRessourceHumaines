package model.pojo;
// Generated 22 juin 2016 15:27:10 by Hibernate Tools 3.6.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Personnel generated by hbm2java
 */
@Entity
@Table(name="Personnel"
    ,schema="dbo"
    ,catalog="Application_GRH"
)
public class Personnel  implements java.io.Serializable {


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

    public Personnel() {
    }

	
    public Personnel(int idPersonnel) {
        this.idPersonnel = idPersonnel;
    }
    public Personnel(int idPersonnel, String nomPrenomPersonnel, String cin, String adresse, Integer numTelPersonnel, Date dateNaissancePersonnel, String post, Double salaire, String login, String motpasse, String cvPersonnel, Set<HeureSupplementaire> heureSupplementaires, Set<CongeNormal> congeNormals, Set<Absence> absences, Set<CongeMaladie> congeMaladies) {
       this.idPersonnel = idPersonnel;
       this.nomPrenomPersonnel = nomPrenomPersonnel;
       this.cin = cin;
       this.adresse = adresse;
       this.numTelPersonnel = numTelPersonnel;
       this.dateNaissancePersonnel = dateNaissancePersonnel;
       this.post = post;
       this.salaire = salaire;
       this.login = login;
       this.motpasse = motpasse;
       this.cvPersonnel = cvPersonnel;
       this.heureSupplementaires = heureSupplementaires;
       this.congeNormals = congeNormals;
       this.absences = absences;
       this.congeMaladies = congeMaladies;
    }
   
     @Id 
@GeneratedValue(strategy = GenerationType.AUTO)

    
    @Column(name="id_personnel", unique=true, nullable=false)
    public int getIdPersonnel() {
        return this.idPersonnel;
    }
    
    public void setIdPersonnel(int idPersonnel) {
        this.idPersonnel = idPersonnel;
    }

    
    @Column(name="nom_prenom_personnel", length=150)
    public String getNomPrenomPersonnel() {
        return this.nomPrenomPersonnel;
    }
    
    public void setNomPrenomPersonnel(String nomPrenomPersonnel) {
        this.nomPrenomPersonnel = nomPrenomPersonnel;
    }

    
    @Column(name="cin", length=50)
    public String getCin() {
        return this.cin;
    }
    
    public void setCin(String cin) {
        this.cin = cin;
    }

    
    @Column(name="adresse", length=300)
    public String getAdresse() {
        return this.adresse;
    }
    
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    
    @Column(name="num_tel_personnel")
    public Integer getNumTelPersonnel() {
        return this.numTelPersonnel;
    }
    
    public void setNumTelPersonnel(Integer numTelPersonnel) {
        this.numTelPersonnel = numTelPersonnel;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="date_naissance_personnel", length=10)
    public Date getDateNaissancePersonnel() {
        return this.dateNaissancePersonnel;
    }
    
    public void setDateNaissancePersonnel(Date dateNaissancePersonnel) {
        this.dateNaissancePersonnel = dateNaissancePersonnel;
    }

    
    @Column(name="post", length=50)
    public String getPost() {
        return this.post;
    }
    
    public void setPost(String post) {
        this.post = post;
    }

    
    @Column(name="salaire", precision=53, scale=0)
    public Double getSalaire() {
        return this.salaire;
    }
    
    public void setSalaire(Double salaire) {
        this.salaire = salaire;
    }

    
    @Column(name="login", length=50)
    public String getLogin() {
        return this.login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }

    
    @Column(name="motpasse", length=50)
    public String getMotpasse() {
        return this.motpasse;
    }
    
    public void setMotpasse(String motpasse) {
        this.motpasse = motpasse;
    }

    
    @Column(name="cv_personnel", length=500)
    public String getCvPersonnel() {
        return this.cvPersonnel;
    }
    
    public void setCvPersonnel(String cvPersonnel) {
        this.cvPersonnel = cvPersonnel;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="personnel")
    public Set<HeureSupplementaire> getHeureSupplementaires() {
        return this.heureSupplementaires;
    }
    
    public void setHeureSupplementaires(Set<HeureSupplementaire> heureSupplementaires) {
        this.heureSupplementaires = heureSupplementaires;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="personnel")
    public Set<CongeNormal> getCongeNormals() {
        return this.congeNormals;
    }
    
    public void setCongeNormals(Set<CongeNormal> congeNormals) {
        this.congeNormals = congeNormals;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="personnel")
    public Set<Absence> getAbsences() {
        return this.absences;
    }
    
    public void setAbsences(Set<Absence> absences) {
        this.absences = absences;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="personnel")
    public Set<CongeMaladie> getCongeMaladies() {
        return this.congeMaladies;
    }
    
    public void setCongeMaladies(Set<CongeMaladie> congeMaladies) {
        this.congeMaladies = congeMaladies;
    }




}


