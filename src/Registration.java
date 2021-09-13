public class Registration {
    
    private Student student;
    private CourseOffering courseOffering;
    private char grade;

    public Registration(Student student, CourseOffering courseOffering) {
        
        this.student = student;
        this.courseOffering = courseOffering;
        addRegistration();
    }
    

    public void addRegistration(){
        student.addRegistration(this);
        courseOffering.addRegistration(this);
    }
    

    public Student getStudent() {
        return this.student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public CourseOffering getCourseOffering() {
        return this.courseOffering;
    }

    public char getGrade() {
        return this.grade;
    }
}
