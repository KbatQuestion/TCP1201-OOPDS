package Part1;

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


        //Example of Usage of the Error message just called it whenever you want
        else {
            view.errorMessenge("Invalid Username/Password", "Invalid Credentials");
        }
    }
}


