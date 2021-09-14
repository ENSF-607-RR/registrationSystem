import java.io.*;
import java.util.*;


public class CourseRegistrationApp {
    
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

    // method to create menu headers
    public static void generateHeader(String headerName){
        StringBuffer buffer = new StringBuffer();

        buffer.append("\n");
        buffer.append("*** ");
        buffer.append(headerName);
        buffer.append(" ***");
        buffer.append("\n");
        buffer.append("---------------------------------------");

        System.out.println(buffer.toString());
    }   

    // main menu
    public static void showSelectionMenu(){
        
        generateHeader("Main Menu");
        System.out.println("Enter:");
        System.out.println("1 - View the Course Catalogue"); 
        System.out.println("2 - Search the Course Catalogue"); 
        System.out.println("3 - Register for course");
        System.out.println("4 - Unregister for course");
        System.out.println("5 - View your registered courses"); 
        System.out.println("6 - Quit"); 
    }

    public static void main(String[] args){

        CourseCatalogue catalogue = new CourseCatalogue();
        StudentDB studentDB = new StudentDB();
        
        System.out.println("---------------------------------------");
        System.out.println("Course Registration App");
        System.out.println("---------------------------------------");

        // student login
        generateHeader("Student Login");
        Student student;

        while(true){
            System.out.print("Enter Student Name: ");
            String studentName = userInput();

            System.out.print("Enter Student ID: ");
            int studentID = Integer.parseInt(userInput());

            // search for student
            student = studentDB.searchDBforStudent(studentName, studentID);
            
            // student found
            if(student != null){
                break;
            }
        }

        while(true){
            showSelectionMenu();
            System.out.print("Input: ");
            String userSelection = userInput();

            switch(userSelection){
                // selection 1 - view catalogue
                case "1":

                    generateHeader("Course Catalogue");
                    catalogue.listCourses();
                    System.out.print("Press enter to return to menu.");
                    userInput();
                    break;
                    
                // selection 2 - search catalogue
                case "2":

                    generateHeader("Search Catalogue");
                    System.out.print("Enter course name: ");
                    String courseName = userInput();
                    System.out.print("Enter course number: ");
                    String courseNum = userInput();

                    Course course  = catalogue.searchCatalogue(courseName, courseNum);

                    // course not found
                    if(course == null){
                        break; 
                    }

                    // course found, list sections
                    System.out.println("Course found. Course Offerings: ");
                    course.listOfferingList();

                    // return to menu
                    System.out.print("Press enter to return to menu.");
                    userInput();
                    break;
    
                // register for course
                case "3":

                    generateHeader("Register for Courses");

                    // search for course
                    System.out.print("Enter Course Name: ");
                    courseName = userInput();
                    System.out.print("Enter Course Number: ");
                    courseNum = userInput();
                    System.out.print("Enter Course Section: ");
                    int secNum = Integer.parseInt(userInput());

                    // search catalogue
                    course = catalogue.searchCatalogue(courseName, courseNum);

                    // course not found
                    if(course == null){
                        break;
                    }

                    // search sections
                    CourseOffering offering = course.searchOfferings(secNum);

                    // offering not found
                    if(offering == null){
                        break;
                    }

                    // register the student
                    student.register(catalogue, courseName, courseNum, secNum);
                    System.out.println("Registration Succesful.");
                    break;

                // unregister from course
                case "4":
                    generateHeader("Unregister from course");

                    System.out.print("Enter Course Name: ");
                    courseName = userInput();
                    System.out.print("Enter Course Number: ");
                    courseNum = userInput();
                    System.out.print("Enter Course Section: ");
                    secNum = Integer.parseInt(userInput());
                    student.unregister(courseName, courseNum, secNum);
                    break;
                // view students courses
                case "5":

                    generateHeader(student.getStudentName() + "'s" + " Courses");
                    student.listCourses();
                    System.out.println("Press enter to return to menu.");
                    userInput();
                    break;
    
                // quit
                case "6":

                    System.exit(0);
                    break;
            }
        }
    }
}