package Part1;

import javafx.scene.control.CheckBox;

// Any object that has view. is just Gui windows that you guys can call
// view.setStudentMainMenuScene - MainMenuScene for the Student
// view.setTeacherMainMenuScene - MainMenuScene for the Teacher
// view.setAdminMainMenuScene - MainMenuScene for the Admin
// view.logInMenu - Login Screen
// view.errorMessenge("Text", "Title"); - Error Mesage but you have pass the two vatiable
// view.createUser - Menu to create User
// view.createCoursesGui-Menu to Create Course

//Any Function in this File is just action when someone click the button in the gui
// For the Function just pass the argument/paramaters (you ask me!) to make a new Function
// Make sure to Use Class

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

        else if (Id.equals("teacher") && password.equals("teacher")) {
            view.setTeacherMainMenuScene();

        }

        else if (Id.equals("admin") && password.equals("admin")) {
            view.setAdminMainMenuScene();
        }

        // Example of Usage of the Error message just called it whenever you want
        else {
            view.errorMessenge("Invalid Username/Password", "Invalid Credentials");
        }
    }

    public void createUser(String id, String name, String password, CheckBox teacherCheckBox,
            CheckBox studentCheckBox) {

        System.out.println(id);
        System.out.println(name);
        System.out.println(password);

        if (teacherCheckBox.isSelected()) {
            System.out.println("Teacher");

        }

        if (studentCheckBox.isSelected()) {
            System.out.println("Student");

        }

    }
}
