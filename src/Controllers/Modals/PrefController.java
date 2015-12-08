package Controllers.Modals;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

/**
 * Created by JesperB on 08-12-2015.
 */
public class PrefController {
    private Stage stage;

    public void closePref(ActionEvent event) {
        stage.close();
    }
    public void openPref(){
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../View/Modals/Preferences.fxml"));
            Parent root1 = null;
            root1 = (Parent) fxmlLoader.load();

            stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("ABC");
            stage.setScene(new Scene(root1));

            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
