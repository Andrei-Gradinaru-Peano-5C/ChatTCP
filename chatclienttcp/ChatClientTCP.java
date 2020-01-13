/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatclienttcp;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrei
 */
public class ChatClientTCP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            Socket s = new Socket(InetAddress.getByName("localhost"),4444);
            Client c = new Client(s);
            TCPClient TCPc= new TCPClient(c);
            
            String username = JOptionPane.showInputDialog("Inserire Username");
            if(username == null) {
                System.exit(0);
            }
            while(username.length()<4) {
                username = JOptionPane.showInputDialog("L'Username deve contenere almeno 4 lettere");
                if(username == null) {
                    System.exit(0);
                }
            }
            
            Gui g = new Gui(TCPc, username);
            Listener l = new Listener(g,c);
            
        } catch (IOException ex) {
            Logger.getLogger(ChatClientTCP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
