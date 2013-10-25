import java.io.IOException;
import java.net.ServerSocket;

public class TCPServer {
	int portNumber = 9999;
	ServerSocket oSocket;

	public TCPServer() {
		try {
			oSocket = new ServerSocket(portNumber);
			System.out.println("Servidor criado!");
			Connection conn=new Connection(oSocket);
			conn.run();
		} catch (IOException ExecIO)
		{
			System.out.println("Erro");
		}
	}


	public static void main(String[] args) {
		TCPServer servidor = new TCPServer();
	}
}


