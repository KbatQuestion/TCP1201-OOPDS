package Part2;

public class Student {
  private int id;
  private String name;
    
  public Student (int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return id;     
  }

  public String toString() {
    return id + " " + name;
  }

  public String toCSVString() {
    return id + "," + name;
  }
}
