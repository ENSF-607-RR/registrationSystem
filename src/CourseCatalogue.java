import java.util.ArrayList;

public class CourseCatalogue {

    private ArrayList<Course> courseList;

    public CourseCatalogue(ArrayList<Course> courseList){
        this.courseList = courseList;
    }

    public ArrayList<Course> getCourseCatalogue(){
        return courseList;
    }
}
