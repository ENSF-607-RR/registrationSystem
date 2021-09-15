public class Registration {
    
    private Student student;
    private CourseOffering offering;
    private char grade;

    // method to register a student in a course offering
    public void register (Student student, CourseOffering offering){
        
        setStudent(student);
        setOffering(offering);
        addRegistration();
    }
    
    // method to add registration to student and offering
    public void addRegistration(){
        student.addRegistration(this);
        offering.addRegistration(this);
    }

    // method to remove registration from student and offering
    public void unregister(Student student, CourseOffering offering){
        student.removeRegistration(this);
        offering.removeRegistration(this);
    }
    
    public Student getStudent() {
        return this.student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public CourseOffering getOffering() {
        return this.offering;
    }

    public void setOffering(CourseOffering offering){
        this.offering = offering;
    }

    public char getGrade() {
        return this.grade;
    }

    @Override
    public String toString(){
        StringBuffer buffer = new StringBuffer();
        buffer.append(this.getOffering().getTheCourse());
        buffer.append("Section Number: " + this.getOffering().getSectionNum() + "\n");

        return buffer.toString();

    }
}
