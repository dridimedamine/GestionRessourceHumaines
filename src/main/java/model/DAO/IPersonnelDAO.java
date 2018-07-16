/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.DAO;

import java.util.List;
import model.pojo.Personnel;

/**
 *
 * @author pc
 */
public interface IPersonnelDAO {
     public List<Personnel> getPersonnel();
    public void supprimerPersonnel(Personnel personnel);
    public void addPersonnel(Personnel personnel);
    public void updatePersonnel(Personnel personnel);
      public List<Personnel> valide(String nom,String cin);
      public Personnel getPersonnelById(int id);
    
}
