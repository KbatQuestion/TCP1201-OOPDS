package Part1;
import java.util.ArrayList;
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

public class Controller extends User{
    View view;
    private ArrayList<String> courseCode = new ArrayList<>();
    private ArrayList<ArrayList<String>> lecturerInformation = new ArrayList<>();
    private ArrayList<ArrayList<String>> studentInformation = new ArrayList<>();

    public Controller(View view) {
        this.view = view;
    }

    // Credential Logic
    public void isCredentialValid(String password, String id) {
        String elementToVerify = id;
        String elementToVerify2 = password;
        ArrayList<ArrayList<String>> studentInformation = getStudentInformation();
        ArrayList<ArrayList<String>> lecturerInformation = getLecturerInformation();

        if (verifyStudentLogin(id, password)) {
            view.setStudentMainMenuScene();
            System.out.println("Student login successful");
        }

        else if (verifyLecturerLogin(id, password)) {
            view.setTeacherMainMenuScene();
            System.out.println("Lecturer login successful");
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

    private boolean verifyLecturerLogin(String id, String password){
        ArrayList<ArrayList<String>> lecturerInformation = getLecturerInformation();
        return verifyLogin(id, password, lecturerInformation);
    }

    private boolean verifyStudentLogin(String id, String password){
        ArrayList<ArrayList<String>> studentInformation = getStudentInformation();
        return verifyLogin(id, password, studentInformation);
    }

    private boolean verifyLogin(String id, String password, ArrayList<ArrayList<String>> information){
        for (ArrayList<String> row : information){
            if (row.get(0).equals(id) && row.get(2).equals(password)){
                return true;
            }
        }
        return false;
    }

    public void createUser(String id, String name, String password, CheckBox teacherCheckBox,
            CheckBox studentCheckBox) {

        System.out.println(id);
        System.out.println(name);
        System.out.println(password);

        // When creating lecturer, the sysout prompts "Lecturer: id has been created in the system" instead of the name (fix this kbat)
        if (teacherCheckBox.isSelected()) {
            System.out.println("Teacher: " + name + " has been created in the system");
            ArrayList<String> newLecturer = new ArrayList<>();
            newLecturer.add(id);
            newLecturer.add(name);
            newLecturer.add(password);
            this.userType = "Lecturer";
            lecturerInformation.add(newLecturer);
        }
        // When creating student, the sysout prompts "Student: id has been created in the system" instead of the name (fix this kbat)
        if (studentCheckBox.isSelected()) {
            System.out.println("Student: " + name + " has been created in the system" );
            ArrayList<String> newStudent = new ArrayList<>();
            newStudent.add(id);
            newStudent.add(name);
            newStudent.add(password);
            this.userType = "Student";
            studentInformation.add(newStudent);
        }

    }
    // ArrayList<String> courseCode = new ArrayList<>();
    public void createCourse(String courseCode, ArrayList<String> array){
        if(array.contains(courseCode)){
            array.add(courseCode);
            System.out.println("Course code has been added to the system");
        }
        else{
            System.out.println("Error: Duplicate course code found");
        }
    }

    public void assignCourse(String courseCode){

    }

    public void registerCourse(String courseCode){

    }

    public void viewStudentInCourse(String courseCode){

    }

    public void viewStudentAndLecturerForCourse(String courseCode){

    }

    private ArrayList<ArrayList<String>> getStudentInformation(){
        return studentInformation;
    }

    private ArrayList<ArrayList<String>> getLecturerInformation(){
        return lecturerInformation;
    }
}
