import java.util.ArrayList;

/**
 * Class to represent a database of students
 */
public class StudentDB {

    private ArrayList<Student> studentList;
    
    public StudentDB(){
        
        studentList = loadDB();
    }

    private  ArrayList<Student> loadDB() {

        ArrayList<Student> imagainaryStudentDB = new ArrayList<Student>();

        // create imaginary students
        imagainaryStudentDB.add(new Student("Holly", 1));
        imagainaryStudentDB.add(new Student("Jane", 2));
        imagainaryStudentDB.add(new Student("Thomas", 3));
        imagainaryStudentDB.add(new Student("Ron", 4));
        imagainaryStudentDB.add(new Student("Randy", 5));
        imagainaryStudentDB.add(new Student("Aarom", 6));
        imagainaryStudentDB.add(new Student("Jessica", 7));
        imagainaryStudentDB.add(new Student("Jon", 8));
        imagainaryStudentDB.add(new Student("Timothy", 9));
        imagainaryStudentDB.add(new Student("Karen", 10));       

        return imagainaryStudentDB;
    }   

    public Student searchDBforStudent(String studentName, int studentID){

        for(Student s: studentList){
            if(s.getStudentName().equals(studentName) && 
                s.getStudentID() == studentID){
                return s;
            }
        }
        
        System.out.println("ERROR: Student not found.");
        return null;
    }


    
}
