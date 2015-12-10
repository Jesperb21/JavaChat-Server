package Controllers;

import Controllers.Chat.ChatChannelController;
import Controllers.Modals.PrefController;
import javafx.event.ActionEvent;
import java.util.Random;

public class Controller{

    ControllerMediator mediator = ControllerMediator.getInstance();

    public Controller(){
        mediator.mainController = this;
    }


    //region menu actions

    //region channels actions

    public void addChannel(){
        String roomName = "Default".concat(Integer.toString(mediator.channels.size()));
        mediator.chatPanelController.addChannel(roomName);
    }

    //todo change it so that each channel has a close button in the ChatPanel, then call closeChannel from there
    public void closeChannel() {
        String name = mediator.chatPanelController.getSelectedChannel();
        ChatChannelController channel = mediator.channels.get(name);
        mediator.chatPanelController.closeChannel(name);
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
