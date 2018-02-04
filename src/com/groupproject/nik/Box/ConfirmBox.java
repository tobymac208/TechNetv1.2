package com.groupproject.nik.Box;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {
    private static Stage window;
    private static boolean userResponse;

    /** A graphical window for confirming someone's choice -- pass in a title and a prompt for use */
    public static boolean display(String windowTitle, String prompt){
        window = new Stage();
        // Icon image
        Image image = new Image("/com/groupproject/nik/Photos/awesome_deep_space.jpg");
        window.getIcons().addAll(image);

        /* Scene */
        // Objects
        Label promptLabel = new Label(prompt);
        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");

        // events
        yesButton.setOnAction(event -> {
            userResponse = true;
            window.close();
        });
        noButton.setOnAction(event -> {
            userResponse = false;
            window.close();
        });

        // layout
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().setAll(promptLabel, yesButton, noButton);

        // Scene
        Scene mainScene = new Scene(layout, 200, 200);
        // STYLESHEET
        mainScene.getStylesheets().add("/com/groupproject/nik/main.css");

        // window options
        window.setTitle(windowTitle);
        window.setScene(mainScene);
        window.initModality(Modality.APPLICATION_MODAL);
        window.showAndWait();

        return userResponse; // return the response
    }
}