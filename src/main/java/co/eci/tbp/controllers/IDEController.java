/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.eci.tbp.controllers;

import co.eci.tbp.services.IDEException;
import co.eci.tbp.services.IDEServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Juan Camilo Mantilla
 */
@Service
@RestController
@RequestMapping(value = "/file")
public class IDEController {
    
    @Autowired
    private IDEServices ideServ;
    
    @RequestMapping(method = RequestMethod.GET)
    //Cambiar si es necesario, el cambio se haraí direcamente desde el stub con esta implementacion
    public ResponseEntity<?> managerFiles(){
        String text = ideServ.getFile("file");
        return new ResponseEntity<>(text,HttpStatus.ACCEPTED);
        /**try{
            if(ideServ.getFiles().contains(filename)){
                ideServ.loadFile(filename);
            }
            else{
                throw new IDEException("File does not exist");
            }
        }
        catch(IDEException e){
            
        }**/
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> updateText(@PathVariable String text) {
        
        ideServ.saveFile("file", text);
        return new ResponseEntity<>(text,HttpStatus.ACCEPTED);
        }

}

