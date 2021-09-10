public class Registration {
    
    private Student student;
    private CourseOffering courseOffering;
    private char grade;

    public Registration(Student student, CourseOffering courseOffering) {
        this.student = student;
        this.courseOffering = courseOffering;
    }
    

    public void addRegistration(Registration reg){
        student.addRegistration(this);
    }

    
}
