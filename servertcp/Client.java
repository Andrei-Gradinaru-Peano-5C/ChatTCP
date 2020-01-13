/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servertcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Andrei
 */
public class Client {
    private Socket s;
    private BufferedReader br;
    private PrintWriter pw;

    public Client(Socket s) throws IOException {
        this.s = s;
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        pw = new PrintWriter(s.getOutputStream());
    }
    
    /**
     * Method wich wait and return the next availeable message from this client
     * @return Message
     * @throws IOException When an error occurs
     */
    public synchronized String getMessage() throws IOException {
        return br.readLine();
    }
    
    /**
     * Method wich send a message to this client
     * @param text Message to be sent
     * @throws IOException When an error occurs
     */
    public synchronized void sendMessage(String text) throws IOException {
        pw.println(text);
        pw.flush();
    }
    
    @Override
    public String toString() {
        return s.getLocalSocketAddress().toString();
    } 

}
