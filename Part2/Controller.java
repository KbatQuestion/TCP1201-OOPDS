package Part2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.security.auth.Subject;

import Part2.Model.Model;
import Part2.Model.ModelTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;

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
    Model model = new Model();
    ModelTable modelTable = new ModelTable();

    public Controller(View view) {
        this.view = view;
    }

    // Credential Logic
    public void isCredentialValid(String password, String id) {

        if (containsOnlyNumbers(id)) {
            int idInt = Integer.parseInt(id);

            HashMap<Integer, String> tempTeacherPasswordHashMap = new HashMap<Integer, String>(
                    model.getTeacherPasswordHashMap());

            HashMap<Integer, String> tempStudentPasswordHashMap = new HashMap<Integer, String>(
                    model.getStudentPasswordHashMap());

            if (tempTeacherPasswordHashMap.containsKey(idInt)) {

                if (tempTeacherPasswordHashMap.get(idInt).equals(password)) {

                    model.currentUser = idInt;
                    view.setTeacherMainMenuScene();
                    System.out.println("Lecturer login successful");
                }

                else {
                    view.errorMessenge("Invalid Username/Password", "Invalid Credentials");
                }

            }

            else if (tempStudentPasswordHashMap.containsKey(idInt)) {

                if (tempStudentPasswordHashMap.get(idInt).equals(password)) {

                    model.currentUser = idInt;
                    view.setStudentMainMenuScene();
                    checkMinCourseWork();
                    System.out.println("Student login successful");
                }

                else {
                    view.errorMessenge("Invalid Username/Password", "Invalid Credentials");
                }
            }

            else if (idInt == 0000 && password.equals("0000")) {
                view.setAdminMainMenuScene();
                System.out.println("Admin login successful");
            }

            // Example of Usage of the Error message just called it whenever you want
            else {
                view.errorMessenge("Invalid Username/Password", "Invalid Credentials");
            }
        }

        else {
            view.errorMessenge("Invalid Username/Password", "Invalid Credentials");
        }
    }

    public void createUser(String name, String id, String password, CheckBox teacherCheckBox,
            CheckBox studentCheckBox) {

        int idInt = Integer.parseInt(id);

        if (!model.takenID.contains(idInt)){
            if (teacherCheckBox.isSelected() && !studentCheckBox.isSelected()) {
                HashMap<Integer, String> tempTacherPasswordHashMap = new HashMap<Integer, String>(
                        model.getTeacherPasswordHashMap());
                HashMap<Integer, String> tempTeacherNameHashMap = new HashMap<Integer, String>(
                        model.getTeacherNameHashMap());

                
                    

                tempTeacherNameHashMap.put(idInt, name);
                tempTacherPasswordHashMap.put(idInt, password);
                model.setTeacherNameHashMap(tempTeacherNameHashMap);
                model.setTeacherPasswordHashMap(tempTacherPasswordHashMap);
                model.takenID.add(idInt);


                view.errorMessenge("Lecturer " + (name) + " Created Sucessfully", "User Created");
                
            }

            if (studentCheckBox.isSelected() && !teacherCheckBox.isSelected()) {
                HashMap<Integer, String> tempStudentPasswordHashMap = new HashMap<Integer, String>(model.getStudentPasswordHashMap());
                HashMap<Integer, String> tempStudentNameHashMap = new HashMap<Integer, String>(model.getStudentNameHashMap());
                HashMap<Integer, Set<String>> studentFutureRecordHashMap = new HashMap<Integer, Set<String>>(model.getStudentFutureRecordHashMap());
                HashMap<Integer, Integer> studentCreditHashMap = new HashMap<Integer, Integer>(model.getStudentCreditHashMap());
                Set<String> hash_Set = new HashSet<String>();

                hash_Set.add("CS113");
                hash_Set.add("CS123");
                hash_Set.add("CS133");
                hash_Set.add("CS143");
                hash_Set.add("CS214");
                hash_Set.add("CS234");
                hash_Set.add("CS316");
                
                tempStudentPasswordHashMap.put(idInt, password);
                tempStudentNameHashMap.put(idInt, name);
                studentFutureRecordHashMap.put(idInt,hash_Set);
                studentCreditHashMap.put(idInt, 0);

                model.setStudentNameHashMap(tempStudentNameHashMap);
                model.setStudentPasswordHashMap(tempStudentPasswordHashMap);
                model.setStudentFutureRecordHashMap(studentFutureRecordHashMap);
                model.setStudentCreditHashMap(studentCreditHashMap);
                model.takenID.add(idInt);
                
                System.out.println(studentFutureRecordHashMap);


                

                view.errorMessenge("Student " + (name) + " Created Sucessfully", "User Created");
            
            }

            if (studentCheckBox.isSelected() && teacherCheckBox.isSelected()) {
                view.errorMessenge("Pick One User Type Only", "Invalid Option");
            }

            

        }
        else view.errorMessenge( id +  " has been taken", "ID Taken");

    }

    private static boolean containsOnlyNumbers(String str) {
        return str.matches("[0-9]+");
    }

    public void createCourse(ChoiceBox<String> courseNameBox, ChoiceBox<String> lectureName) {

        if (lectureName.getValue() != null || courseNameBox.getValue() != null) {

           String courseName = courseNameBox.getValue();
            
            HashMap<Integer, String> NameHashMap = new HashMap<Integer, String>(model.getTeacherNameHashMap());
            String lectureSelected = lectureName.getValue();
            Set<String> courseAvailablSet = new HashSet<String>(model.getCourseAvailablSet());
            HashMap<Integer, ArrayList<String>> teacherAsignCourseHashMap = new HashMap<Integer, ArrayList<String>>(
                    model.getTeacherAsignCourseHashMap());

            HashMap<String, Integer> lectureRecordHashMap = new HashMap<String, Integer>(model.getLectureRecordHashMap());

            Integer foundKey = getKeyByValue(NameHashMap, lectureSelected);

            if (!courseAvailablSet.contains(courseName)) {
                if (foundKey != null) {
                    System.out.println("Key for value '" + lectureSelected + "': " + foundKey);
                    courseAvailablSet.add(courseName);
                    teacherAsignCourseHashMap.computeIfAbsent(foundKey, k -> new ArrayList<>()).add(courseName);
                    lectureRecordHashMap.put(courseName, foundKey);

                    model.setTeacherAsignCourseHashMap(teacherAsignCourseHashMap);
                    model.setCourseAvailablSet(courseAvailablSet);
                    model.setLectureRecordHashMap(lectureRecordHashMap);

                } else {
                    System.out.println("Value '" + lectureSelected + "' not found in the HashMap");
                }

                System.out.println("Course Name " + courseName);
                System.out.println("Lecture Name " + lectureName.getValue());
                System.out.println("Array " + teacherAsignCourseHashMap);
                view.errorMessenge("Course " + (courseName) + " Created Sucessfully", "Course Created");
            }

            else {
                view.errorMessenge("Course Existed", "Duplicate Course");
            }
        }

        else view.errorMessenge("Invalid Option", "Select a Lecture/Subject");


    }

    private static Integer getKeyByValue(HashMap<Integer, String> map, String value) {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        // If value is not found, return null
        return null;
    }

    public String[] populateLecureChoiceBox() {

        HashMap<Integer, String> TeacherNameHashMap = new HashMap<Integer, String>(model.getTeacherNameHashMap());

        int size = TeacherNameHashMap.size();

        String[] stringArray = new String[size];

        int index = 0;
        for (Integer key : TeacherNameHashMap.keySet()) {
            stringArray[index++] = TeacherNameHashMap.get(key);
        }

        return stringArray;

    }

    public String[] populateCourseChoiceBox() {

        Set<String> courseAvailablSet = new HashSet<String>(model.getCourseAvailablSet());
        int size = courseAvailablSet.size();
        String coursearray[] = new String[size];

        System.arraycopy(courseAvailablSet.toArray(), 0, coursearray, 0, size);
        String[] stringArray = coursearray;
        return stringArray;
    }


    public ArrayList<String> populateCourseCreatorChoiceBox() {

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("CS113");
        arrayList.add("CS123");
        arrayList.add("CS133");
        arrayList.add("CS143");
        arrayList.add("CS214");
        arrayList.add("CS224");
        arrayList.add("CS234");
        arrayList.add("CS316");
        return arrayList;
    }

    public String[] populateLectureCourseChoiceBox() {

        HashMap<Integer, ArrayList<String>> teacherAsignCourseHashMap = new HashMap<Integer, ArrayList<String>>(
                model.getTeacherAsignCourseHashMap());
        ArrayList<String> arrayList = teacherAsignCourseHashMap.get(model.currentUser);
        String[] stringArray = new String[arrayList.size()];
        stringArray = arrayList.toArray(stringArray);

        return stringArray;
    }

    public ObservableList<ModelTable> getTableAdmin() {
        ObservableList<ModelTable> table = FXCollections.observableArrayList();
        HashMap<Integer, String> teacherNameHashMap = new HashMap<Integer, String>(model.getTeacherNameHashMap());
        HashMap<Integer, String> studentNameHashMap = new HashMap<Integer, String>(model.getStudentNameHashMap());

        for (HashMap.Entry<Integer, String> entry : teacherNameHashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
            int id12 = entry.getKey();
            String name12 = entry.getValue();
            String course = "Lecture"; // this one for course, idk how to do
            table.add(new ModelTable(name12, id12, course));
        }

        for (HashMap.Entry<Integer, String> entry : studentNameHashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
            int id12 = entry.getKey();
            String name12 = entry.getValue();
            String course = "Student";
            table.add(new ModelTable(name12, id12, course));
        }

        return table;
    }

    public void addStudentSubjects(ChoiceBox<String> courseAdded) {
        HashMap<Integer, Set<String>> studentAsignCourseHashMap = new HashMap<Integer, Set<String>>(
                model.getStudentRecordHashMap());
        HashMap<String, Set<Integer>> courseAssignStudentHashMap = new HashMap<String, Set<Integer>>(
                model.getSubjectRecordHashMap());
        String course = courseAdded.getValue();

       if (courseAdded.getValue() != null){
            addToHashMap(courseAssignStudentHashMap, course, model.currentUser);
            addToHashMapStudent(studentAsignCourseHashMap, model.currentUser, course);

            model.setStudentRecordHashMap(studentAsignCourseHashMap);
            model.setSubjectRecordHashMap(courseAssignStudentHashMap);
            view.errorMessenge("Sucessfully Registered for " + course, "Register Sucess");

            System.out.println("Student Record" + studentAsignCourseHashMap);

            System.out.println("Course Recoed" + courseAssignStudentHashMap);
       }

       else view.errorMessenge("Select a Subject", "Select a Subject");

    }

    private static void addToHashMap(HashMap<String, Set<Integer>> hashMap, String key, int value) {
        hashMap.putIfAbsent(key, new HashSet<>());

        Set<Integer> set = hashMap.get(key);
        set.add(value);
    }

    private static void addToHashMapStudent(HashMap<Integer, Set<String>> hashMap, int key, String value) {
        hashMap.putIfAbsent(key, new HashSet<>());

        Set<String> set = hashMap.get(key);
        set.add(value);
    }

    public ObservableList<ModelTable> tableLectureSelectedCourse(ChoiceBox<String> selectedSubject) {
        ObservableList<ModelTable> tableLecture = FXCollections.observableArrayList();

        HashMap<String, Set<Integer>> subjectRecordHashMap = new HashMap<String, Set<Integer>>(
                model.getSubjectRecordHashMap());
        HashMap<Integer, String> studentNameHashMap = new HashMap<Integer, String>(model.getStudentNameHashMap());
        String selectedSubjectString = selectedSubject.getValue();

        Set<Integer> integerSet = subjectRecordHashMap.get(selectedSubjectString);

        for (int element : integerSet) {
            // Store the current element in a variable
            int currentValue = element;
            String name = studentNameHashMap.get(currentValue);
            tableLecture.add(new ModelTable(name, currentValue, "0"));

            System.out.println(name);
            System.out.println(currentValue);

        }

        return tableLecture;
    }

    public ObservableList<ModelTable> tableAdminSelectedCourse(ChoiceBox<String> selectedSubject) {

        ObservableList<ModelTable> tableLecture = FXCollections.observableArrayList();

        HashMap<String, Set<Integer>> subjectRecordHashMap = new HashMap<String, Set<Integer>>(
                model.getSubjectRecordHashMap());
        HashMap<Integer, String> studentNameHashMap = new HashMap<Integer, String>(model.getStudentNameHashMap());
        HashMap<String, Integer> lectureRecordHashMap = new HashMap<String, Integer>(model.getLectureRecordHashMap());
        HashMap<Integer, String> lectureNameHashMap = new HashMap<Integer, String>(model.getTeacherNameHashMap());

        String selectedSubjectString = selectedSubject.getValue();
        Set<Integer> integerSet = subjectRecordHashMap.get(selectedSubjectString);

        Integer lectureId = lectureRecordHashMap.get(selectedSubjectString);
        String lecturename = lectureNameHashMap.get(lectureId);

        tableLecture.add(new ModelTable(lecturename, lectureId, "Lecture"));

        for (int element : integerSet) {
            // Store the current element in a variable
            int currentValue = element;
            String name = studentNameHashMap.get(currentValue);
            tableLecture.add(new ModelTable(name, currentValue, "Student"));

            System.out.println(name);
            System.out.println(currentValue);
        }

        return tableLecture;

    }

    public void checkMinCourseWork(){

        HashMap<Integer, Integer> studentCreditHashMap = new HashMap<Integer, Integer>(model.getStudentCreditHashMap());
        
        Integer courseworkHour = studentCreditHashMap.get(model.currentUser);

        if(courseworkHour < 3){
            view.errorMessenge("Not enough Credit ", "Please Enroll to More Classes");
        }

        else return;

    }
}
