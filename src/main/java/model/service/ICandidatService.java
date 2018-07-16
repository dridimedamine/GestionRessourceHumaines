/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.service;

import java.util.List;
import model.pojo.Candidat;

/**
 *
 * @author pc
 */
public interface ICandidatService {
      public List<Candidat> getCondidat();
    public void supprimerCondidat(Candidat condidat);
    public void addCondidat(Candidat condidat);
  public void updateCondidat(Candidat condidat); 
}
