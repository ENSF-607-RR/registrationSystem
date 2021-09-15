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

    // method to register a student in a course
    public void register(CourseCatalogue catalogue, String courseName, String courseNum, int secNum){
        
        // student is already registered in 6 courses
        if(regList.size() > 6){
            System.out.println("ERROR: Student registration is max.");
            return;
        }

        Course myCourse = catalogue.searchCatalogue(courseName, courseNum);

        if (myCourse == null){
            System.out.println("ERROR: Course not found.");
            return;
        }

        // if the course exists, look at the section
        CourseOffering offering = myCourse.searchOfferings(secNum);
        Registration reg = new Registration();
        reg.register(this, offering);;
        System.out.println("Student regeistered.");
    }

    // adds a registration to the students registration list
    public void addRegistration(Registration reg){
        regList.add(reg);
    }

    // removes student from registration
    public void unregister(String courseName, String courseNum, int secNum){

        Registration reg = searchRegList(courseName, courseNum, secNum);

        // registration not found
        if(reg == null){
            return;
        }

        reg.unregister(this, reg.getOffering());
        System.out.println("Student unregistered.");
    }

    // searches students course list for registration
    private Registration searchRegList(String courseName, String courseNum, int secNum){
        
        for(Registration r: regList){
            // student is registered for course
            if(r.getOffering().getTheCourse().getCourseName().equals(courseName) && 
                r.getOffering().getTheCourse().getCourseNum().equals(courseNum) &&
                r.getOffering().getSectionNum() == secNum){ // fix this if statement
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
            System.out.print(r);
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
