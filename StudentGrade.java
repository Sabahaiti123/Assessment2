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
        File file = new File("/Users/sandysweet/Desktop/prog5001_students_grade_2022.csv");
        // Use the filename provided as a parameter
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            int lineNumber = 0;
            reader.readLine();
            reader.readLine();
            
            while((line = reader.readLine()) != null){
                lineNumber++;
                if(line.startsWith("#") || line.isEmpty())
                continue; //Skip commits and empty lines
                
                if(unitName == null){
                    unitName = line;
                    continue;
                }
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
    
    private double parseDoubleSafe(String value, int lineNumber, String field) throws NumberFormatException{
        try{
            return Double.parseDouble(value);
        } catch (NumberFormatException e){
            throw new NumberFormatException("Error parsing numeric data on line" + lineNumber + "for" + field + ": " + value);
        }   
    }
    
    
    @Override
    public void displayAllStudents(){
        System.out.println("Unit: " + unitName);
        for(Student student : students){
            student.displayStudentInfo();
        }
    }
    
    @Override
    public void filterStudentsNyThreshold(double threshold){
        System.out.println("Students with total marks below " + threshold + ":");
        for(Student student : students){
            if(student.getTotalMarks() < threshold){
                student.displayStudentInfo();
            }
        }
    }
    
    public void sortAndDisplayTopAndBottomStudents() {
        students.sort(Comparator.comparingDouble(Student :: getTotalMarks));
        System.out.println("Top 5 students with the highest marks: ");
        int start = Math.max(students.size() -5, 0);
        for (int i = start; i<students.size(); i++){
            students.get(i).displayStudentInfo();
        }
        
        System.out.println("Top 5 students with the lowest marks: ");
        int end = Math.max(5, students.size());
        for (int i = 0; i < end; i++){
            students.get(i).displayStudentInfo();
        }
    }
    
}
