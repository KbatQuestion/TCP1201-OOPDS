package Part2;

public class Lecturer {
    private int id;
    private String name;
    private String courseCode;

    public Lecturer(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId(){
        return id;
    }

    public String toString(){
        return id + " " + name;
    }

    public String toCSVFile(){
        return id + "," + name;
    }
}
