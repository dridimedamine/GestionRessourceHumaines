/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.service;

import java.util.List;

import model.pojo.Formateur;

/**
 *
 * @author pc
 */
public interface IFormateurService {
       
   public List<Formateur> getFormateurs();
    public void supprimerFormateur(Formateur Formateur);
    public void addFormateur(Formateur Formateur);
    public void updateFormateur(Formateur Formateur);
    
     
}
