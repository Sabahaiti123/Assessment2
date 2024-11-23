
/**
 * Write a description of class Student here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Student
{
    // Define a class to represent a student
    private String lastName;
    private String firstName;
    private int studentID;
    private double[] marks;
    private double totalMarks;
    
    /**
     * Contructor for objects of class Student
     */
    public Student(String lastName, String firstName, int studentID, double[] marks){
        
        this.lastName = lastName;
        this.firstName = firstName;
        this.studentID = studentID;
        this.marks = marks;
        this.totalMarks = 0;
        
        for (double mark : marks){
            
            this.totalMarks += mark;
            
        }
    }
    
    /**
     * methods to access the properties
     */
    public String getlastName(){
        return lastName;
    }
    
    public String getfirstName(){
        return firstName;
    }
    
    public int getStudentID(){
        return studentID;
    }
    
    public double getTotalMarks(){
        return totalMarks;
    }
    
    /**
     * Method to display the student information
     */
    public void displayStudentInfo(){
        System.out.println(lastName + " " + firstName + " (" + studentID + ") - Total Marks: " + totalMarks);
    }
}
