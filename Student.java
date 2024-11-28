/**
 * Write a description of class Student here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Student {
    // Define a class to represent a student
    private String lastName;
    private String firstName;
    private String studentID;
    private double assignment1;
    private double assignment2;
    private double assignment3;
    private double totalMarks;
    
    /**
     * Contructs a Student object with specified details.
     */
    public Student(String lastName, String firstName, String studentID, double assignment1, double assignment2, double assignment3){
        
        this.lastName = lastName;
        this.firstName = firstName;
        this.studentID = studentID;
        this.assignment1 = assignment1;
        this.assignment2 = assignment2;
        this.assignment3 = assignment3;
        this.totalMarks = assignment1 + assignment2 + assignment3; //Calculate the total marks
        
    }
    
    /**
     * methods for retrieving student details
     */
    public String getLastName(){
        return lastName;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public String getStudentID(){
        return studentID;
    }
    
    public double getAssignment1(){
        return assignment1;
    }
    
    public double getAssignment2(){
        return assignment2;
    }
    
    public double getAssignment3(){
        return assignment3;
    }
    
    public double getTotalMarks(){
        return totalMarks;
    }
    
    public void displayStudentInfo(){
        System.out.println(lastName + " " + firstName + "(" + studentID + ") " + "Marks: A1=" + assignment1 + ", A2=" + assignment2 + ", A3=" + assignment3 + ", Total=" + totalMarks);
    }
}
