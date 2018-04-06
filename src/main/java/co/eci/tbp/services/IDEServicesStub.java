/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.eci.tbp.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan Camilo Mantilla
 */
@Service
public class IDEServicesStub implements IDEServices{

    private HashMap<String,String> filesMap;
    private ArrayList<String> userList;
    
    private String currentFile = null;
    
    @Override
    public void saveFile(String file, String name) {
        filesMap.put(name, file);
    }

    @Override
    public void loadFile(String name) {
        currentFile = filesMap.get(name);
    }

    @Override
    public void updateCurrent(String file){
        currentFile = file;
    }

    @Override
    public Set<String> getFiles() {
        return filesMap.keySet();
    }

    @Override
    public boolean userExists(String username) {
        boolean ans = true;
        for(int i=0; i< userList.size() && ans; i++){
            if (userList.get(i).equals(username) ){
                ans = false;
            }
        }
        return !ans;
    }

    @Override
    public void createUser(String username) throws IDEException{
        if(userExists(username)){
            throw new IDEException("Username already taken");
        }
        else{
            userList.add(username);
        }
    }

    @Override
    public String getFile(String filename) {
        return filesMap.get(filename);
    }

    
}
