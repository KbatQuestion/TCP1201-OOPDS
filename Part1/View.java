package Part1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class View extends Application {

    Stage window;
    Scene scene_Login, sceneStudentMainMenu,sceneTeacherMainMenu, sceneAdminMainMenu;

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Controller controller = new Controller(this);
        this.window = primaryStage;
        window.setTitle("Log in");

        GridPane loginGridPane = new GridPane();
        loginGridPane.setPadding(new Insets(10, 10, 10, 10));
        loginGridPane.setVgap(8);
        loginGridPane.setHgap(10);

        // lable name
        Label nameLable = new Label("ID Number");
        GridPane.setConstraints(nameLable, 2, 0);

        // name imput

        TextField namTextField = new TextField();
        namTextField.setPromptText("Eg: 12334567890");
        GridPane.setConstraints(namTextField, 2, 1);

        // Password name
        Label passLable = new Label("Password");
        GridPane.setConstraints(passLable, 2, 3);

        // Password imput

        TextField passTextField = new TextField();
        GridPane.setConstraints(passTextField, 2, 4);

        // Log In Button

        Button loginButton = new Button("Log in");
        loginButton.setOnAction(e -> controller.isCredentialValid(passTextField.getText(),namTextField.getText()));
        //loginButton.setOnAction(e -> window.setScene(scene_StudentMainMenu));

        GridPane.setConstraints(loginButton, 2, 5);

        // Passing the Object to the Scene

        loginGridPane.getChildren().addAll(nameLable, namTextField, passLable, passTextField, loginButton);

        Scene scene_Login = new Scene(loginGridPane, 400, 200);
       


    
        window.setScene(scene_Login);

        window.show();

    }

    public void setStudentMainMenuScene() {
        //Student MainMenu

        GridPane studentGrid = new GridPane();
        studentGrid.setPadding(new Insets(10, 10, 10, 10));
        studentGrid.setVgap(20);
        studentGrid.setHgap(20);


        Label welcome = new Label("Welcome Student");

        Button button1 = new Button("Button1");
        Button button2 = new Button("Button2");
        Button button3 = new Button("Button3");
        Button button4 = new Button("Button4");

        
        GridPane.setConstraints(welcome, 2, 0);

        GridPane.setConstraints(button1, 2, 1);
        GridPane.setConstraints(button2, 2, 2);
        GridPane.setConstraints(button3, 2, 3);
        GridPane.setConstraints(button4, 2, 4);

        studentGrid.getChildren().addAll(button1,button2,button3,button4,welcome);

        sceneStudentMainMenu = new Scene(studentGrid, 400, 250);
        window.setScene(sceneStudentMainMenu);
    }




     public void setTeacherMainMenuScene() {
        //Teacher MainMenu

        GridPane teacherGrid = new GridPane();
        teacherGrid.setPadding(new Insets(10, 10, 10, 10));
        teacherGrid.setVgap(20);
        teacherGrid.setHgap(20);


        Label welcome = new Label("Welcome Teacher");

        Button button1 = new Button("Button1");
        Button button2 = new Button("Button2");
        Button button3 = new Button("Button3");
        Button button4 = new Button("Button4");

        
        GridPane.setConstraints(welcome, 2, 0);

        GridPane.setConstraints(button1, 2, 1);
        GridPane.setConstraints(button2, 2, 2);
        GridPane.setConstraints(button3, 2, 3);
        GridPane.setConstraints(button4, 2, 4);

        teacherGrid.getChildren().addAll(button1,button2,button3,button4,welcome);

        sceneTeacherMainMenu = new Scene(teacherGrid, 400, 250);
        window.setScene(sceneTeacherMainMenu);
    }


    public void setAdminMainMenuScene() {
        //Teacher MainMenu

        GridPane adminGrid = new GridPane();
        adminGrid.setPadding(new Insets(10, 10, 10, 10));
        adminGrid.setVgap(20);
        adminGrid.setHgap(20);


        Label welcome = new Label("Welcome Admin");

        Button button1 = new Button("Button1");
        Button button2 = new Button("Button2");
        Button button3 = new Button("Button3");
        Button button4 = new Button("Button4");

        
        GridPane.setConstraints(welcome, 2, 0);

        GridPane.setConstraints(button1, 2, 1);
        GridPane.setConstraints(button2, 2, 2);
        GridPane.setConstraints(button3, 2, 3);
        GridPane.setConstraints(button4, 2, 4);

        adminGrid.getChildren().addAll(button1,button2,button3,button4,welcome);

        sceneAdminMainMenu = new Scene(adminGrid, 400, 250);
        window.setScene(sceneAdminMainMenu);
    }

}
