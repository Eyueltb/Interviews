package interviews;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Relationships
 * Association: is a general binary relationship that describes an activity between two classes.
 * Association
 * Aggregation
 * Composition
 * Inheritance
 */
public class ClassRelationships {

    public static void main(String[] args) {
        Course course1 = new Course("Data Structure");
        Course course2 = new Course("Database System");
        Student beza = new Student("Beza");
        Student jafer = new Student("Jafer");
        Student dawit = new Student("Dawit");
        course1.addStudent(beza);
        course1.addStudent(jafer);
        course2.addStudent(dawit);
        dawit.addCourse(course1);
        dawit.addCourse(course2);
        System.out.println("Before course drop " + dawit.getName());
        dawit.getCourseList().stream().forEach(System.out::print);
        dawit.dropCourse(course2);
        System.out.println("\n" + "After course drop " + dawit.getName());
        dawit.getCourseList().stream().forEach(System.out::print);
        System.out.println("\n" + "Students in " + course1.getName());
        course1.getStudents().stream().forEach(System.out::print);
    }
}

/**
 *
 */

@Data
class Student {
    private String name;
    private List<Course> courseList = new ArrayList<>();

    public Student(String name) { this.name = name; }
    public void addCourse(Course course) {
        courseList.add(course);
    }
    public void dropCourse(Course course) {
        courseList.remove(course);
    }
}

@Data
class Course {
    private String name;// course name
    private List<Student> students = new ArrayList<>();
    private Faculty faculty;

    public Course(String name) {
        this.name = name;
    }
    public void addStudent(Student s) { }

    public void setFaculty(Faculty faculty) {}

    public void dropStudent(Student student) {}

}

@Data @AllArgsConstructor
class Faculty {
    private List<Course> courseList = new ArrayList<>();

    public void addCourse(Course c) {}

    public void dropCourse(Course c) {}
}

/**
 * Composition(has-a)- strong relationship because containing object owns it.
 * If owner object is destroyed, its members also destroyed
 * Example- Building and Room has composition relationship
 */

class Building {
    private String name;
    private String address;
    private List<Room> rooms;

    public Building(String name, String address) {
        this.name = name;
        this.address = address;
        rooms = new ArrayList<Room>();
    }

    public void  addRoom(Room room){
        this.rooms.add(room);
    }
    public boolean  remove(Room room){
        return this.rooms.remove(room);
    }
    @Data @AllArgsConstructor
    class Room {
        private String name;
        private int numberOfRooms;
        private String owner;
        private int floorNumber;

        String getBuildingAddress() { return  Building.this.address; }
    }
}
