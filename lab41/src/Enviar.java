/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aluno
 */
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Enviar {
    private static int DGRAM_LENGTH;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DatagramSocket socket = null;
        
        try {
            socket = new DatagramSocket();
        } catch (SocketException ex) {
            Logger.getLogger(Enviar.class.getName()).log(Level.SEVERE, null, ex);
        }
        byte[] b = new byte[DGRAM_LENGTH];
        DatagramPacket dgram;
        dgram = new DatagramPacket(b, b.length,
                InetAddress.getByName(MCAST_ADDR), DEST_PORT);
        System.err.println("Sending " + b.length + " bytes to "
                + dgram.getAddress() + ':' + dgram.getPort());
        while (true) {
            System.err.print(".");
            try {
                socket.send(dgram);
            } catch (IOException ex) {
                Logger.getLogger(Enviar.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Enviar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
