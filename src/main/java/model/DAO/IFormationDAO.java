/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.DAO;

import java.util.List;
import model.pojo.Formation;


/**
 *
 * @author pc
 */
public interface IFormationDAO {
      public List<Formation> getFormations();
    public void supprimerFormation(Formation formation);
    public void addFormation(Formation formation);
    public void updateFormation(Formation formation);
    
}
