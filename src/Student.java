import java.util.ArrayList;

public class Student {

    private String studentName;
    private int studentID;
    private ArrayList<Registration> regList;

    public Student(String studentName, int studentID){
        
        setStudentName(studentName);
        setStudentID(studentID);
        setRegList(new ArrayList<Registration>());
    }

    public void register(CourseCatalogue catalogue, String courseName, String courseNumber, int secNum){
        
        Course myCourse = catalogue.searchCatalogue(courseName, courseNumber);

        if (myCourse == null){
            System.out.println("ERROR: Course not found.");
            return;
        }

        // if the course exists, look at the section
        CourseOffering offering = myCourse.searchOfferings(secNum);
        Registration reg = new Registration();

        // initiate student - offering connection
        reg.register(this, offering);;
    }

    // adds a registration to the students registration list
    public void addRegistration(Registration reg){
        regList.add(reg);
    }

    // removes student from registration
    public void unregister(String courseName, String courseNumber, int secNum){

        Registration reg = searchRegList(courseName, courseNumber, secNum);

        // registration not found
        if(reg == null){
            return;
        }

        reg.unregister(this, reg.getOffering());;
    }

    // searches students course list for registration
    private Registration searchRegList(String courseName, String courseNumber, int secNum){
        // check if student is registered for course
        for(Registration r: regList){
            if(r.getOffering().getTheCourse().getCourseName().equals(courseName) && 
            r.getOffering().getTheCourse().getCourseNumber().equals(courseNumber) &&
            r.getOffering().getSectionNum() == secNum){
                return r;
            }
        }

        System.out.println("ERROR: Student not registered.");
        return null;
    }

    // removes registration for students course list
    public void removeRegistration(Registration reg) {
        regList.remove(reg);
    }

    // lists a students courses
    public void listCourses(){
        
        for(Registration r: regList){
            System.out.print(r.getOffering().getTheCourse());
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


    public ArrayList<Registration> getCourseList() {
        return this.regList;
    }

    public void setRegList(ArrayList<Registration> courseList) {
        this.regList = courseList;
    }


}
