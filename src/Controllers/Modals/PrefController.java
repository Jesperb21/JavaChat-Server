package Controllers.Modals;

import Controllers.ControllerMediator;
import Controllers.ServerSocketController;
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
            stage.setTitle("ABC");
            stage.setScene(new Scene(root1));

            stage.show();

            Properties prop = new Properties();

            if (prop.getProperty("Port") != null) {
                txtPort.setText(prop.getProperty("Port"));
            } else {
                //txtPort.setText("4545");
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void StartServer(ActionEvent actionEvent) {
        txtPort.setText("4545");

        Properties prop = new Properties();
        prop.setProperty("Port", String.valueOf(txtPort.getText()));
        System.out.println(prop.getProperty("Port"));

        try {
            Thread t = new ServerSocketController(prop.getProperty("Port"));
            t.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}