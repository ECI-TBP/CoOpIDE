/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.eci.tbp.controllers;

import co.eci.tbp.services.IDEException;
import co.eci.tbp.services.IDEServices;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Juan Camilo Mantilla
 */
@RestController
@RequestMapping(value = "/file")
public class IDEController {
    
    @Autowired
    private IDEServices ideServ;
    
    @RequestMapping(path = "/{filename}",method = RequestMethod.GET)
    public ResponseEntity<?> getFileContent(@PathVariable(name = "filename") String filename) {
        
        return new ResponseEntity<>(ideServ.loadFile(filename),HttpStatus.ACCEPTED);
        
    }
    
    @RequestMapping(path = "/{filename}",method = RequestMethod.POST)
    public ResponseEntity<?> saveFileContent(@PathVariable(name = "filename") String filename,@RequestBody String content) {
        ideServ.saveFile(filename, content);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }

}

