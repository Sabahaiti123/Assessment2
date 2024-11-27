import java.util.ArrayList;
import java.util.List;
/**
 * Write a description of class Course here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Course
{
    // Manages the course and its students
    private String courseName;
    private List<Student> students;
    
    public Course(String courseName){
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }
    
}
