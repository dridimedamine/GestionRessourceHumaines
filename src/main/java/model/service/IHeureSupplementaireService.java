/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.service;

import java.util.List;
import model.pojo.HeureSupplementaire;


/**
 *
 * @author pc
 */
public interface IHeureSupplementaireService {
     
    public List<HeureSupplementaire> getHeureSupplementaire();
    public void supprimerHeureSupplementaire(HeureSupplementaire heureSupplementaire);
    public void addHeureSupplementaire(HeureSupplementaire heureSupplementaire);
    public void updateHeureSupplementaire(HeureSupplementaire heureSupplementaire);
    
    
}
