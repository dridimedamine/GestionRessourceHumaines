/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.service;

import java.util.List;
import model.pojo.CongeMaladie;


/**
 *
 * @author pc
 */
public interface ICongeMaladieService {
    public List<CongeMaladie> getCongesMaladies();
    
    public void supprimerCongesMaladie(CongeMaladie congesMaladie);
    public void addCongesMaladie(CongeMaladie congesMaladie);
    public void updateCongesMaladies(CongeMaladie  congesMaladie); 
}
