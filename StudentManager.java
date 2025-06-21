import java.io.*;
import java.util.*;

class Student {
    String id, name;
    int marks;

    public Student(String id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public String toString() {
        return id + "," + name + "," + marks;
    }
}

public class StudentManager {
    static final String FILE = "students.txt";
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int choice;
        do {
            System.out.println("\n--- Student Record Manager ---");
            System.out.println("1. Add Student\n2. Show Students\n3. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: showStudents(); break;
                case 3: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid option.");
            }
        } while (choice != 3);
    }

    static void addStudent() throws IOException {
        System.out.print("Enter ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Marks: ");
        int marks = sc.nextInt();

        FileWriter fw = new FileWriter(FILE, true);
        fw.write(new Student(id, name, marks).toString() + "\n");
        fw.close();
        System.out.println("Student added.");
    }

    static void showStudents() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(FILE));
        String line;
        System.out.println("--- All Students ---");
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            System.out.println("ID: " + parts[0] + ", Name: " + parts[1] + ", Marks: " + parts[2]);
        }
        br.close();
    }
}
