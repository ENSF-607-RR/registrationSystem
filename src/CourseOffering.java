import java.util.*;

public class CourseOffering {
    
    private int sectionNum;
    private int sectionCap;
    private Course theCourse;
    private ArrayList<Registration> studentList;

    public CourseOffering(int sectionNum, int sectionCap){
        
        this.setSectionCap(sectionCap);
        this.setSectionNum(sectionNum);
        studentList = new ArrayList <Registration>();
        
    }   

    // add a registration to offering's student list
    public void addRegistration(Registration reg){
        studentList.add(reg);

        // warning if not enough students are registed
        if(studentList.size() < 8){
            System.out.println("WARNING: Course has " + studentList.size() +
                                 " student(s) registered, but it requires at least 8 to run. Course may not be offered.");
        }
    }

    public void removeRegistration(Registration reg){
        studentList.remove(reg);
    }

    public int getSectionNum() {
        return this.sectionNum;
    }

    public void setSectionNum(int sectionNum) {
        this.sectionNum = sectionNum;
    }

    public int getSectionCap() {
        return this.sectionCap;
    }

    public void setSectionCap(int sectionCap) {
        this.sectionCap = sectionCap;
    }

    public Course getTheCourse() {
        return this.theCourse;
    }

    public void setTheCourse(Course theCourse) {
        this.theCourse = theCourse;
    }

    public String toString(){
        StringBuffer buffer = new StringBuffer();
        
        buffer.append("Section Number: " + getSectionNum() + "\n");
        buffer.append("Section Capacity: " + getSectionCap() + "\n");

        return buffer.toString();
    }

}
