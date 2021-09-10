import java.util.ArrayList;

public class Student {

    private String studentName;
    private int studentID;
    private ArrayList<Registration> courseList;

    public Student(String studentName, int studentID){
        this.setStudentName(studentName);
        this.setStudentID(studentID);
        courseList = new ArrayList <Registration>();
    }


    public String getStudentName() {
        return this.studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentID() {
        return this.studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void register(CourseCatalogue catalogue, String courseName, String courseNumber, int secNum){
        
        Course myCourse = catalogue.searchCatalogue(courseName, courseNumber);

        if (myCourse == null){
            return;
        }
        // if the course exists, look at the section
        CourseOffering offering = myCourse.getOfferingList().get(secNum - 1); // must fix this!!
        Registration reg = new Registration(this, offering);
        addRegistration(reg);

    }


    public void addRegistration(Registration reg){
        if(courseList.size() < 6){
            courseList.add(reg);
        }
    }

}
