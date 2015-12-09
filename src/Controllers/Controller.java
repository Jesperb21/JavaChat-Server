package Controllers;

import Controllers.CustomControls.Chat.ChatChannelController;
import Controllers.Modals.PrefController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;

import java.io.IOException;

public class Controller {
    ControllerMediator mediator = ControllerMediator.getInstance();

    public Controller(){
        mediator.mainController = this;
    }

    //region actions that buttons are mapped to

    //region channels actions

    public void addChannel(){
        mediator.chatPanelController.addChannel();
    }

    //todo change it so that each channel has a close button in the ChatPanel, then call closeChannel from there
    public void closeChannel() {
        ChatChannelController channel = mediator.chatChannelControllers.get(0);
        mediator.chatPanelController.closeChannel(channel);
    }

    //endregion


    public void openPreferences(ActionEvent event) {

        PrefController prefCtrl = new PrefController();
        prefCtrl.openPref();
        System.out.println("Preference Modal Opened");
    }

    public void closeServer() {
        System.out.println("graceful exit activated");
        System.exit(0);
    }

    //endregion
}
