
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {

    InetAddress enderecoServidor;
    Socket oSocket;
    int port = 9999;

    public TCPClient() {
        try {
            enderecoServidor = InetAddress.getLocalHost();
            String enderecoServidorIP = enderecoServidor.getHostName();
            oSocket = new Socket(enderecoServidorIP, port);
            ObjectInputStream ois = new ObjectInputStream(oSocket.getInputStream());
            String response = (String) ois.readUTF();


            System.out.println("Li a mensagem : " + response);
            oSocket.close();
        } catch (UnknownHostException ExecHost) {
            System.out.println("Erro");
        } catch (IOException ExceIO) {
            System.out.println("Erro");
        }
    }

    public static void main(String[] args) {
        new TCPClient();
    }
}

 