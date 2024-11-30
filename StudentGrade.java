import java.util.ArrayList;
import java.io.*;
import java.util.Comparator;
/**
 * Write a description of class StudentGrade here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StudentGrade implements StudentData {
    private ArrayList<Student> students = new ArrayList<>();
    private String unitName;
    
    @Override
    public void readFromFile(String filename) throws IOException{
        try (BufferedReader reader = new BufferedReader(new FileReader("/Users/sandysweet/Desktop/prog5001_students_grade_2022 .csv"))){
            String line = reader.readLine();
            unitName = line; // First line should be the unit name.
            reader.readLine(); //Skip the header or empty line.
            int lineNumber = 0;
            while((line = reader.readLine()) != null){
                lineNumber++;
                if(line.startsWith("#") || line.trim().isEmpty())
                continue; //Skip commits and empty lines
                String[] parts = line.split(",");
                if (parts.length == 6){
                    try{
                        String lastName = parts[0].trim();
                        String firstName = parts[1].trim();
                        String studentID = parts[2].trim();
                        double assignment1 = Double.parseDouble(parts[3].trim());
                        double assignment2 = Double.parseDouble(parts[4].trim());
                        double assignment3 = Double.parseDouble(parts[5].trim());
                        students.add(new Student(lastName, firstName, studentID, assignment1, assignment2, assignment3));
                    } catch(NumberFormatException e){
                        System.out.println("Skipping empty line" + lineNumber + ":" + e.getMessage());
                    }
                }else{
                    System.out.println("Incorrect data format on line" + lineNumber);
                }
            }
        }
    }
    
    /**
     * Display all student information, starting with the unit name.
     */
    @Override
    public void displayAllStudents(){
        System.out.println(unitName);
        for(Student student : students){
            student.displayStudentInfo();
        }
    }
    
    /**
     * Filters and display studensts whose total marks are below a specified threshold.
     */
    @Override
    public void filterStudentsByThreshold(double threshold){
        System.out.println("Students with total marks below " + threshold + ":");
        for(Student student : students){
            if(student.getTotalMarks() < threshold){
                student.displayStudentInfo();
            }
        }
    }
    
    /**
     * Sorts the students by total marks and display the top 5 and bottom 5 student.
     */
    @Override
    public void sortAndDisplayTopAndBottomStudents() {
        if (students.size() < 5){
            System.out.println("Not enough students to display top and bottom five.");
            return;
        }
        
        students.sort(Comparator.comparingDouble(Student :: getTotalMarks));
        
        System.out.println("Top 5 students with the highest marks: ");
        for (int i = students.size() - 1; i >= students.size() -5; i--){
            students.get(i).displayStudentInfo();
        }
        
        System.out.println("Top 5 students with the lowest marks: ");
        for (int i = 0; i < 5; i++){
            students.get(i).displayStudentInfo();
        }
    }
    
}
