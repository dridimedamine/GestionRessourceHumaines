/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.bean;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import model.pojo.HeureSupplementaire;

import model.pojo.Personnel;
import model.service.IHeureSupplementaireService;


/**
 *
 * @author pc
 */

@ManagedBean(name = "HeureSupplementaireMB")
@SessionScoped
public class HeureSupplementaireBean {
    @ManagedProperty(value="#{HeureSupplementaireService}")
    IHeureSupplementaireService heureSupplementaireService;
  private List<HeureSupplementaire> listheuresupplementaire;

     private int idHrSupp;
     private Personnel personnel;
     private Integer nombreHeureSupp;
     private HeureSupplementaire selectedhersup;

    public IHeureSupplementaireService getHeureSupplementaireService() {
        return heureSupplementaireService;
    }

    public void setHeureSupplementaireService(IHeureSupplementaireService heureSupplementaireService) {
        this.heureSupplementaireService = heureSupplementaireService;
    }

    public int getIdHrSupp() {
        return idHrSupp;
    }

    public void setIdHrSupp(int idHrSupp) {
        this.idHrSupp = idHrSupp;
    }

    public Integer getNombreHeureSupp() {
        return nombreHeureSupp;
    }

    public void setNombreHeureSupp(Integer nombreHeureSupp) {
        this.nombreHeureSupp = nombreHeureSupp;
    }

    public HeureSupplementaire getSelectedhersup() {
        if(selectedhersup ==null)
        {
            return new HeureSupplementaire();
        }
        else{
        return selectedhersup;
    }}

    public void setSelectedhersup(HeureSupplementaire selectedhersup) {
        this.selectedhersup = selectedhersup;
    }
    public Personnel getPersonnel() {
        return personnel;
    }

    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }

    public List<HeureSupplementaire> getListheuresupplementaire() {
          
        listheuresupplementaire = new ArrayList<HeureSupplementaire>();
        listheuresupplementaire.addAll(getHeureSupplementaireService().getHeureSupplementaire());
        return listheuresupplementaire;
    }

    public void setListheuresupplementaire(List<HeureSupplementaire> listheuresupplementaire) {
        this.listheuresupplementaire = listheuresupplementaire;
    }

    public void reset()
    {
     this.setNombreHeureSupp(null);
    }
    public void addHeureSupplimentaire()
    {
        HeureSupplementaire hr = new HeureSupplementaire();
        hr.setNombreHeureSupp(getNombreHeureSupp());        
        

        getHeureSupplementaireService().addHeureSupplementaire(hr);
        reset();
    }
public void supprimerHeauresupplementaire( HeureSupplementaire heureSupplementaire)
{
    getHeureSupplementaireService().supprimerHeureSupplementaire(heureSupplementaire);
}
public void updateHeureSupplementaire(HeureSupplementaire heureSupplementaire)
{
    getHeureSupplementaireService().updateHeureSupplementaire(heureSupplementaire);
}
}
