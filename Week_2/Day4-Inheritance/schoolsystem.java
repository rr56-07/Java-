package Inheritance;

class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayBasicInfo() {
        System.out.println("Name : " + name);
        System.out.println("Age  : " + age);
    }
}

class Teacher extends Person {
    private String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    public void displayRole() {
        displayBasicInfo();
        System.out.println("Role    : Teacher");
        System.out.println("Subject : " + subject);
    }
}

class Student extends Person {
    private String grade;

    public Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    public void displayRole() {
        displayBasicInfo();
        System.out.println("Role  : Student");
        System.out.println("Grade : " + grade);
    }
}

class Staff extends Person {
    private String department;

    public Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    public void displayRole() {
        displayBasicInfo();
        System.out.println("Role       : Staff");
        System.out.println("Department : " + department);
    }
}

public class schoolsystem {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Mrs. Rao", 35, "Mathematics");
        Student student = new Student("Arjun", 16, "10th Grade");
        Staff staff = new Staff("Mr. Sharma", 40, "Administration");

        teacher.displayRole();
        System.out.println();
        student.displayRole();
        System.out.println();
        staff.displayRole();
    }
}
