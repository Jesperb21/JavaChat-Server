package Controllers.CustomControls;

import Controllers.Controller;
import Controllers.ControllerMediator;
import javafx.beans.binding.StringBinding;
import javafx.fxml.FXML;

/**
 * Created by JesperB on 09-12-2015.
 */
public class ChatPanelController {
    public ChatPanelController() {
        ControllerMediator.getInstance().chatPanelController = this;
    }

    public String getName(){
        return "derp";
    }
}
