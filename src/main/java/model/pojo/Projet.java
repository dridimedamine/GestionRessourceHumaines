package model.pojo;
// Generated 22 juin 2016 15:27:10 by Hibernate Tools 3.6.0


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Projet generated by hbm2java
 */
@Entity
@Table(name="projet"
    ,schema="dbo"
    ,catalog="Application_GRH"
)
public class Projet  implements java.io.Serializable {


     private int idProjet;
     private String titreProjet;
     private Integer dureProjet;
     private Double budget;
     private Integer nbrPersonnel;
     private String planProjet;

    public Projet() {
    }

	
    public Projet(int idProjet) {
        this.idProjet = idProjet;
    }
    public Projet(int idProjet, String titreProjet, Integer dureProjet, Double budget, Integer nbrPersonnel, String planProjet) {
       this.idProjet = idProjet;
       this.titreProjet = titreProjet;
       this.dureProjet = dureProjet;
       this.budget = budget;
       this.nbrPersonnel = nbrPersonnel;
       this.planProjet = planProjet;
    }
   
     @Id 
     @GeneratedValue(strategy = GenerationType.AUTO)


    
    @Column(name="id_projet", unique=true, nullable=false)
    public int getIdProjet() {
        return this.idProjet;
    }
    
    public void setIdProjet(int idProjet) {
        this.idProjet = idProjet;
    }

    
    @Column(name="titre_projet", length=50)
    public String getTitreProjet() {
        return this.titreProjet;
    }
    
    public void setTitreProjet(String titreProjet) {
        this.titreProjet = titreProjet;
    }

    
    @Column(name="dure_projet")
    public Integer getDureProjet() {
        return this.dureProjet;
    }
    
    public void setDureProjet(Integer dureProjet) {
        this.dureProjet = dureProjet;
    }

    
    @Column(name="budget", precision=53, scale=0)
    public Double getBudget() {
        return this.budget;
    }
    
    public void setBudget(Double budget) {
        this.budget = budget;
    }

    
    @Column(name="nbr_personnel")
    public Integer getNbrPersonnel() {
        return this.nbrPersonnel;
    }
    
    public void setNbrPersonnel(Integer nbrPersonnel) {
        this.nbrPersonnel = nbrPersonnel;
    }

    
    @Column(name="plan_projet", length=500)
    public String getPlanProjet() {
        return this.planProjet;
    }
    
    public void setPlanProjet(String planProjet) {
        this.planProjet = planProjet;
    }




}

