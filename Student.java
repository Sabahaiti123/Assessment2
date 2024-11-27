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
    private String studentID;
    private double mark1;
    private double mark2;
    private double mark3;
    private double totalMarks;
    
    /**
     * Contructor for objects of class Student
     */
    public Student(String lastName, String firstName, String studentID, double mark1, double mark2, double mark3){
        
        this.lastName = lastName;
        this.firstName = firstName;
        this.studentID = studentID;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
        
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
    
    public String getStudentID(){
        return studentID;
    }
    
    public double getTotalMarks(){
        return mark1 + mark2 + mark3;
    }
    
    @Override
    public String toString(){
        return lastName + " " + firstName + " (" + studentID + ") - Total Marks: " + totalMarks;
    }
}
