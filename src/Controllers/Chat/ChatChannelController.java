package Controllers.Chat;

import Controllers.ControllerMediator;
import Models.Chat.Packages.MessagePackage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by JesperB on 09-12-2015.
 */
public class ChatChannelController implements Initializable{
    public TitledPane ChatChannelPane;
    public ListView UsersList;

    private String name;
    private ArrayList<String> Users = new ArrayList<>();
    public ObservableList<String> UsersObservable = FXCollections.observableArrayList();
    public ArrayList<String> Messages = new ArrayList<>();

    public ChatChannelController(){}

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void setName(String name){
        this.name = name;
        ChatChannelPane.setText(name);

    }
    public void addMessage(MessagePackage msgPackage){
        Messages.add(
                msgPackage.getAuthor()
                        .concat(": ")
                        .concat(msgPackage.getMessage())
                        .concat("\n"));
    }
    public void adduser(String User){
        Users.add(User);
        UsersList.setItems(UsersObservable);
    }
    public void removeUser(String User){
        Users.remove(User);
    }
    public ArrayList<String> getUsers(){
        return Users;
    }
}
