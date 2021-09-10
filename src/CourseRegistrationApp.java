public class CourseRegistrationApp {
    

    public static void main(String[] args){
        CourseCatalogue catalogue = new CourseCatalogue();

        Student s1 = new Student("Jane", 1);
        Student s2 = new Student("Jon", 2);

        catalogue.listCourses();
    }
}
