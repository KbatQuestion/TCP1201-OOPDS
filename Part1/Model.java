package Part1;

import java.util.ArrayList;
import java.util.HashMap;

public class Model {
    private HashMap<String, ArrayList<String>> teacherLoginMap = new HashMap<String, ArrayList<String>>();
    private HashMap<String, ArrayList<String>> studentLoginMap = new HashMap<String, ArrayList<String>>();

    // Getter
    public HashMap<String, ArrayList<String>> getTeacherHashMap() {
        return teacherLoginMap;
    }

    // Setter
    public void setTeacherHashMap(HashMap<String, ArrayList<String>> newTeacherLoginMap) {
        this.teacherLoginMap = newTeacherLoginMap;
    }
    

    // Getter
    public HashMap<String, ArrayList<String>> getStudentHashMap() {
        return studentLoginMap;
    }

    // Setter
    public void setStudentHashMap(HashMap<String, ArrayList<String>> newstudentLoginMap) {
        this.studentLoginMap = newstudentLoginMap;
    }

}