/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servertcp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrei
 */
public class ClientWorker implements Runnable{
    private Client c;
    private ArrayList<Client> clients;
    
    public ClientWorker(Client c, ArrayList<Client> clients) {
        this.c = c;
        this.clients = clients;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println(c.toString() + " Aggiunto con successo");
        try {
            while(true) {
               String mess = c.getMessage();
               System.out.println(c.toString() + " -> " + mess);
               for(int i=clients.size()-1; i>=0; i--) {
                   clients.get(i).sendMessage(mess);
               }
            }
        } catch (IOException ex) {
            if (clients.remove(c)) {
                System.out.println("Rimosso con sucesso: " + c.toString());
            } else {
                System.out.println("Errore nel rimuovere: "+ c.toString());
            }
        }  
    }
    
}
