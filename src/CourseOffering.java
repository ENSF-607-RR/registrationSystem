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


}
