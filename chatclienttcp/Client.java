/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatclienttcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author gradinaru.andreivale
 */
public class Client {
    private Socket socket;
    private BufferedReader br;
    private PrintWriter pw; 
    
    public Client(Socket socket) throws IOException {
        this.socket = socket;
        this.br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.pw = new PrintWriter(socket.getOutputStream());
    }

    public Socket getSocket() {
        return socket;
    }
    
    public boolean verificaMessaggio() throws IOException {
        return br.ready();
    }
    
    public String ottieniMessaggio() throws IOException{
        String text = br.readLine();
        while(br.ready()){
            text = text + br.readLine();
        }
        return text;
    }
    
    public void mandaMessaggio(String mess) {
        pw.println(mess);
        pw.flush();
    }
    
}