/*
 * This file is following part 3 of the
 * Oracle JavaFX tutorial, this is a continuation of part two
 * and adds in styling the form with css
 * some comments are copied from the
 * tutorial page instructions
 */

package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FancyForm extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("JavaFX Welcome");

        /*
         * For the login form, use a GridPane layout because it enables you to create a flexible grid
         * of rows and columns in which to lay out controls. You can place controls in any cell in the grid,
         * and you can make controls span cells as needed.
         */
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        /*
         * Create the text fields their labels and add them to the grid
         */
        final Text actionTarget = new Text();
        actionTarget.setId("action-target");
        grid.add(actionTarget, 1, 6);

        Text sceneTitle = new Text("Welcome");
        sceneTitle.setId("welcome-text");
        grid.add(sceneTitle, 0,0,2,1);

        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        Button btn = new Button("Sign In");
        btn.setOnAction(event -> actionTarget.setText("Sign in button pressed"));
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        Scene scene = new Scene(grid, 350, 275);
        primaryStage.setScene(scene);
        scene.getStylesheets().add(
                FancyForm.class.getResource("fancyform.css").toExternalForm()
        );

        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}

