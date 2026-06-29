import java.util.ArrayList;

public class StudentManager {
    private ArrayList<Student> studentList;

    public StudentManager() {
        this.studentList = new ArrayList<>();
    }

    public void addStudent(Student student) {
        studentList.add(student);
        System.out.println("Student added successfully!");
    }

    public boolean deleteStudent(String id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId().equals(id)) {
                studentList.remove(i);
                return true;
            }
        }
        return false;
    }

    public Student searchStudent(String id) {
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    public boolean updateStudent(String id, String newName, int newAge) {
        Student student = searchStudent(id);
        if (student != null) {
            student.setName(newName);
            student.setAge(newAge);
            return true;
        }
        return false;
    }

    public void displayAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students found in the system.");
            return;
        }
        System.out.println("\n--- Student List ---");
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}