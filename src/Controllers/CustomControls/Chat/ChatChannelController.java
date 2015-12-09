package Controllers.CustomControls.Chat;

import Controllers.Controller;
import Controllers.ControllerMediator;

/**
 * Created by JesperB on 09-12-2015.
 */
public class ChatChannelController {
    public ChatChannelController() {
        ControllerMediator.getInstance().chatChannelControllers.add(this);
    }
}
