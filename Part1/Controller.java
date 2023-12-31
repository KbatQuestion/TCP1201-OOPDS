package Part1;

import java.util.ArrayList;
import java.util.HashMap;

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

class User {
    protected String id;
    protected String name;
    protected String password;
    protected String userType;
    protected String courseCode;
}

public class Controller extends User {
    View view;
    Model model = new Model();

    public Controller(View view) {
        this.view = view;
    }

    // Credential Logic
    public void isCredentialValid(String password, String id) {

        HashMap<String, ArrayList<String>> tempTeahcerLoginMap = new HashMap<String, ArrayList<String>>(
                model.getTeacherHashMap());

        HashMap<String, ArrayList<String>> tempStudentLoginMap = new HashMap<String, ArrayList<String>>(
                model.getStudentHashMap());

        if (tempTeahcerLoginMap.containsKey(id)) {

            if (password.equals(tempTeahcerLoginMap.computeIfAbsent(id, k -> new ArrayList<>()).get(1))) {

                view.setTeacherMainMenuScene();
                System.out.println("Lecturer login successful");
            }

            else {
                view.errorMessenge("Invalid Username/Password", "Invalid Credentials");
            }

        }

        else if (tempStudentLoginMap.containsKey(id)) {

            if (password.equals(tempStudentLoginMap.computeIfAbsent(id, k -> new ArrayList<>()).get(1))) {

                view.setStudentMainMenuScene();
            }

            else {
                view.errorMessenge("Invalid Username/Password", "Invalid Credentials");
            }

        }

        else if (id.equals("admin") && password.equals("admin")) {
            view.setAdminMainMenuScene();

            System.out.println("Admin login successful");
        }

        // Example of Usage of the Error message just called it whenever you want
        else {
            view.errorMessenge("Invalid Username/Password", "Invalid Credentials");
        }
    }

    public void createUser(String name, String id, String password, CheckBox teacherCheckBox,
            CheckBox studentCheckBox) {

        if (teacherCheckBox.isSelected() && !studentCheckBox.isSelected()) {
            HashMap<String, ArrayList<String>> tempTeacherLoginMap = new HashMap<String, ArrayList<String>>();

            tempTeacherLoginMap.put(id, new ArrayList<String>());
            tempTeacherLoginMap.get(id).add(name);
            tempTeacherLoginMap.get(id).add(password);
            model.setTeacherHashMap(tempTeacherLoginMap);
            view.errorMessenge("Lecture " + (name) + " Created Sucessfully", "User Created");

        }

        if (studentCheckBox.isSelected() && !teacherCheckBox.isSelected()) {
            HashMap<String, ArrayList<String>> tempStudentLoginMap = new HashMap<String, ArrayList<String>>();

            tempStudentLoginMap.put(id, new ArrayList<String>());
            tempStudentLoginMap.get(id).add(name);
            tempStudentLoginMap.get(id).add(password);
            model.setStudentHashMap(tempStudentLoginMap);
            view.errorMessenge("Student " + (name) + " Created Sucessfully", "User Created");

        }

        if (studentCheckBox.isSelected() && teacherCheckBox.isSelected()) {
            view.errorMessenge("Pick One User Type Only", "Invalid Option");
        }

    }

}
