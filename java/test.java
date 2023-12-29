package java;

import java.util.ArrayList;
import java.util.Arrays;

class User {
    protected String id;
    protected String name;
    protected String password;
    protected String userType;
}

class Admin extends User {
    private String courseCode;

    public void createStudent(String id, String name, String password, String courseCode) {
        String[] newStudent = new String[4];
        newStudent[0] = id;
        newStudent[1] = name;
        newStudent[2] = password;
        newStudent[3] = courseCode;
        super.userType = "Student";
    }

    public void createLecturer(String id, String name, String password, String courseCode) {
        String[] newLecturer = new String[4];
        newLecturer[0] = id;
        newLecturer[1] = name;
        newLecturer[2] = password;
        newLecturer[3] = courseCode;
        super.userType = "Lecturer";
    }

    public void createCourse(String courseCode) {

    }

    public void assignCourse(String courseCode) {

    }
}

class Student extends User {

}

class Lecturer extends User {

}

public class test {
    public static void main(String[] args) {
        // use studentInformation.get(rows).get(columns) to access 2d
        ArrayList<ArrayList<Student>> studentInformation = new ArrayList<>();
        ArrayList<ArrayList<Lecturer>> lecturerInformation = new ArrayList<>();
        ArrayList<String> newCourseName = new ArrayList<>();
        System.out.println("Welcome to MMU Course Management System");
        System.out.println("Choose a number to begin the execution");
        System.out.println("1: Create new student in the system");
        System.out.println("2: Create new lecturer in the system");
        System.out.println("3: Create course ");
    }
}
