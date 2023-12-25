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

public class Controller {
    View view;

    public Controller(View view) {
        this.view = view;
    }

    // Credential Logic
    public void isCredentialValid(String password, String Id) {

        if (Id.equals("student") && password.equals("student")) {
            view.setStudentMainMenuScene();
        }

        if (Id.equals("teacher") && password.equals("teacher")) {
            view.setTeacherMainMenuScene();
        }

        if (Id.equals("admin") && password.equals("admin")) {
            view.setAdminMainMenuScene();
        }

        else {
            System.out.println("Nutz");
        }
    }
}

// Where main logic of the program will be made
