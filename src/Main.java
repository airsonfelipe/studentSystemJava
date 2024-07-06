import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static class Student {
        String name;
        int ID;
        int age;
        int grade;

        public Student(String name, int ID, int age, int grade) {
            this.name = name;
            this.ID = ID;
            this.age = age;
            this.grade = grade;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", ID=" + ID +
                    ", age=" + age +
                    ", grade=" + grade +
                    '}';
        }
    }

    static class StudentSystem {
        private static final Map<Integer, Student> studentsystem = new HashMap<>();
        private static int totalStudents = 0;

        public StudentSystem() {
            // Pre-adding 10 students to the system
            addStudent(new Student("Airson Felipe Rodrigues Marta", 202401, 34, 10));
            addStudent(new Student("Juliana Roque da Silva", 202402, 28, 8));
            addStudent(new Student("Victor Bolo Fofo", 202403, 27, 5));
            addStudent(new Student("Mariana Dirce", 202404, 27, 7));
            addStudent(new Student("Jesse Chule", 202405, 31, 4));
            addStudent(new Student("Suelen Palestrinha", 202406, 29, 10));
            addStudent(new Student("Ingrid Casarotinho", 202407, 25, 5));
            addStudent(new Student("Carlos Feio", 202408, 30, 8));
            addStudent(new Student("Carol Putanhesca", 202409, 28, 4));
            addStudent(new Student("Luizito Soares", 202410, 36, 6));
        }

        public void addStudent(Student student) {
            if (studentsystem.containsKey(student.ID)) {
                System.out.println("This student already exists: " + studentsystem.get(student.ID));
                System.out.println(" ");
            } else {
                studentsystem.put(student.ID, student);
                totalStudents++;
                System.out.println("Student added successfully.");
                System.out.println(" ");
            }
        }

        public void updateStudent(int ID, String newName, int newAge, int newGrade) {
            if (studentsystem.containsKey(ID)) {
                Student student = studentsystem.get(ID);
                student.name = newName;
                student.age = newAge;
                student.grade = newGrade;
                System.out.println("Student updated successfully.");
                System.out.println(" ");
            } else {
                System.out.println("Student with ID " + ID + " not found.");
                System.out.println(" ");
            }
        }

        public void viewStudent(int ID) {
            if (studentsystem.containsKey(ID)) {
                System.out.println(studentsystem.get(ID));
            } else {
                System.out.println("Student with ID " + ID + " not found.");
                System.out.println(" ");
            }
        }

        public void listStudents() {
            if (studentsystem.isEmpty()) {
                System.out.println("No students in the system.");
                System.out.println(" ");
            } else {
                for (Student student : studentsystem.values()) {
                    System.out.println(student);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentSystem studentSystem = new StudentSystem();

        while (true) {
            System.out.println("Administrator Interface:");
            System.out.println("1. Add new student");
            System.out.println("2. Update student information");
            System.out.println("3. View student details");
            System.out.println("4. List all students");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    int ID = scanner.nextInt();
                    System.out.print("Enter student age: ");
                    int age = scanner.nextInt();
                    System.out.print("Enter student grade: ");
                    int grade = scanner.nextInt();
                    studentSystem.addStudent(new Student(name, ID, age, grade));
                    break;
                case 2:
                    System.out.print("Enter student ID to update: ");
                    ID = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new age: ");
                    int newAge = scanner.nextInt();
                    System.out.print("Enter new grade: ");
                    int newGrade = scanner.nextInt();
                    studentSystem.updateStudent(ID, newName, newAge, newGrade);
                    break;
                case 3:
                    System.out.print("Enter student ID to view: ");
                    ID = scanner.nextInt();
                    studentSystem.viewStudent(ID);
                    break;
                case 4:
                    studentSystem.listStudents();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
