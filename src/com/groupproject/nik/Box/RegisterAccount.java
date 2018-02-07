package com.groupproject.nik.Box;

import com.groupproject.nik.Model.Account;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class RegisterAccount {
    /** Opens a new window, and allows user to create a new account */
    public static Account createAccount(){
        Stage mainWindow = new Stage();
        Account newAccount = new Account();
        /* Scene */
        // Objects
        // username field
        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");

        // password labels
        Label passwordLabel = new Label("Password:");
        TextField passwordField = new TextField();
        passwordField.setPromptText("Password");
        Label copyPasswordLabel = new Label("Re-enter password:");
        TextField copyPasswordField = new TextField();
        copyPasswordField.setPromptText("Re-enter password");

        // first name
        Label firstnameLabel = new Label("First name:");
        TextField firstnameField = new TextField();
        firstnameField.setPromptText("First name");

        // last name
        Label lastnameLabel = new Label("Last name:");
        TextField lastnameField = new TextField();
        lastnameField.setPromptText("Last name");

        // age
        Label ageLabel = new Label("Age:");
        TextField ageField = new TextField();
        ageField.setPromptText("Age");

        // register button to submit
        Button registerButton = new Button("Register Account");

        // Label for showing errors
        Label errorLabel = new Label("");

        // Events
        // disable the X button
        mainWindow.setOnCloseRequest(event -> event.consume()); // doesn't let the user us the X button to close the window -- forces them to enter information
        registerButton.setOnAction(event -> {
            // check the username
            if(!usernameField.getText().equals("")){ // if it's not empty
                newAccount.setUsername(usernameField.getText());
            }else{
                errorLabel.setStyle("-fx-text-fill: red"); // color is red
                errorLabel.setText("ERROR: Review the form");
            }
            // check the password
            if( !(passwordField.getText().equals("") || copyPasswordField.getText().equals("")) && (passwordField.getText().equals(copyPasswordField.getText())) ){ // if either password field is not empty AND the fields are equal, set the password
                newAccount.setPassword(passwordField.getText()); // set the password
            }else{
                errorLabel.setStyle("-fx-text-fill: red"); // color is red
                errorLabel.setText("ERROR: Review the form");
            }
            // check the first name
            if(!firstnameField.getText().equals("")){ // if first name is not empty
                newAccount.setFirstName(firstnameField.getText());
            }else{
                errorLabel.setStyle("-fx-text-fill: red"); // color is red
                errorLabel.setText("ERROR: Review the form");
            }
            // check the last name
            if(!lastnameField.getText().equals("")){ // if first name is not empty
                newAccount.setLastName(lastnameField.getText());
            }else{
                errorLabel.setStyle("-fx-text-fill: red"); // color is red
                errorLabel.setText("ERROR: Review the form");
            }
            try{
                int age = Integer.parseInt(ageField.getText());
                newAccount.setAge(age); // sets the age value
            }catch (NumberFormatException e){
                errorLabel.setStyle("-fx-text-fill: red"); // color is red
                errorLabel.setText("ERROR: You cannot enter a number as a string -- it needs to be parsed.");
            }

            // check the make sure all of the fields have something in them
            if(!newAccount.getFirstName().equals("") && !newAccount.getLastName().equals("") && newAccount.getAge() != 0 && !newAccount.getUsername().equals("") && !newAccount.getPassword().equals("")){
                mainWindow.close();
            }else{
                errorLabel.setStyle("-fx-text-fill: red"); // color is red
                errorLabel.setText("ERROR: ALL VALUES MUST BE SET!");
            }
        });

        // layout
        GridPane layout = new GridPane();
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(20);
        GridPane.setConstraints(usernameLabel, 0, 0);
        GridPane.setConstraints(usernameField, 1, 0);
        GridPane.setConstraints(passwordLabel, 0, 1);
        GridPane.setConstraints(passwordField, 1, 1);
        GridPane.setConstraints(copyPasswordLabel, 0, 2);
        GridPane.setConstraints(copyPasswordField, 1, 2);
        GridPane.setConstraints(firstnameLabel, 0, 3);
        GridPane.setConstraints(firstnameField, 1, 3);
        GridPane.setConstraints(lastnameLabel, 0, 4);
        GridPane.setConstraints(lastnameField, 1, 4);
        GridPane.setConstraints(ageLabel, 0, 5);
        GridPane.setConstraints(ageField, 1, 5);
        GridPane.setConstraints(registerButton, 0, 6);
        GridPane.setConstraints(errorLabel, 0, 7);
        layout.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField, copyPasswordLabel, copyPasswordField, firstnameLabel, firstnameField, lastnameLabel, lastnameField, ageLabel, ageField, registerButton, errorLabel);

        // scene
        Scene mainScene = new Scene(layout, 400, 800);
        mainScene.getStylesheets().add("/com/groupproject/nik/Resources/main.css");

        // window
        mainWindow.setScene(mainScene);
        mainWindow.setTitle("Create new account");
        mainWindow.initModality(Modality.APPLICATION_MODAL);
        mainWindow.showAndWait();

        return newAccount; // return the account value
    }
}
