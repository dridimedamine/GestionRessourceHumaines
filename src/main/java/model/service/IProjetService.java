/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.service;

import java.util.List;
import model.pojo.Projet;

/**
 *
 * @author pc
 */
public interface IProjetService {
     public List<Projet> getProjet();
    public void supprimerProjet(Projet projet);
    public void addProjet(Projet projet);
    public void updateProjet(Projet projet);
    
}
