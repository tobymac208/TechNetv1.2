package com.groupproject.nik.Box;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DisplayViewBox {
    private static Stage window;
    private static ListView<String> listView;

    /** Displays a window with a list view, that allows someone to read certain information of the about page -- on clicking */
    public static void display(String windowTitle, String firstLabel, String firstInfo, String secondLabel, String secondInfo, String thirdLabel, String thirdInfo){
        /* Scene */
        // Objects
        window = new Stage();
        // Icon image
        Image image = new Image("/com/groupproject/nik/Photos/awesome_deep_space.jpg");
        window.getIcons().addAll(image);
        listView = new ListView<>();
        listView.getItems().addAll(firstLabel, secondLabel, thirdLabel);
        TextArea infoArea = new TextArea("");
        infoArea.setEditable(false); // cannot change the value

        listView.getSelectionModel().selectedItemProperty().addListener((model, oldVal, newVal) -> {
            if(newVal.equals(firstLabel)){ // if they clicked the first one
                infoArea.setText(firstInfo);
            }
            else if(newVal.equals(secondLabel)){ // if they clicked the second one
                infoArea.setText(secondInfo);
            }
            else if(newVal.equals(thirdLabel)){ // if they clicked the third one
                infoArea.setText(thirdInfo);
            }
            else{ // otherwise
                infoArea.setText(""); // set it blank
            }
        });

        // layout
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().setAll(listView, infoArea);

        // scene
        Scene mainScene = new Scene(layout, 600, 400);
        // STYLESHEET
        mainScene.getStylesheets().add("/com/groupproject/nik/main.css");

        // window
        window.setTitle(windowTitle);
        window.setScene(mainScene);
        window.initModality(Modality.APPLICATION_MODAL);
        window.showAndWait();
    }
}