package com.groupproject.nik.Box;

/*
 * Created on February 3rd, 2018
 * Author: Nik
 * Title TechNet
 * Description: A basic warehouse application for a fictitious corporation named TechNet
 */

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;

public class DisplayViewBox {
    private static Stage window;
    private static ListView<String> listView;

    /** A much more efficient way to display a series of information. This method takes in a title and two ArrayLists -- they work as parallel arrays */
    public static void displayMultiple(String windowTitle, ArrayList<String> label, ArrayList<String> info){
        /* Scene */
        // Objects
        window = new Stage();
        // Icon image
        Image image = new Image("/com/groupproject/nik/Photos/awesome_deep_space.jpg");
        window.getIcons().addAll(image);
        listView = new ListView<>();
        ArrayList<Label> labels = new ArrayList<>();

        for(String currentString : label){ // assumes info is of the same size
            labels.add(new Label(currentString)); // create a label with the current label string
        }

        for(int i = 0, l = label.size(); i < l; i++){
            listView.getItems().add(labels.get(i).getText()); // adds the label to the listView
        }

        TextArea infoArea = new TextArea("");
        infoArea.setEditable(false); // user cannot change the value

        listView.getSelectionModel().selectedItemProperty().addListener((model, oldVal, newVal) -> {
            // get the index of the selection model that was clicked -- which label they hit; 0 indexed
            int index = listView.getSelectionModel().getSelectedIndex();
            // figure out which element from the information ArrayList to populate below
            String theInfo = info.get(index); // gets string associated
            // set the text of the TextArea to the string discovered
            infoArea.setText(theInfo);
        });

        // layout
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().setAll(listView, infoArea);

        // scene
        Scene mainScene = new Scene(layout, 600, 400);
        // STYLESHEET
        mainScene.getStylesheets().add("/com/groupproject/nik/Resources/main.css");

        // window
        window.setTitle(windowTitle);
        window.setScene(mainScene);
        window.initModality(Modality.APPLICATION_MODAL);
        window.showAndWait();
    }
}