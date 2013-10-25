import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Connection extends Thread {
	private ServerSocket oSocket;
	public Connection(ServerSocket oSocket){
		this.oSocket = oSocket;

	}
	public void run(){
		try {
			Socket sock = oSocket.accept();
			System.out.println("Enviando mensagem!");
			ObjectOutputStream oos = new ObjectOutputStream(sock.getOutputStream());

			oos.writeUTF("Mensagem do servidor");
			oos.close();
			sock.close();

		} catch  (IOException ExecIO)
		{
			System.out.println("Erro");
		}
	}
}
