package app;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.sql.SQLOutput;

public class Main extends Application {

    public final int WIDTH = 1920;
    public final int HEIGHT = 1080;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();

        root.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        root.setMaxWidth(WIDTH);
        root.setMaxHeight(HEIGHT);
        root.setAlignment(Pos.CENTER);

        Label lUser, lPass;
        lUser = new Label("Username");
        lPass = new Label("Password");
        styleLabel(lUser, lPass);


        TextField user;
        PasswordField pass;
        user = new TextField();
        pass = new PasswordField();

        user.setMaxWidth(200);
        pass.setMaxWidth(200);

        root.setVgap(20);
        root.setHgap(20);

        root.add(lUser, 0, 0);
        root.add(lPass, 0, 1);
        root.add(user, 1, 0);
        root.add(pass, 1, 1);

        Scene scene = new Scene(root, WIDTH, HEIGHT);
        primaryStage.setMaximized(true);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Artist Circle Admin App");
        primaryStage.show();
    }

    private void styleLabel(Label... labels) {
        for (Label label : labels)
            label.setFont(Font.font("Poppins", 20));
    }
}
