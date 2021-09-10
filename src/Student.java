import java.util.ArrayList;

public class Student {

    private String firstName;
    private String lastName;
    private ArrayList<Registration> regCourses;

    public Student(String firstName, String lastName){
        setFirstName(firstName);
        setLastName(lastName);
    }
    

    public void register(Registration course){
        if(regCourses.size() < 6){
            regCourses.add(course);
        }
        else{
            //some error
        }
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
