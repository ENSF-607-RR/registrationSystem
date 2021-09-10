public class Registration {
    
    private Student student;
    private CourseOffering courseOffering;

    public Registration(Student student, CourseOffering courseOffering) {
        this.student = student;
        this.courseOffering = courseOffering;
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

    public void setCourseOffering(CourseOffering courseOffering) {
        this.courseOffering = courseOffering;
    }

    
}
