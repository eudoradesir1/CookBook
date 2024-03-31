package guiProject;
import java.io.IOException;
import java.util.Scanner;
import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.robot.Robot;
import javafx.stage.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.StackPane;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;


// name this page in javafx third page
public class Thirdpage extends RecipeBookMainPage  {
 @Override
public void start(Stage primaryStage) {
    primaryStage.setTitle("Recipe Manager");

    // UI elements
    TextField recipeNameField = new TextField();
    TextArea recipeDetailsArea = new TextArea();
    Button createButton = new Button("Create Recipe!");
    Button saveButton = new Button("Save Recipe!");
    Label errorLabel = new Label();

    // Event handlers
    createButton.setOnAction(event -> {
        String name = recipeNameField.getText().trim();
        if (!name.isEmpty()) {
            // Check if recipe with the same name already exists
            if (recipes.containsKey(name)) {
                errorLabel.setText("Rename this recipe!");
            } else {
                errorLabel.setText("");
                recipeDetailsArea.clear();
                recipes.put(name, "");
            }
        } else {
            errorLabel.setText("Recipe name cannot be empty!");
        }
    });
// add else if they want to save a recipe or delete
   // if delete button is pressed return back to first page
    // if they click save run thru a filesave method
    saveButton.setOnAction(event -> {
        String name = recipeNameField.getText().trim();
        String details = recipeDetailsArea.getText().trim();
        if (!name.isEmpty() && !details.isEmpty()) {
            recipes.put(name, details);
            errorLabel.setText("Recipe saved successfully!");
        } else {
            errorLabel.setText("Recipe name and details cannot be empty!");
        }
    });

    // Layout
    VBox root = new VBox(10);
    root.setPadding(new Insets(10));
    root.getChildren().addAll(
            new Label("Recipe Name:"),
            recipeNameField,
            new Label("Recipe Details:"),
            recipeDetailsArea,
            createButton,
            saveButton,
            errorLabel
    );

    primaryStage.setScene(new Scene(root, 400, 300));
    primaryStage.show();
}

public static void main(String[] args) {
    launch(args);
}

private static void launch(String[] args) {
	// TODO Auto-generated method stub
	
}
}