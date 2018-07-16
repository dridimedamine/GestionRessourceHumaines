/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import model.pojo.CongeNormal;
import model.pojo.Personnel;
import model.service.ICongeNormalService;
import model.service.IPersonnelService;


/**
 *
 * @author pc
 */

@ManagedBean(name = "congesNormalMB")
@SessionScoped
public class CongesNormalBean {
    
       @ManagedProperty(value="#{CongeNormalService}")
       ICongeNormalService congesNormalService;
       
       @ManagedProperty(value="#{PersonnelService}")
       IPersonnelService personnelService;
       
  private List<CongeNormal> listcongesNormal;
    private Date dateDebut;
     private Date dateFin;
     private List<SelectItem> mesConge;
     private int selectedCN;
       
private int idCongeNormal;
private CongeNormal selectedcongesnormal;

    public IPersonnelService getPersonnelService() {
        return personnelService;
    }

    public void setPersonnelService(IPersonnelService personnelService) {
        this.personnelService = personnelService;
    }

    public List<SelectItem> getMesConge() {
        if (mesConge == null) {
            mesConge = new ArrayList<SelectItem>();
            for (CongeNormal obj : getListcongesNormal()) {
                 mesConge.add(new SelectItem(obj.getPersonnel().getIdPersonnel(),obj.getPersonnel().getNomPrenomPersonnel()));

            }
    }
                return mesConge;

    }
    public void setMesConge(List<SelectItem> mesConge) {
        this.mesConge = mesConge;
    }

    public int getSelectedCN() {
        return selectedCN;
    }

    public void setSelectedCN(int selectedCN) {
        this.selectedCN = selectedCN;
    }


    public CongeNormal getSelectedcongesnormal() {
        if(selectedcongesnormal ==null)
        {
            return new CongeNormal();
        }
        else{
        return selectedcongesnormal;
    }}

    public ICongeNormalService getCongesNormalService() {
        return congesNormalService;
    }

    public void setCongesNormalService(ICongeNormalService congesNormalService) {
        this.congesNormalService = congesNormalService;
    }

   

    

    public int getIdCongeNormal() {
        return idCongeNormal;
    }

    public void setIdCongeNormal(int idCongeNormal) {
        this.idCongeNormal = idCongeNormal;
    }

   

    public List<CongeNormal> getListcongesNormal() {
         listcongesNormal = new ArrayList<CongeNormal>();
        listcongesNormal.addAll(getCongesNormalService().getCongesNormals());
        
        return listcongesNormal;
    }

    public void setListcongesNormal(List<CongeNormal> listcongesNormal) {
        this.listcongesNormal = listcongesNormal;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
    public void reset()
    {
        setDateDebut(null);
        setDateFin(null);
        
    }
    public void addCongesNormal()

    {
      CongeNormal cn = new CongeNormal();
        Personnel pers = new Personnel();
       pers = getPersonnelService().getPersonnelById(selectedCN);
      cn.setDateDebutCn(getDateDebut());
      cn.setDateFinCn(getDateFin());
      cn.setPersonnel(pers);
       
       getCongesNormalService().addCongesNormal(cn);
        reset(); 
               
    }
    public void supprimerCongesNormal(CongeNormal congesNormal)
    {
        getCongesNormalService().supprimerCongesNormal(congesNormal);
      //  congesNormalService.supprimerCongesNormal(congesNormal);
    }
    public void updatecongesnormal(CongeNormal congesNormal)
    {
        getCongesNormalService().updatecongesnormal(congesNormal);    }
}
