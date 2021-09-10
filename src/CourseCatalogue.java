import java.util.ArrayList;

public class CourseCatalogue {

    private ArrayList <Course> courseList;

    public CourseCatalogue(){
        courseList = loadFromDB();
    }

    private static ArrayList<Course> loadFromDB(){
        // in RL courses will be loaded from the DB or files from disk
        ArrayList<Course> imaginaryDB = new ArrayList <Course>();

        imaginaryDB.add(new Course("ENGG", "233"));
        imaginaryDB.add(new Course("PHYS", "259"));
        imaginaryDB.add(new Course("ENSF", "607"));
        
        return imaginaryDB;
    }

    public static void createOffereing(){
        
    }

    public void listCourses(){
        System.out.println(this);
    }

    public Course searchCatalogue(String courseName, String courseNumber){
        for(Course c: courseList){
            // could override equals method in course
            if(c.getCourseName().equals(courseName) &&
                c.getCourseNumber().equals(courseNumber)){
                return c;
            }
        }
        return null;

    }

    public String toString(){
        StringBuffer buffer = new StringBuffer();

        for(Course c : courseList){
            buffer.append(c.toString());
        }

        return buffer.toString();
    }
}
