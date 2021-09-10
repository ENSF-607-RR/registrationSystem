import java.util.ArrayList;

public class Course {

    private String courseName;
    private String courseNumber;
    private ArrayList<Course> prereqs;

    public Course (String courseName, String courseNumber){
        setCourseName(courseName);
        setCourseNumber(courseNumber);
    }
    
    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseNumber() {
        return this.courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public void addPrereq(Course prereq){
        prereqs.add(prereq);
    }

    public ArrayList<Course> getPrereqs(){
        return prereqs;
    }
}
