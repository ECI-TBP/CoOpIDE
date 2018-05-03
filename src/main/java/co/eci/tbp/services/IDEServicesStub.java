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
    //private ArrayList<String> userList;
    
    
    @Override
    public void saveFile(String name, String file) {
        filesMap.put(name, file);
    }

    @Override
    public String loadFile(String name) {
        return filesMap.get(name);
    }


    
}
