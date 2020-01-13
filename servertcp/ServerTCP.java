/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servertcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrei
 */
public class ServerTCP {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            ServerSocket ss = new ServerSocket(4444);
            CentralWorker cw = new CentralWorker();
            
            while(true) {
                Socket s = ss.accept();
                cw.addClient(new Client(s));
            }
            
        } catch (IOException ex) {
            Logger.getLogger(ServerTCP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
