package Services;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * Created by jan on 09-12-2015.
 */
public class ServerSocketService extends Thread {
    private ServerSocket serverSocket;

    public ServerSocketService(int Port) throws IOException {
        serverSocket = new ServerSocket(Port);
        serverSocket.setSoTimeout(0);

    }

    public void run () {
        while (true) try {
            System.out.println("Waiting for client...");
            Socket server = serverSocket.accept();
            System.out.println("Client has connected: " + server.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(server.getInputStream());
            System.out.println(in.readUTF());

            DataOutputStream out = new DataOutputStream(server.getOutputStream());
            out.writeChars("Welcome to ....");
            server.close();

        } catch (SocketTimeoutException s) {
            System.out.println("Socket timed out..");
            break;
        } catch (IOException e) {
            e.printStackTrace();
            break;
        }
    }
}
