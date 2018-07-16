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
 * CongeNormal generated by hbm2java
 */
@Entity
@Table(name="conge_normal"
    ,schema="dbo"
    ,catalog="Application_GRH"
)
public class CongeNormal implements java.io.Serializable {


     private int idCongeNormal;
     private Personnel personnel;
     private Date dateDebutCn;
     private Date dateFinCn;
               
    public CongeNormal() {
    }

   

   
   
	
    public CongeNormal(int idCongeNormal) {
        this.idCongeNormal = idCongeNormal;
    }
    public CongeNormal(int idCongeNormal, Personnel personnel, Date dateDebutCn, Date dateFinCn) {
       this.idCongeNormal = idCongeNormal;
       this.personnel = personnel;
       this.dateDebutCn = dateDebutCn;
       this.dateFinCn = dateFinCn;
    }
   
     @Id 
     @GeneratedValue(strategy = GenerationType.AUTO)


    
    @Column(name="id_conge_normal", unique=true, nullable=false)
    public int getIdCongeNormal() {
        return this.idCongeNormal;
    }
    
    public void setIdCongeNormal(int idCongeNormal) {
        this.idCongeNormal = idCongeNormal;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="id_personnel")
    public Personnel getPersonnel() {
        return this.personnel;
    }
    
    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="date_debut_CN", length=10)
    public Date getDateDebutCn() {
        return this.dateDebutCn;
    }
    
    public void setDateDebutCn(Date dateDebutCn) {
        this.dateDebutCn = dateDebutCn;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="date_fin_CN", length=10)
    public Date getDateFinCn() {
        return this.dateFinCn;
    }
    
    public void setDateFinCn(Date dateFinCn) {
        this.dateFinCn = dateFinCn;
    }




}

