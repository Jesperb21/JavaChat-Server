package Services;

import Models.Chat.Packages.IPackageBase;
import Models.Chat.Packages.MessagePackage;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.DataOutputStream;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;

/**
 * Created by JesperB on 09-12-2015.
 */
public abstract class BaseSocketService {

    public void SendMsg(String Author, String Msg, DataOutputStream out){
        MessagePackage msgPckg = new MessagePackage(Author, Date.from(Instant.now()), Msg);
        transferPackage(msgPckg, out);
    }


    protected void transferPackage(IPackageBase pckg, DataOutputStream out){
        try {
            JSONParser parser = new JSONParser();
            String parsedPckg = null;
            parsedPckg = (String) parser.parse(pckg.toString());

            out.writeUTF(parsedPckg);
            out.flush();

        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }

}
