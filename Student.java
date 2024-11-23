
/**
 * Write a description of class Student here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Student
{
    private String name;
    private String studentID;
    private double assignment1;
    private double assignment2;
    private double assignment3;
    private double totalMarks;
    
    /**
     * Contructor for objects of class Student
     */
    public Student(String name, String studentID, double assignment1, double assignment2, double assignment3){
        this.name = name;
        this.studentID = studentID;
        this.assignment1 = assignment1;
        this.assignment2 = assignment2;
        this.assignment3 = assignment3;
        this.totalMarks = assignment1 + assignment2 + assignment3;
    }
    
    // Method to display the student information
    /**
     * Method to display the student information
     */
    public void displayStudentInfo(){
        System.out.println();
    }
}
