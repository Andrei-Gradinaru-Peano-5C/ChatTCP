/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatclienttcp;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrei
 */
public class Listener implements Runnable{
    
    private Gui gui;
    private Client client;

    public Listener(Gui gui, Client client) {
        this.gui = gui;
        this.client = client;
        new Thread(this).start();
    }

    @Override
    public void run() {
        
        while(true) {
            try {
                if(client.verificaMessaggio()) {
                    gui.addMessage(client.ottieniMessaggio());
                }
            } catch (IOException ex) {
                Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
