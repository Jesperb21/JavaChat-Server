package Services;

import Models.Chat.Packages.IPackageBase;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.file.SecureDirectoryStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JesperB on 09-12-2015.
 */
public class ClientSocketService extends BaseSocketService{
    private Socket socket;
    public ClientSocketService(Socket socket) {
        this.socket = socket;
    }
    public void SendMsg(String Author, String Msg){
        try {
            SendMsg(Author, Msg, new DataOutputStream(socket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
