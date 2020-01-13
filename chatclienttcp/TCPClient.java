/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatclienttcp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author pc15
 */
public class TCPClient {
    
    private Client client;
    
    public TCPClient(Client client) throws SocketException{
        this.client = client;
    }
    
    public void send(String text) {
        this.client.mandaMessaggio(text);
    }
    
    /*public String receive() throws IOException {
        return this.client.ottieniMessaggio();
    }*/
}