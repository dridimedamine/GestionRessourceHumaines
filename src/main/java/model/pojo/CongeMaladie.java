package model.pojo;
// Generated 22 juin 2016 15:27:10 by Hibernate Tools 3.6.0


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * CongeMaladie generated by hbm2java
 */
@Entity
@Table(name="conge_maladie"
    ,schema="dbo"
    ,catalog="Application_GRH"
)
public class CongeMaladie  implements java.io.Serializable {


     private int idCongeMaladie;
     private Personnel personnel;
     private Date dateDebutCm;
     private Date dateFinCm;
     private String justification;
     private String descriptionEtType;

    public CongeMaladie() {
    }

	
    public CongeMaladie(int idCongeMaladie) {
        this.idCongeMaladie = idCongeMaladie;
    }
    public CongeMaladie(int idCongeMaladie, Personnel personnel, Date dateDebutCm, Date dateFinCm, String justification, String descriptionEtType) {
       this.idCongeMaladie = idCongeMaladie;
       this.personnel = personnel;
       this.dateDebutCm = dateDebutCm;
       this.dateFinCm = dateFinCm;
       this.justification = justification;
       this.descriptionEtType = descriptionEtType;
    }
   
     @Id 
     @GeneratedValue(strategy = GenerationType.AUTO)


    
    @Column(name="id_conge_maladie", unique=true, nullable=false)
    public int getIdCongeMaladie() {
        return this.idCongeMaladie;
    }
    
    public void setIdCongeMaladie(int idCongeMaladie) {
        this.idCongeMaladie = idCongeMaladie;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_personnel")
    public Personnel getPersonnel() {
        return this.personnel;
    }
    
    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="date_debut_CM", length=10)
    public Date getDateDebutCm() {
        return this.dateDebutCm;
    }
    
    public void setDateDebutCm(Date dateDebutCm) {
        this.dateDebutCm = dateDebutCm;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="date_fin_CM", length=10)
    public Date getDateFinCm() {
        return this.dateFinCm;
    }
    
    public void setDateFinCm(Date dateFinCm) {
        this.dateFinCm = dateFinCm;
    }

    
    @Column(name="justification", length=500)
    public String getJustification() {
        return this.justification;
    }
    
    public void setJustification(String justification) {
        this.justification = justification;
    }

    
    @Column(name="description_et_type", length=500)
    public String getDescriptionEtType() {
        return this.descriptionEtType;
    }
    
    public void setDescriptionEtType(String descriptionEtType) {
        this.descriptionEtType = descriptionEtType;
    }




}


