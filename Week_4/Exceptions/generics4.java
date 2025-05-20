
import java.util.List;

// Abstract base class
abstract class CourseType {
    public abstract String getType();
}

// Subclasses
class ExamCourse extends CourseType {
    public String getType() {
        return "Exam-Based";
    }
}

class AssignmentCourse extends CourseType {
    public String getType() {
        return "Assignment-Based";
    }
}

class ResearchCourse extends CourseType {
    public String getType() {
        return "Research-Based";
    }
}

// Generic Course class
class Course<T extends CourseType> {
    private String courseName;
    private T courseType;

    public Course(String courseName, T courseType) {
        this.courseName = courseName;
        this.courseType = courseType;
    }

    public void display() {
        System.out.println("Course: " + courseName + ", Type: " + courseType.getType());
    }
}

// Utility class
class CourseManager {
    public static void displayAllCourses(List<? extends CourseType> courseList) {
        for (CourseType course : courseList) {
            System.out.println("Course Type: " + course.getType());
        }
    }
}

// Main to test
public class UniversitySystem {
    public static void main(String[] args) {
        Course<ExamCourse> math = new Course<>("Mathematics", new ExamCourse());
        Course<AssignmentCourse> cs = new Course<>("Computer Science", new AssignmentCourse());
        Course<ResearchCourse> ai = new Course<>("Artificial Intelligence", new ResearchCourse());

        math.display();
        cs.display();
        ai.display();

