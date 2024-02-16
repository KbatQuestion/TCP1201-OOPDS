package Part1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Model {
    // //private HashMap<String, ArrayList<String>> teacherLoginMap = new
    // HashMap<String, ArrayList<String>>();
    // //private HashMap<String, ArrayList<String>> studentLoginMap = new
    // HashMap<String, ArrayList<String>>();

    // // Student Hashmap key = id
    // // name
    // // password
    // // Student Course taken
    // // Course Hour

    // // Teacher Hasmap key = id
    // // name
    // // password
    // // Asssign Course

    // // Admin/Teacher Hasmap

    // // key = course name value = id
    // // Course and Register to the Lecture
    // // Course with Register Student

    // // Getter
    // public HashMap<String, ArrayList<String>> getTeacherHashMap() {
    // return teacherLoginMap;
    // }

    // // Setter
    // public void setTeacherHashMap(HashMap<String, ArrayList<String>>
    // newTeacherLoginMap) {
    // this.teacherLoginMap = newTeacherLoginMap;
    // }

    // // Getter
    // public HashMap<String, ArrayList<String>> getStudentHashMap() {
    // return studentLoginMap;
    // }

    // // Setter
    // public void setStudentHashMap(HashMap<String, ArrayList<String>>
    // newstudentLoginMap) {
    // this.studentLoginMap = newstudentLoginMap;
    // }

    // Old Code Above will be Remove

    // Student Hashmap key = id
    // name
    // password
    // Student Course taken
    // Course Hour

    // Teacher Hasmap key = id
    // name
    // password
    // Asssign Course

    // Admin/Teacher Hasmap

    // key = course name value = id
    // Course and Register to the Lecture
    // Course with Register Student
    // Course with Pre-reqsite //Implement Later
    // Course Credit Hour //Implement Later

    // Sets
    // Course available to be registerd

    public Integer currentUser;

    private HashMap<Integer, String> teacherPasswordHashMap = new HashMap<Integer, String>();
    private HashMap<Integer, String> teacherNameHashMap = new HashMap<Integer, String>();
    private HashMap<Integer, ArrayList<String>> teacherAsignCourseHashMap = new HashMap<Integer, ArrayList<String>>();

    
    private HashMap<Integer, String> studentPasswordHashMap = new HashMap<Integer, String>();
    private HashMap<Integer, String> studentNameHashMap = new HashMap<Integer, String>();
    private HashMap<Integer, Set<String>> studentRecordHashMap = new HashMap<Integer, Set<String>>();

    // remove later
    private HashMap<String, Integer> lectureRecordHashMap = new HashMap<String, Integer>();
    private HashMap<String, Set<Integer>> subjectRecordHashMap = new HashMap<String, Set<Integer>>();
    
    private HashMap<String, Integer> assignLectureHashMap = new HashMap<String, Integer>();
    private HashMap<String, ArrayList<Integer>> assignStudentHashMap = new HashMap<String, ArrayList<Integer>>();
    private Set<String> courseAvailablSet = new HashSet<String>();

    // Getter
    public HashMap<Integer, String> getTeacherPasswordHashMap() {
        return teacherPasswordHashMap;
    }

    // Setter
    public void setTeacherPasswordHashMap(HashMap<Integer, String> newTeacherPaswordHashMap) {
        this.teacherPasswordHashMap = newTeacherPaswordHashMap;
    }

    // Getter
    public HashMap<Integer, String> getTeacherNameHashMap() {
        return teacherNameHashMap;
    }

    // Setter
    public void setTeacherNameHashMap(HashMap<Integer, String> newTeacherNameHashMap) {
        this.teacherNameHashMap = newTeacherNameHashMap;
    }

    // Getter
    public HashMap<Integer, ArrayList<String>> getTeacherAsignCourseHashMap() {
        return teacherAsignCourseHashMap;
    }

    // Setter
    public void setTeacherAsignCourseHashMap(HashMap<Integer, ArrayList<String>> newTeacherAsignCourseHashMap) {
        this.teacherAsignCourseHashMap = newTeacherAsignCourseHashMap;
    }

    // Getter
    public HashMap<Integer, String> getStudentPasswordHashMap() {
        return studentPasswordHashMap;
    }

    // Setter
    public void setStudentPasswordHashMap(HashMap<Integer, String> newStudentPaswordHashMap) {
        this.studentPasswordHashMap = newStudentPaswordHashMap;
    }

    // Getter
    public HashMap<Integer, String> getStudentNameHashMap() {
        return studentNameHashMap;
    }

    // Setter
    public void setStudentNameHashMap(HashMap<Integer, String> newStudentNameHashMap) {
        this.studentNameHashMap = newStudentNameHashMap;
    }

    // Getter
    public HashMap<Integer, Set<String>> getStudentRecordHashMap() {
        return studentRecordHashMap;
    }

    // Setter
    public void setStudentRecordHashMap(HashMap<Integer, Set<String>> newStudentRecordHashMap) {
        this.studentRecordHashMap = newStudentRecordHashMap;
    }

    // Getter
    public HashMap<String, Integer> getLectureRecordHashMap() {
        return lectureRecordHashMap;
    }

    // Setter
    public void setLectureRecordHashMap(HashMap<String, Integer> newAssignLectureHashMap) {
        this.lectureRecordHashMap = newAssignLectureHashMap;
    }

    // Getter
    public HashMap<String, Set<Integer>> getSubjectRecordHashMap() {
        return subjectRecordHashMap;
    }

    // Setter
    public void setSubjectRecordHashMap(HashMap<String, Set<Integer>> newAssignStudentHashMapp) {
        this.subjectRecordHashMap = newAssignStudentHashMapp;
    }

    // Getter
    public Set<String> getCourseAvailablSet() {
        return courseAvailablSet;
    }

    // Setter
    public void setCourseAvailablSet(Set<String> newCourseAvailablSet) {
        this.courseAvailablSet = newCourseAvailablSet;
    }

}