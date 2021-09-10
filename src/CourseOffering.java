import java.util.*;

public class CourseOffering {
    
    private String courseName;
    private String courseNumber;
    private String prof;
    private String assistant;
    private ArrayList<Registration> classList;

    public CourseOffering(String prof, String assistant){
        setProf(prof);
        setAssistant(assistant);
    }
    

    public ArrayList<Registration> getClassList() {
        return this.classList;
    }

    public void addStudent(Registration registrant){
        classList.add(registrant);
    }


    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(Course course) {
        this.courseName = course.getCourseName();
    }

    public String getCourseNumber() {
        return this.courseNumber;
    }

    public void setCourseNumber(Course course) {
        this.courseNumber = course.getCourseNumber();
    }

    public String getProf() {
        return this.prof;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }

    public String getAssistant() {
        return this.assistant;
    }

    public void setAssistant(String assistant) {
        this.assistant = assistant;
    }

}
