package Controllers;

import Controllers.Chat.ChatChannelController;
import Controllers.Chat.ChatPanelController;
import Controllers.Modals.PrefController;

import java.util.ArrayList;

/**
 * Created by JesperB on 09-12-2015.
 * A singleton that handles communication between controllers
 */
public class ControllerMediator {
    //region Singleton
    private static ControllerMediator instance = new ControllerMediator();

    public static ControllerMediator getInstance() {
        return instance;
    }
    //endregion

    public Controller mainController;
    public ChatPanelController chatPanelController;
    public PrefController prefController;
    public ArrayList<ChatChannelController> chatChannelControllers = new ArrayList<>();
}
