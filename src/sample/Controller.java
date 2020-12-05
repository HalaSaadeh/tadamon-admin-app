package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Controller {

    public Button uploadEventPhoto, uploadRepPhoto, addEventButton;

    @FXML
    public void initialize() {


    }

    public void onClickUploadRepPhoto(MouseEvent mouseEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
    }
}
