import java.util.ArrayList;

public class Course {

    private String courseName;
    private String courseNum;
    private ArrayList<Course> preReqList;
    private ArrayList<CourseOffering> offeringList;

    public Course (String courseName, String courseNum){
        
        this.setCourseName(courseName);
        this.setcourseNum(courseNum);
        preReqList = new ArrayList<Course>();
        offeringList = new ArrayList<CourseOffering>();
    }

    public void listOfferingList(){
        
        for(CourseOffering o: offeringList){
            System.out.println(o);
        }
    }

    public CourseOffering searchOfferings(int sectionNum){

        for(CourseOffering offering: offeringList){
            if(offering.getSectionNum() == sectionNum){
                return offering;
            }
        }

        System.out.println("ERROR: Course offering not found.");

        return null;
    }

 
    public void addPreReq(Course preReq){
        
        preReqList.add(preReq);
    }

    public void addCourseOffering(CourseOffering offering){

        offeringList.add(offering);
    }
    
    public String getCourseName() {

        return this.courseName;
    }

    public void setCourseName(String courseName) {

        this.courseName = courseName;
    }

    public String getCourseNum() {

        return this.courseNum;
    }

    public void setcourseNum(String courseNum) {

        this.courseNum = courseNum;
    }

    public ArrayList<Course> getPreReq() {

        return this.preReqList;
    }

    public void setPreReq(ArrayList<Course> preReqList) {

        this.preReqList = preReqList;
    }

    public ArrayList<CourseOffering> getOfferingList() {
        return this.offeringList;
    }

    public void setOfferingList(ArrayList<CourseOffering> offeringList) {
        this.offeringList = offeringList;
    }

    @Override
    public String toString(){

        StringBuffer buffer = new StringBuffer();
        buffer.append(courseName + " " + courseNum + "\n");
        return buffer.toString();
    }

}
