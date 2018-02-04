package com.groupproject.nik.Box;

import com.groupproject.nik.Model.Account;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/** A class that provides a few different windows for when a user is logged in */
public class UserBoxes {
    private static Account manipulatedAccount;

    /** A window for viewing the Home of someone's login session -- takes in the current user's account */
    public static Account displayHome(Account currentAccount){
        Stage window = new Stage();
        manipulatedAccount = currentAccount;

        /* Scene */
//      Objects
//      TOP Objects
        Button logoutButton = new Button("Logout of " + currentAccount.getUsername());
        Button settingsButton = new Button("Settings for " + currentAccount.getUsername());
//      LEFT objects
        Label optionsLabel = new Label("Window Options");
        Button inventoryButton = new Button("Inventory");
//      CENTER objects
        Label nameLabel = new Label("Name:");
        Label usernameLabel = new Label("Username:");
        Label ageLabel = new Label("Age:");

        Label nameFieldLabel = new Label(currentAccount.getFirstName() + " " + currentAccount.getLastName());
        Label usernameFieldLabel = new Label(currentAccount.getUsername());
        Label ageFieldLabel = new Label(currentAccount.getAge()+"");

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
        topLayout.setAlignment(Pos.TOP_CENTER);
        topLayout.getChildren().setAll(logoutButton, settingsButton);
//      LEFT layout
        VBox leftLayout = new VBox(10);
        leftLayout.setAlignment(Pos.CENTER);
        leftLayout.getChildren().addAll(optionsLabel, inventoryButton);
//      CENTER layout
        GridPane centerLayout = new GridPane();
        centerLayout.setHgap(15);
        centerLayout.setVgap(15);
        GridPane.setConstraints(nameLabel, 0, 0);
        GridPane.setConstraints(usernameLabel, 1, 0);
        GridPane.setConstraints(ageLabel, 2, 0);
        GridPane.setConstraints(nameFieldLabel, 0, 1);
        GridPane.setConstraints(usernameFieldLabel, 1, 1);
        GridPane.setConstraints(ageFieldLabel, 2, 1);
        centerLayout.setAlignment(Pos.CENTER);
        centerLayout.getChildren().addAll(nameLabel,usernameLabel, ageLabel, nameFieldLabel, usernameFieldLabel, ageFieldLabel);
//      MAIN layout
        BorderPane.setMargin(topLayout, new Insets(10, 10, 10, 10));
        BorderPane.setMargin(leftLayout, new Insets(10, 10, 10, 10));
        BorderPane.setMargin(centerLayout, new Insets(10,10, 10, 10));

        BorderPane mainLayout = new BorderPane();
        mainLayout.setTop(topLayout);
        mainLayout.setLeft(leftLayout);
        mainLayout.setCenter(centerLayout);

//      Scene options
        Scene mainScene = new Scene(mainLayout, 600, 400);
        mainScene.getStylesheets().add("/com/groupproject/nik/main.css");

        // Window options
        // Icon image
        Image image = new Image("/com/groupproject/nik/Photos/awesome_deep_space.jpg");
        window.getIcons().addAll(image);
        window.setTitle("Account Home: " + currentAccount.getUsername());
        window.setScene(mainScene);
        window.initModality(Modality.APPLICATION_MODAL);
        window.showAndWait();

        return currentAccount;
    }

    /** Opens the settings window for the user */
    private static void displaySettings(Account theAccount){
        Stage window = new Stage();
        /* Scene */
        // Objects
        Label choiceLabel = new Label("Please choose below, as to what you'd like to modify:");
        ComboBox<String> stringComboBox = new ComboBox<>();
        stringComboBox.getItems().addAll("Username", "Password", "First Name", "Last Name");
        stringComboBox.setValue("Username"); // by default, it is set to username

        Button submit = new Button("Complete");

        // events
        submit.setOnAction(event -> {
            window.close();
        });
        stringComboBox.setOnAction(event -> {
            String item = stringComboBox.getSelectionModel().getSelectedItem(); // gets the item that was selected
            // decides which field to pass as an argument depending on what the user chose
            int choice;
            if(item.equals("Username"))
                choice = 1;
            else if(item.equals("Password"))
                choice = 2;
            else if(item.equals("First Name"))
                choice = 3;
            else if (item.equals("Last Name"))
                choice = 4;
            else
                choice = 1; // change the username

            changeField(theAccount, choice);
        });
        window.setOnCloseRequest(event -> event.consume()); // don't let the user hit the X to exit

        // layout
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(choiceLabel, stringComboBox, submit);

        // scene
        Scene scene = new Scene(layout, 200, 200);

        // window
        window.setScene(scene);
        window.setTitle("Settings Changer Chooser");
        window.initModality(Modality.APPLICATION_MODAL);
        window.showAndWait();
    }

    private static void changeField(Account account, int choice) {
        Stage window = new Stage();
        /* Scene */
        // Objects
        Label newFieldLabel = new Label();
        Label copyFieldLabel = new Label();
        TextField newField = new TextField("new");
        TextField copyField = new TextField("copy");
        // decide which choice it is, and set the text accordingly
        switch (choice){
            case 1: // username
                newFieldLabel.setText("Enter new username:");
                copyFieldLabel.setText("Enter copy username:");
                break;
            case 2: // password
                newFieldLabel.setText("Enter new password:");
                copyFieldLabel.setText("Enter copy password:");
                break;
            case 3: // first name
                newFieldLabel.setText("Enter new first name:");
                copyFieldLabel.setText("Enter copy first name:");
                break;
            case 4: // last name
                newFieldLabel.setText("Enter new last name:");
                copyFieldLabel.setText("Enter copy last name:");
                break;
        } // end of switch
        Button submit = new Button("Submit");
        Label successLabel = new Label("");

        // events
        submit.setOnAction(event -> {
            if( !(newField.getText().equals("") || copyField.getText().equals("")) && newField.getText().equals(copyField.getText())){ // both fields have something in them, and the fields are equal
                if(choice == 1)
                    manipulatedAccount.setUsername(newField.getText()); // set the username to what the user entered
                else if(choice == 2)
                    manipulatedAccount.setPassword(newField.getText()); // set the password to what the user entered
                else if(choice == 3)
                    manipulatedAccount.setFirstName(newField.getText()); // set the first name to what the user entered
                else if(choice == 4)
                    manipulatedAccount.setLastName(newField.getText()); // set the last name to what the user entered
                successLabel.setStyle("-fx-text-fill: green");
                successLabel.setText("SUCCESS: Value changed.");
            }
            else{ // there was a problem
                successLabel.setStyle("-fx-text-fill: red");
                successLabel.setText("ERROR: Fields must match.");
            }
        });

        // layout
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(newFieldLabel, newField, copyFieldLabel, copyField, submit, successLabel);
        // Scene
        Scene scene = new Scene(layout, 400, 400);
        // Window
        window.setTitle("Change field");
        window.setScene(scene);
        window.initModality(Modality.APPLICATION_MODAL);
        window.showAndWait();
    }
}
