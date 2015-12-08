package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;

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

    public void openPreferences() {
        System.out.println("Preference Modal Opened! :D...wait no");
    }

    public void closeServer() {
        System.out.println("graceful exit activated");
        System.exit(0);
    }

    //endregion
}
