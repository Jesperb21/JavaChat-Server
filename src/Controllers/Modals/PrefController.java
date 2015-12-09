package Controllers.Modals;

import Controllers.ControllerMediator;
import Services.ServerSocketService;
import Services.XML.XMLHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by JesperB on 08-12-2015.
 */
public class PrefController implements Initializable{

    public TextField txtPort;

    public int Port = 0;


    public PrefController() {
        ControllerMediator.getInstance().prefController = this;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getPortFromXml();
        txtPort.setText(String.valueOf(Port));
    }


    //todo move this to a menubar controller
    /**
     * open a preferences modal
     */
    public void openPref() {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../View/Modals/Preferences.fxml"));
            Parent root1 = null;
            root1 = (Parent) fxmlLoader.load();

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UTILITY);
            stage.setTitle("Preferences");
            stage.setScene(new Scene(root1));

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getPortFromXml(){
        XMLHandler xmlHandler = new XMLHandler();
        Port = xmlHandler.readPortFromXML();
    }

    public void StartServer() {
        // get port from txtfield
        Port = Integer.parseInt(txtPort.getText());

        //save port to xml
        XMLHandler xmlHandler = new XMLHandler();
        xmlHandler.WritePortToXML(Port);

        try {
            ServerSocketService s = new ServerSocketService(Port);
            s.StartListening();

            System.out.println("Server started on port: " + Port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}