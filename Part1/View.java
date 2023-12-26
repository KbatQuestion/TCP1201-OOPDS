package Part1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class View extends Application {

    Stage window;
    Scene scene_Login,
            sceneStudentMainMenu,
            sceneTeacherMainMenu,
            sceneAdminMainMenu,
            sceneCreateUser,
            sceneCreateCourse;

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Controller controller = new Controller(this);
        this.window = primaryStage;
        window.setTitle("Log in");

        // LogIn Page Gui

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
        loginButton.setOnAction(e -> controller.isCredentialValid(passTextField.getText(), namTextField.getText()));
        // loginButton.setOnAction(e -> window.setScene(scene_StudentMainMenu));

        GridPane.setConstraints(loginButton, 2, 5);

        // Passing the Object to the Scene

        loginGridPane.getChildren().addAll(nameLable, namTextField, passLable, passTextField, loginButton);

        Scene scene_Login = new Scene(loginGridPane, 400, 200);

        window.setScene(scene_Login);

        window.show();

    }

    // Student MainMenu

    public void setStudentMainMenuScene() {

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

        studentGrid.getChildren().addAll(button1, button2, button3, button4, welcome);

        sceneStudentMainMenu = new Scene(studentGrid, 400, 250);
        window.setScene(sceneStudentMainMenu);
    }

    // Teacher MainMenu Gui

    public void setTeacherMainMenuScene() {

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

        teacherGrid.getChildren().addAll(button1, button2, button3, button4, welcome);

        sceneTeacherMainMenu = new Scene(teacherGrid, 400, 250);
        window.setScene(sceneTeacherMainMenu);
    }

    // Admin MainMenu Gui

    public void setAdminMainMenuScene() {

        GridPane adminGrid = new GridPane();
        adminGrid.setPadding(new Insets(10, 10, 10, 10));
        adminGrid.setVgap(20);
        adminGrid.setHgap(20);

        Label welcome = new Label("Welcome Admin");

        Button button1 = new Button("Create a User");
        button1.setOnAction(e -> createUserGui());

        Button button2 = new Button("Create Courses");
        button2.setOnAction(e -> createCoursesGui());


        Button button3 = new Button("Assign Courses");
        Button button4 = new Button("View Courses");

        GridPane.setConstraints(welcome, 2, 0);

        GridPane.setConstraints(button1, 2, 1);
        GridPane.setConstraints(button2, 2, 2);
        GridPane.setConstraints(button3, 2, 3);
        GridPane.setConstraints(button4, 2, 4);

        adminGrid.getChildren().addAll(button1, button2, button3, button4, welcome);

        sceneAdminMainMenu = new Scene(adminGrid, 400, 250);
        window.setScene(sceneAdminMainMenu);
    }

    // Error Messages to be called
    public void errorMessenge(String text, String title) {

        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(300);

        Label errorMessenge = new Label(text);

        Button button1 = new Button("Close");
        button1.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(errorMessenge, button1);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

    }

    public void createUserGui() {

        GridPane createUserGrid = new GridPane();
        createUserGrid.setPadding(new Insets(10, 10, 10, 10));
        createUserGrid.setVgap(20);
        createUserGrid.setHgap(20);

        Label contexLabel = new Label("Create User");
        Label label2 = new Label("Name");
        Label label3 = new Label("Id");
        Label lable4 = new Label("Password");
        Label lable5 = new Label("User Type");

        Button button1 = new Button("Create User");

        Button button2 = new Button("Cancel");
        button2.setOnAction(e -> setAdminMainMenuScene());

        TextField name = new TextField();
        TextField id = new TextField();
        TextField password = new TextField();

        CheckBox studentCheckBox = new CheckBox("Student");
        CheckBox teacherCheckBox = new CheckBox("Teacher");

        GridPane.setConstraints(contexLabel, 2, 0);

        GridPane.setConstraints(label2, 2, 1);
        GridPane.setConstraints(name, 2, 2);

        GridPane.setConstraints(label3, 2, 3);
        GridPane.setConstraints(id, 2, 4);

        GridPane.setConstraints(lable4, 2, 5);
        GridPane.setConstraints(password, 2, 6);

        GridPane.setConstraints(lable5, 2, 7);

        GridPane.setConstraints(studentCheckBox, 2, 8);
        GridPane.setConstraints(teacherCheckBox, 3, 8);

        GridPane.setConstraints(button1, 2, 9);
        GridPane.setConstraints(button2, 3, 9);

        createUserGrid.getChildren().addAll(
            contexLabel, 
            label2, 
            label3, 
            lable4, 
            lable5, 
            button1, 
            button2, 
            name, 
            id,
            password, 
            studentCheckBox, 
            teacherCheckBox
            );

        sceneCreateUser = new Scene(createUserGrid, 400, 450);
        window.setScene(sceneCreateUser);
    }


    

}
