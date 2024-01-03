package Part1;

public class ModelTable {

    private String name;
    private int id;
    private String course;


    public ModelTable(){
        this.name = "";
        this.id = 0;
        this.course = "";

    }

    public ModelTable (String name, int id, String course){
        this.name = name;
        this.id = id;
        this.course = course;

    }

    public String getName(){
        return name;

    }

    public void setName (String name){
        this.name =name;
    }

    public double getId(){
        return id;
    }

    public void setId (Integer id){
        this.id =id;
    }

    public String getCourse(){
        return course;

    }

    public void setCourse (String course){
        this.course =course;
    }

   
    




    
}
