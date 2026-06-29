import java.util.ArrayList;

public class StudentManager {
    // Using an ArrayList as our in-memory database
    private ArrayList<Student> studentList;

    // Constructor
    public StudentManager() {
        this.studentList = new ArrayList<>();
    }

    // 1. CREATE: Add a new student
    public void addStudent(Student student) {
        if (searchStudent(student.getId()) != null) {
            System.out.println("[ERROR] Student with ID " + student.getId() + " already exists.");
            return;
        }
        studentList.add(student);
        System.out.println("[SUCCESS] Student added successfully!");
    }

    // 2. READ: Search for a student by ID
    public Student searchStudent(String id) {
        for (Student student : studentList) {
            if (student.getId().equalsIgnoreCase(id)) {
                return student; 
            }
        }
        return null; 
    }

    // 3. UPDATE: Update an existing student's details
    public boolean updateStudent(String id, String newName, int newAge) {
        Student student = searchStudent(id);
        if (student != null) {
            student.setName(newName);
            student.setAge(newAge);
            System.out.println("[UPDATE] Student updated successfully!");
            return true;
        }
        System.out.println("[ERROR] Student with ID " + id + " not found.");
        return false;
    }

    // 4. DELETE: Remove a student by ID
    public boolean deleteStudent(String id) {
        Student student = searchStudent(id);
        if (student != null) {
            studentList.remove(student);
            System.out.println("[DELETE] Student removed successfully!");
            return true;
        }
        System.out.println("[ERROR] Student with ID " + id + " not found.");
        return false;
    }

    // 5. READ ALL: Display all students in the database
    public void displayAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("[EMPTY] The student database is currently empty.");
            return;
        }
        
        System.out.println("\n--- Student List ---");
        for (Student student : studentList) {
            System.out.println(student); 
        }
        System.out.println("--------------------");
    }
}