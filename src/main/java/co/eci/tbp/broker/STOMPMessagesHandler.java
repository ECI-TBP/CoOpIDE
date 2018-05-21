/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.eci.tbp.broker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Juan Camilo Mantilla
 */
@Controller
public class STOMPMessagesHandler {
    @Autowired
    SimpMessagingTemplate msgt;


    @MessageMapping("/{name}")
    public void handleFileEvent(String text,@DestinationVariable String name) throws Exception {
        System.out.println("Nuevo caracter recibido");
        msgt.convertAndSend("/topic/"+name, text);
    }
}
