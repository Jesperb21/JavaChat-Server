package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
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
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../View/Preferences.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("ABC");
            stage.setScene(new Scene(root1));
            stage.show();
/*

            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../View/Preferences.fxml"));

            stage.setScene(new Scene(root));
            stage.setTitle("Preferences");
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)event.getSource()).getScene().getWindow() );

            stage.show();*/

        System.out.println("Preference Modal Opened! :D...wait no");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeServer() {
        System.out.println("graceful exit activated");
        System.exit(0);
    }

    //endregion
}
