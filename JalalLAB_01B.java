// Name, ID, Section Number, Date
// Jalal Zainaddin, s202154790, 54, 09/03/2023
public class JalalLAB_01B {
    public static void main(String[] args) {

        //Student Exercise
        Student[] students = new Student[10];

        // for the next loop, we'll generate for each type of student  including their gpa and id randomly

        for (int i = 0; i < students.length; i++) {
            // Using Random method to generate number for id and gpa
            String id = "20"+((int) (Math.random() *10000));
            double gpa = Math.random()*4;

            // using Random method to create each type of students randomly
            if (Math.random() > 0.49)
                students[i] = new Undergraduate(id, gpa);
            else
                students[i] = new Graduate(id, gpa);

        }

        // using instanceOf to print the type that matches the object
        for (int i = 0; i < students.length; i++) {
            if (students[i] instanceof Undergraduate)
                System.out.println("Undergraduate  "+students[i].displayStudent());

            else if (students[i] instanceof Graduate)
                System.out.println("Graduate  "+students[i].displayStudent());

        }


    }
}

abstract class Student{
    private String id;
    private double gpa;

    Student(String id, double gpa){
        this.id = id;
        this.gpa = gpa;
    }
    // getters for id and gpa
    public String getId() {
        return id;
    }

    public double getGpa() {
        return gpa;
    }
    // abstract method to get status

    abstract String getStatus();
    // display students information method

    final String displayStudent(){
        return "ID>> " + this.getId() + ",  GPA>> " + String.format("%.2f",this.getGpa()) + ",  Status>> " + getStatus();
    }
}
class Graduate extends Student{

    Graduate(String id, double gpa){
        super(id,gpa);
    }
    // overriding getStatus for Graduate
    // using ternary operator because we only have two conditions
    @Override
    String getStatus() {
        return this.getGpa() > 3 ? "good":"probation";
    }
}
class Undergraduate extends Student{

    Undergraduate(String id, double gpa){
        super(id,gpa);
    }
    // overriding getStatus for Undergraduate
    @Override
    String getStatus() {
        if (this.getGpa() > 3)
            return "honor";
        else if(this.getGpa() > 2)
            return "good";
        else
            return "probation";

    }

}