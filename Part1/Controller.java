package Part1;

import javafx.scene.control.CheckBox;

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
