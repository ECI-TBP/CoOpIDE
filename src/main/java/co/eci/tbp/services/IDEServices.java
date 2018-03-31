/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.eci.tbp.services;

import java.util.Set;

/**
 *
 * @author Juan Camilo Mantilla
 */
public interface IDEServices {
    
    void saveFile(String file, String name);
    
    void loadFile(String name);
    
    void updateCurrent(String file);
    
    Set<String> getFiles();
    
    boolean userExists(String username);
    
    void createUser(String username) throws IDEException;
    
}
