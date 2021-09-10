import java.util.ArrayList;

public class Course {

    private String courseName;
    private String courseNumber;
    private ArrayList<Course> preReq;
    private ArrayList<CourseOffering> offeringList;

    public Course (String courseName, String courseNumber){
        this.setCourseName(courseName);
        this.setCourseNumber(courseNumber);
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


    public ArrayList<Course> getPreReq() {
        return this.preReq;
    }

    public void setPreReq(ArrayList<Course> preReq) {
        this.preReq = preReq;
    }

    public ArrayList<CourseOffering> getOfferingList() {
        return this.offeringList;
    }

    public void setOfferingList(ArrayList<CourseOffering> offeringList) {
        this.offeringList = offeringList;
    }

    @Override
    public String toString(){
        return courseName + " " + courseNumber + "\n"; 
    }

}
