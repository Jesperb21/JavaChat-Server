package Controllers.Modals;

import Controllers.ControllerMediator;
import Services.ReadXMLFile;
import Services.ServerSocketService;
import Services.XMLStorage;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by JesperB on 08-12-2015.
 */
public class PrefController {

    public TextField txtPort;
    public int Port = 0;

    public PrefController() {
        ControllerMediator.getInstance().prefController = this;
    }

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

            ReadXMLFile ReadXML = new ReadXMLFile();
            Port = Integer.parseInt(ReadXML.ReadXMLFile());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void StartServer(ActionEvent actionEvent) {

        txtPort.setText(Integer.toString(Port));

        if (Port == 0) {
            XMLStorage xml = new XMLStorage();
            xml.XMLStorage(txtPort.getText());
        }

        try {
            Thread t = new ServerSocketService(Port);
            t.start();

            System.out.println("Server started on port: " + Port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}