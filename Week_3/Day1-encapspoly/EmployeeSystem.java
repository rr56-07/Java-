package encapspoly;

import java.util.ArrayList;
import java.util.List;

interface Department {
    void assignDepartment(String deptName);
    String getDepartmentDetails();
}

abstract class Employee implements Department {
    private int employeeId;
    private String name;
    private double baseSalary;
    private String department;

    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public void assignDepartment(String deptName) {
        this.department = deptName;
    }

    public String getDepartmentDetails() {
        return department;
    }

    public void displayDetails() {
        System.out.println("Employee ID  : " + employeeId);
        System.out.println("Name         : " + name);
        System.out.println("Base Salary  : " + baseSalary);
        System.out.println("Department   : " + department);
    }

    public abstract double calculateSalary();
}

class FullTimeEmployee extends Employee {
    private double benefits;

    public FullTimeEmployee(int employeeId, String name, double baseSalary, double benefits) {
        super(employeeId, name, baseSalary);
        this.benefits = benefits;
    }

    public double calculateSalary() {
        return getBaseSalary() + benefits;
    }
}

class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(int employeeId, String name, double hourlyRate, int hoursWorked) {
        super(employeeId, name, 0);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
}

public class EmployeeSystem {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();

        FullTimeEmployee ft = new FullTimeEmployee(101, "Alice", 50000, 10000);
        ft.assignDepartment("HR");

        PartTimeEmployee pt = new PartTimeEmployee(102, "Bob", 500, 40);
        pt.assignDepartment("IT");

        employeeList.add(ft);
        employeeList.add(pt);

        for (Employee emp : employeeList) {
            emp.displayDetails();
            System.out.println("Total Salary : " + emp.calculateSalary());
            System.out.println("-----------------------------");
        }
    }
}
