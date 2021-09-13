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

        for (Course c : imaginaryDB){
            c.addPreReq(new Course("ENGG", "101"));
            c.addPreReq(new Course("ENSF", "592"));
        }

        for (Course c: imaginaryDB){

            c.addCourseOffering(new CourseOffering(1, 80));
            c.addCourseOffering(new CourseOffering(2, 90));
            c.addCourseOffering(new CourseOffering(3, 100));
        }
        
        return imaginaryDB;
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

    public void listCourses(){
        System.out.println(this);
    }

    public String toString(){
        StringBuffer buffer = new StringBuffer();

        for(Course c : courseList){
            buffer.append(c);
        }

        return buffer.toString();
    }
}
