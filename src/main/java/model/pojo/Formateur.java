package model.pojo;
// Generated 22 juin 2016 15:27:10 by Hibernate Tools 3.6.0


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

/**
 * Formateur generated by hbm2java
 */
@Entity
@Table(name="formateur"
    ,schema="dbo"
    ,catalog="Application_GRH"
)
public class Formateur  implements java.io.Serializable {


     private int idFormateur;
     private String nomPrenomFormateur;
     private String cinFormateur;
     private String adresseFormateur;
     private Integer numTelFormatur;
     private String cv;
     private Set<Formation> formations = new HashSet<Formation>(0);

    public Formateur() {
    }

	
    public Formateur(int idFormateur) {
        this.idFormateur = idFormateur;
    }
    public Formateur(int idFormateur, String nomPrenomFormateur, String cinFormateur, String adresseFormateur, Integer numTelFormatur, String cv, Set<Formation> formations) {
       this.idFormateur = idFormateur;
       this.nomPrenomFormateur = nomPrenomFormateur;
       this.cinFormateur = cinFormateur;
       this.adresseFormateur = adresseFormateur;
       this.numTelFormatur = numTelFormatur;
       this.cv = cv;
       this.formations = formations;
    }
   
     @Id 
@GeneratedValue(strategy = GenerationType.AUTO)

    
    @Column(name="id_formateur", unique=true, nullable=false)
    public int getIdFormateur() {
        return this.idFormateur;
    }
    
    public void setIdFormateur(int idFormateur) {
        this.idFormateur = idFormateur;
    }

    
    @Column(name="nom_prenom_formateur", length=50)
    public String getNomPrenomFormateur() {
        return this.nomPrenomFormateur;
    }
    
    public void setNomPrenomFormateur(String nomPrenomFormateur) {
        this.nomPrenomFormateur = nomPrenomFormateur;
    }

    
    @Column(name="cin_formateur", length=50)
    public String getCinFormateur() {
        return this.cinFormateur;
    }
    
    public void setCinFormateur(String cinFormateur) {
        this.cinFormateur = cinFormateur;
    }

    
    @Column(name="adresse_formateur", length=500)
    public String getAdresseFormateur() {
        return this.adresseFormateur;
    }
    
    public void setAdresseFormateur(String adresseFormateur) {
        this.adresseFormateur = adresseFormateur;
    }

    
    @Column(name="num_tel_formatur")
    public Integer getNumTelFormatur() {
        return this.numTelFormatur;
    }
    
    public void setNumTelFormatur(Integer numTelFormatur) {
        this.numTelFormatur = numTelFormatur;
    }

    
    @Column(name="cv", length=500)
    public String getCv() {
        return this.cv;
    }
    
    public void setCv(String cv) {
        this.cv = cv;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="formateur")
    public Set<Formation> getFormations() {
        return this.formations;
    }
    
    public void setFormations(Set<Formation> formations) {
        this.formations = formations;
    }




}


