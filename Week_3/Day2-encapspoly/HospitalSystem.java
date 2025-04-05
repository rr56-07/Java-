package encapspoly;
import java.util.*;

interface MedicalRecord {
    void addRecord(String record);
    List<String> viewRecords();
}

abstract class Patient implements MedicalRecord {
    private String patientId;
    private String name;
    private int age;
    private List<String> medicalHistory = new ArrayList<>();

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public String getPatientDetails() {
        return "ID: " + patientId + ", Name: " + name + ", Age: " + age;
    }

    public void addRecord(String record) {
        medicalHistory.add(record);
    }

    public List<String> viewRecords() {
        return medicalHistory;
    }

    public abstract double calculateBill();
}

class InPatient extends Patient {
    private int daysAdmitted;
    private double roomChargePerDay;

    public InPatient(String patientId, String name, int age, int daysAdmitted, double roomChargePerDay) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
        this.roomChargePerDay = roomChargePerDay;
    }

    public double calculateBill() {
        return daysAdmitted * roomChargePerDay + 500; // Flat service charge
    }
}

class OutPatient extends Patient {
    private double consultationFee;

    public OutPatient(String patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
    }

    public double calculateBill() {
        return consultationFee;
    }
}

public class HospitalSystem {
    public static void processPatients(List<Patient> patients) {
        for (Patient p : patients) {
            System.out.println(p.getPatientDetails());
            p.addRecord("Checkup on 16-April-2025");
            System.out.println("Medical Records: " + p.viewRecords());
            System.out.println("Total Bill: ₹" + p.calculateBill());
            System.out.println("----------------------------------");
        }
    }

    public static void main(String[] args) {
        List<Patient> patientList = new ArrayList<>();
        patientList.add(new InPatient("P001", "Alice", 35, 4, 1000));
        patientList.add(new OutPatient("P002", "Bob", 29, 700));

        processPatients(patientList);
    }
}
