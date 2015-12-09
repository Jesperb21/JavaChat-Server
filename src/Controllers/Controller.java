package Controllers;

import Controllers.Chat.ChatChannelController;
import Controllers.Modals.PrefController;
import Models.Chat.Packages.MessagePackage;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Date;
import java.time.Instant;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    public TextArea ChatTextArea;
    public TextField ChatMessageArea;
    public Button ChatSendButton;

    ControllerMediator mediator = ControllerMediator.getInstance();

    public Controller(){
        mediator.mainController = this;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ChatSendButton.setOnAction(event -> {
            //todo send message via client service...
            // maybe, or just bypass that step on server and send directly on server socket
            // haven't quite figured out how this'll work yet

            //this is redundant... when the server receives the msgPackage it will be sent to all clients
            //including this one, if we add the msg when we receive the msgPackage again we can confirm that
            //it was actually sent to the server
            addMessage(new MessagePackage("Server", Date.from(Instant.now()), ChatMessageArea.getText()));
            ChatMessageArea.clear();
        });
    }

    public void addMessage(MessagePackage msgPackage){
        ChatTextArea.appendText(
                msgPackage.getAuthor()
                        .concat(": ")
                        .concat(msgPackage.getMessage())
                        .concat("\n"));
    }

    //region menu actions

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

        System.out.println("Preference Modal Opened! :D...wait no");

    }

    public void closeServer() {
        System.out.println("graceful exit activated");
        System.exit(0);
    }


    //endregion
}
