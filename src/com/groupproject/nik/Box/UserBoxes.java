package com.groupproject.nik.Box;

import com.groupproject.nik.Model.Account;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/** A class that provides a few different windows for when a user is logged in */
public class UserBoxes {
    /** A window for viewing the Home of someone's login session -- takes in the current user's account */
    public static void displayHome(Account currentAccount){
        Stage window = new Stage();
        // Icon image
        Image image = new Image("/com/groupproject/nik/Photos/awesome_deep_space.jpg");
        window.getIcons().addAll(image);
        window.setTitle("Account Home: " + currentAccount.getUsername());

        /* Scene */
//      Objects
//      TOP Objects
        Button logoutButton = new Button("Logout of " + currentAccount.getUsername());
        Button settingsButton = new Button("Settings for " + currentAccount.getUsername());
//      LEFT objects
        Label optionsLabel = new Label("Window Options");
        Button inventoryButton = new Button("Inventory");
//      CENTER objects
        TextArea informationArea = new TextArea();
        informationArea.setText("Username: " + currentAccount.getUsername() + "\n"
        + "First name: " + currentAccount.getFirstName() + "\n"
        + "Last name: " + currentAccount.getLastName() + "\n"
        + "Age: " + currentAccount.getAge() + "\n");

//      Events
        logoutButton.setOnAction(event -> {
            boolean answer = ConfirmBox.display("Logout", "Are you sure you want to logout?");
            if(answer)
                window.close(); // close the window
        });
        settingsButton.setOnAction(event -> {
            // Open settings window
        });
        window.setOnCloseRequest(event -> {
            event.consume();
            boolean answer = ConfirmBox.display("Logout", "Are you sure you want to logout?");
            if(answer) // if the answer is yes
                window.close(); // close the window
        });

//      Layout
//      TOP layout
        HBox topLayout = new HBox(10);
        topLayout.getChildren().setAll(logoutButton, settingsButton);
//      LEFT layout
        VBox leftLayout = new VBox(10);
        leftLayout.setAlignment(Pos.CENTER);
        leftLayout.getChildren().addAll(optionsLabel, inventoryButton);
//      MAIN layout
        BorderPane.setMargin(topLayout, new Insets(10, 10, 10, 10));
        BorderPane.setMargin(leftLayout, new Insets(10, 10, 10, 10));
        BorderPane.setMargin(informationArea, new Insets(10, 10, 10, 10));

        BorderPane mainLayout = new BorderPane();
        mainLayout.setTop(topLayout);
        mainLayout.setLeft(leftLayout);
        mainLayout.setCenter(informationArea);

//      Scene options
        Scene mainScene = new Scene(mainLayout, 600, 400);
        mainScene.getStylesheets().add("/com/groupproject/nik/main.css");

        // Window options
        window.setScene(mainScene);
        window.initModality(Modality.APPLICATION_MODAL);
        window.showAndWait();
    }
}
