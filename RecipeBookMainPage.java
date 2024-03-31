package guiProject;
import javafx.application.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RecipeBookMainPage extends Thirdpage {
// 1st page of recipe project!
	// make a button for saving recipes
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void start(Stage primaryStage) {
		primaryStage.setTitle("Recipe Book");
		// create button
		Button saveButton = new Button("Would you like to save a recipe?");
		saveButton.setOnAction(e -> saveRecipe());
		
		// create add button also with layout
		VBox layout = new Vbox(10);
		layout.setPadding(new Insets(10));
		layout.getChildren().addAll(saveButton);
		
		//set the scene
		Scene scene = new Scene(layout, 300, 250);
		primaryStage.setScene(scene);
		primaryStage.show();

		
	}
//Method to handle saving recipe
private void saveRecipe() {
    // Code to prompt user for recipe details and save the recipe
    System.out.println("Recipe saved!");
}
}

