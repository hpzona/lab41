import java.io.*;
import java.net.*;

public class UDPClient {

    public static void main(String[] args) throws Exception {

        System.out.println("UDP Client");

        // cria um buffer para a mensagem que serÃ¡ enviada
        BufferedReader mensagem = new BufferedReader(new InputStreamReader(System.in));

        // cria o socket para enviar o pacote
        DatagramSocket clientSocket = new DatagramSocket();

        // pega o IP do servidor
        InetAddress IPAddress = InetAddress.getByName("localhost");

        // variaveis para armazenar as mensagens de envio e resposta
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];

        // recupera mensagem digitada pelo cliente
        String msg = mensagem.readLine();
        sendData = msg.getBytes();

        // monta o datagrama para enviar ao servidor
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 28082);

        // envia o pacote udp
        clientSocket.send(sendPacket);

        // recebe a resposta
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);

        String resposta = new String(receivePacket.getData());

        System.out.println("Resposta do servidor:\n"+resposta);

        clientSocket.close();
    }
}