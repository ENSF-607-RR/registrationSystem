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

    public void register(CourseCatalogue catalogue, String courseName, String courseNumber, int secNum){
        
        Course myCourse = catalogue.searchCatalogue(courseName, courseNumber);

        if (myCourse == null){
            return;
        }

        // if the course exists, look at the section
        CourseOffering offering = myCourse.searchOfferings(secNum);
        Registration reg = new Registration(this, offering);
        addRegistration(reg);
        //reg.addRegistration();
    }

    public void addRegistration(Registration reg){
        courseList.add(reg);
    }

    public void listCourses(){
        
        for(Registration r: courseList){
            //System.out.println(r.getCourseOffering());
            System.out.println(r.getCourseOffering().getTheCourse());
        }
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

}
