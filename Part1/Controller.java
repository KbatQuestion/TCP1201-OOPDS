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
