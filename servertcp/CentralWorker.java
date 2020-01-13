/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servertcp;

import java.util.ArrayList;

/**
 *
 * @author Andrei
 */
public class CentralWorker {
    private ArrayList<Client> clients;

    public CentralWorker() {
        this.clients = new ArrayList<Client>();
    }
    
    /**
     * Add a new Client to be worker
     * @param c The Client
     */
    public void addClient(Client c) {
        clients.add(c);
        startNewWorker();
    }
    
    /**
     * Remove a client 
     * @param index Index of client onto the list
     */
    public void removeClient(int index) {
        clients.remove(index);
    }
    
    private void startNewWorker() {
        new ClientWorker(clients.get(clients.size()-1), clients);
    }
    
}
