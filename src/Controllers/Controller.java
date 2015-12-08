package Controllers;

import Controllers.Modals.PrefController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Controller {

    public Accordion chatList;

    public Controller(){

    }

    //region actions that buttons are mapped to

    //region channels actions

    public void addChannel(){
        try {
            TitledPane channel = FXMLLoader.load(getClass().getResource("../View/CustomControls/ChatPanel.fxml"));

            chatList.getPanes().add(channel);

            System.out.println("Channel Added!");

        } catch (IOException e) {
            System.out.println("Channel was not added :(");
            e.printStackTrace();
        }
    }

    public void closeChannel() {
        System.out.println("Channel Closed!");
    }

    //endregion


    public void openPreferences(ActionEvent event) {

        PrefController prefCtrl = new PrefController();
        prefCtrl.openPref();

        System.out.println("Preference Modal Opened! :D...wait no");

    }

    public void closeServer() {
        System.out.println("graceful exit activated");
        System.exit(0);
    }

    //endregion
}
