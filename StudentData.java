import java.io.*;
/**
 * Write a description of interface StudentData here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface StudentData{
    //Read data from a specified file
    void readFromFile(String filename) throws IOException;
    
    void displayAllStudents();
    
    void filterStudentsByThreshold(double threshold);
    
    void sortAndDisplayTopAndBottomStudents();
}
