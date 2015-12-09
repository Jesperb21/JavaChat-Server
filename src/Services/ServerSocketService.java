package Services;

import javax.activation.FileDataSource;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

import Models.Chat.Packages.IPackageBase;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


/**
 * Created by jan on 09-12-2015.
 */
public class ServerSocketService extends BaseSocketService {
    private ServerSocket serverSocket;
    private ArrayList<Socket> connections = new ArrayList<>();

    public ServerSocketService(String Port) throws IOException {
        serverSocket = new ServerSocket(Integer.parseInt(Port));
        serverSocket.setSoTimeout(0);

    }

    public void run () {
        while (true) try {
            System.out.println("Waiting for client...");
            Socket conn = serverSocket.accept();
            System.out.println("Client has connected: " + conn.getRemoteSocketAddress());
            connections.add(conn);

        } catch (SocketTimeoutException s) {
            System.out.println("Socket timed out..");
            break;
        } catch (IOException e) {
            e.printStackTrace();
            break;
        }
    }
    private void handleStream(FileDataSource server) throws IOException {
        JSONParser parser = new JSONParser();

        DataInputStream in = new DataInputStream(server.getInputStream());
//        System.out.println(in.readUTF());
        try {
            IPackageBase pckg =  (IPackageBase) parser.parse(in.readUTF());
            //todo add client package service that handles all the basic client functionality
            /*switch (pckg.getPackageType()){
                case LoginPackage:
                    break;
                case LogoutPackage:
                    break;
                case MessagePackage:
                    break;
                case RequestUserList:
                    break;
            }*/
            repeatPackage(pckg);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    //todo do package transfer for server socket
    //region package transfer

    public void SendMsg(String Msg){

    }

    public void StopServer(){

    }

    private void repeatPackage(IPackageBase pckg) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        String parsedPckg = (String) parser.parse(pckg.toString());
        for (Socket s : connections) {
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            out.writeUTF(parsedPckg);
            out.flush();
        }
        System.out.println(parsedPckg.concat(" was sent to all client"));
    }

    //endregion
}
