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
    
    public IDEServicesStub(){
        filesMap = new HashMap<String,String>();
    }
    
    
    @Override
    public void saveFile(String name, String file) {
        if(file.endsWith("=")){
            file = file.substring(0, file.length() - 1);
        }
        file = file.replace("%0A", "\n");;
        file = file.replace("+", " ");
        file = file.replace("%3B", ";");
        file = file.replace("%3A", ":");
        file = file.replace("%2C", ",");
        file = file.replace("%28", "(");
        file = file.replace("%29", ")");
        file = file.replace("%7B", "{");
        file = file.replace("%7D", "}");
        file = file.replace("%3D", "=");
        file = file.replace("%3F", "?");
        file = file.replace("%2F", "/");
        file = file.replace("%22", "\"");
        file = file.replace("%27", "'");
        filesMap.put(name, file);
    }

    @Override
    public String loadFile(String name) {
        return filesMap.get(name);
    }


    
}
