import java.util.*;

public class CourseOffering {
    
    private int sectionNum;
    private int sectionCap;
    private Course theCourse;
    private ArrayList<Registration> studentList;

    public CourseOffering(int sectionNum, int sectionCap, Course theCourse){
        
        this.setSectionCap(sectionCap);
        this.setSectionNum(sectionNum);
        this.setTheCourse(theCourse);
        studentList = new ArrayList <Registration>();
        
    }   

    public void addRegistration(Registration reg){
        studentList.add(reg);
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

        buffer.append("Section Number: " + getSectionNum());
        buffer.append("\n");
        buffer.append("Section Capacity: " + getSectionCap());

        return buffer.toString();
    }

}
