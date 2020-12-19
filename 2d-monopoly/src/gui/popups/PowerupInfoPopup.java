package gui.popups;

import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PowerupInfoPopup {

    public void display(Stage context){
        Stage window = new Stage();
        window.initStyle(StageStyle.UNDECORATED);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setResizable(false);
        window.setTitle("Use Pop-up");
        window.setMinWidth(300);
        window.setMinHeight(125);

        Label label = new Label("Do you wamt to us");

    }
}
