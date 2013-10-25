import java.net.*;

public class UDPServer {

    public static void main(String[] args) throws Exception {

        System.out.println("UDP Server");
        // cria socket na porta 28082
        DatagramSocket serverSocket = new DatagramSocket(28082);

        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];

        // numero de pacotes recebidos pelo servidor
        int count = 0;

        // true para ficar recebendo pacotes indefinidamente
        while(true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);

            // converte em string o pacote recebido
            String mensagem = new String(receivePacket.getData());

            // obtÃ©m o IP e a porta do host cliente
            InetAddress cliente_ip = receivePacket.getAddress();

            // incrementa o nÃºmero de pacotes recebidos deste cliente
            count++;

            int cliente_porta = receivePacket.getPort();

            System.out.println("------\nRecebido pacote "+count+" de "+cliente_ip.getHostAddress()+":"+cliente_porta);
            System.out.println("Mensagem:\n"+mensagem+"\n------");

            String resposta = "Recebido pacote numero "+count+" com "+receivePacket.getLength()+" bytes";

            sendData = resposta.getBytes();

            // forma o pacote para resposta
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, cliente_ip, cliente_porta);

            // envia o pacote para o cliente
            serverSocket.send(sendPacket);
        }
    }
}