/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.service;

import java.util.List;
import model.pojo.CongeNormal;

/**
 *
 * @author pc
 */
public interface ICongeNormalService {
    public void addCongesNormal(CongeNormal congesNormal);
         public List<CongeNormal> getCongesNormals();
    public void supprimerCongesNormal(CongeNormal congesNormal);
    public void updatecongesnormal(CongeNormal congesNormal);

    
}
