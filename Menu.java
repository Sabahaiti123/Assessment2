import java.io.IOException;
import java.util.Scanner;
/**
 * This class allows users to read student data from a file, display all students, filter students by total marks,
 * display top and bottom 5 students based on their marks, and exit program.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Menu
{
    public static void main(String[] args){
        
        StudentData studentData = new StudentGrade();
        Scanner scanner = new Scanner(System.in);
        
        try{
            System.out.println("Enter the filename: ");
            String filename = scanner.nextLine(); // Read the filename from the user
            studentData.readFromFile("/Users/sandysweet/Desktop/Assessment2/prog5001_students_grade_2022 .csv");
            
            while(true){
                
                System.out.println("\n---Menu---");
                System.out.println("1. Display All Students");
                System.out.println("2. Filter Students by Threshold");
                System.out.println("3. Display Top and Bottom 5 Students");
                System.out.println("4. Exit");
                System.out.println("Enter choice");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the new line character left over
                
                switch(choice){
                    case 1:
                        studentData.displayAllStudents();
                        break;
                    
                    case 2:
                        System.out.print("Enter the threshold (0-100) for total marks: ");
                        double threshold = scanner.nextDouble();
                        scanner.nextLine(); // Consume new line
                        studentData.filterStudentsByThreshold(threshold);
                        break;
                    
                    case 3:
                        studentData.sortAndDisplayTopAndBottomStudents();
                        break;
                    
                    case 4:
                        System.out.println("Exiting...");
                        return; // Exiting the application
                    
                    default:
                        System.out.println("Invalid choice, please try again.");
                        
                }
            }
        } catch(IOException e){
            
            System.out.println("Error reading from file: " + e.getMessage());
            
        } finally{
            
            scanner.close(); // Close the scanner to free up resources
            
        }
    }
}
