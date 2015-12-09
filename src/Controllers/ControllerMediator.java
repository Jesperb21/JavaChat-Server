package Controllers;

import Controllers.CustomControls.ChatPanelController;
import Controllers.Modals.PrefController;

import java.util.List;

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

}
