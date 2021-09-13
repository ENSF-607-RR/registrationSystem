import java.io.*;
import java.util.*;


public class CourseRegistrationApp {
    

    // method to create a database of students
    public static ArrayList<Student> loadFromDB(){
        
        ArrayList<Student> imagainaryStudentDB = new ArrayList<Student>();

        // create imaginary students
        imagainaryStudentDB.add(new Student("Jon", 1));
        imagainaryStudentDB.add(new Student("Jane", 2));
        imagainaryStudentDB.add(new Student("Thomas", 3));

        return imagainaryStudentDB;
    }

    // method to search for students in the db
    public static Student searchStudentDB(ArrayList<Student>studentDB,  String studentName, int studentID){
        
        for(Student s: studentDB){
            if(s.getStudentName().equals(studentName) && 
                s.getStudentID() == studentID){
                return s;
            }
        }       
        return null;
    }

    // method for user input
    public static String userInput(){
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        String input = null;
        try {
            input = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return input;
    }

    // login for student
    public static Student studentLogin(ArrayList<Student> studentDB){

        generateHeader("Student Login");
        Student student;

        while(true){
            System.out.print("Enter Student Name: ");
            String studentName = userInput();
    
            System.out.print("Enter Student ID: ");
            int studentID = Integer.parseInt(userInput());
    
            // search for student
            student = searchStudentDB(studentDB, studentName, studentID);

            if(student == null){
                System.out.println("Student not found. Please re-try. ");
            }
            else{
                break;
            }
        }

        System.out.println("Student found, logging in ...");
        return student;
    }
    
    // method to create menu headers
    public static String generateHeader(String headerName){
        StringBuffer buffer = new StringBuffer();

        buffer.append("\n");
        buffer.append("*** ");
        buffer.append(headerName);
        buffer.append(" ***");
        buffer.append("\n");
        buffer.append("---------------------------------------");

        return buffer.toString();
    }

    // main menu
    public static String selectionMenu(){
        
        System.out.println(generateHeader("Main Menu"));
        System.out.println("Enter:");
        System.out.println("1 - View the Course Catalogue"); 
        System.out.println("2 - Search the Course Catalogue"); 
        System.out.println("3 - Register for course");
        System.out.println("4 - Unregister for course");
        System.out.println("5 - View your registered courses"); 
        System.out.println("6 - Quit"); 

        System.out.print("Input: ");
        String input = userInput();

        return input;

    }

    // selection 1 - list cataglogue
    public static void showCatalogue(CourseCatalogue catalogue){
        
        // header
        System.out.println(generateHeader("Course Catalogue"));
        catalogue.listCourses();
        System.out.print("Press enter to return to menu.");
        userInput();
        return;
    }

    // selection 2 - search catalogue
    private static void searchCatalogue(CourseCatalogue catalogue) {

        // header
        System.out.println(generateHeader("Search Catalogue"));
        System.out.print("Enter course name: ");
        String courseName = userInput();
        System.out.print("Enter course number: ");
        String courseNum = userInput();

        Course course  = catalogue.searchCatalogue(courseName, courseNum);

        // course not found
        if(course == null){
            System.out.println("");
            System.out.println("Course not found. Returning to menu...");
            
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return;
        }

        System.out.println("");
        System.out.println("Course found. Course Offerings: ");

        // course found, list sections
        course.listOfferingList();

        // return to menu
        System.out.print("Press enter to return to menu.");
        userInput();
        return;
    }

    // selection 3 - register for course
    private static void registerForCourse(Student student, CourseCatalogue catalogue) {
        
        // header 
        System.out.println(generateHeader("Course Registration"));
        
        while(true){
            // search for course
            System.out.print("Enter Course Name: ");
            String courseName = userInput();
            System.out.print("Enter Course Number: ");
            String courseNum = userInput();
            System.out.print("Enter Course Section: ");
            int secNum = Integer.parseInt(userInput());

            // search catalogue
            Course course = catalogue.searchCatalogue(courseName, courseNum);
            // search sections
            CourseOffering offering = course.searchOfferings(secNum);

            if(course != null && offering != null){
                student.register(catalogue, courseName, courseNum, secNum);
                System.out.println("Registration Succesful.");
                break;
            }
        }

    }


    private static void unregisterFromCourse() {
    
    }


    private static void showStudentsCourses(Student student) {
        System.out.println(generateHeader(student.getStudentName() + "'s" + " Courses"));
        
        student.listRegistrations();
    }

    public static void main(String[] args){

        CourseCatalogue catalogue = new CourseCatalogue();
        
        System.out.println("---------------------------------------");
        System.out.println("Course Registration App");
        System.out.println("---------------------------------------");

        // student login
        ArrayList<Student> studentDB = loadFromDB();
        Student student;
        student = studentLogin(studentDB);

        while(true){

            String selection = selectionMenu();

            switch(selection){
                // view catalogue
                case "1":
                    showCatalogue(catalogue);
                    break;
                // search catalogue
                case "2":
                    searchCatalogue(catalogue);
                    break;
    
                // register for course
                case "3":
                    registerForCourse(student, catalogue);
                    break;
                // unregister from course
                case "4":
                    unregisterFromCourse();
    
                // view students courses
                case "5":
                    showStudentsCourses(student);
    
                // quit
                case "6":
                    System.exit(0);
                    break;
            }
        }
    }
}