import java.util.List;

// Abstract class
abstract class JobRole {
    public abstract String roleName();
}

// Subclasses
class SoftwareEngineer extends JobRole {
    public String roleName() {
        return "Software Engineer";
    }
}

class DataScientist extends JobRole {
    public String roleName() {
        return "Data Scientist";
    }
}

class ProductManager extends JobRole {
    public String roleName() {
        return "Product Manager";
    }
}

// Generic Resume class
class Resume<T extends JobRole> {
    private String applicantName;
    private T jobRole;

    public Resume(String applicantName, T jobRole) {
        this.applicantName = applicantName;
        this.jobRole = jobRole;
    }

    public void display() {
        System.out.println("Applicant: " + applicantName + ", Applying for: " + jobRole.roleName());
    }
}

// Resume Screening Utility
class ResumeScreening {
    public static void processResumes(List<? extends JobRole> resumes) {
        for (JobRole role : resumes) {
            System.out.println("Screening resume for role: " + role.roleName());
        }
    }
}

// Main
public class ResumeScreeningSystem {
    public static void main(String[] args) {
        Resume<SoftwareEngineer> resume1 = new Resume<>("Alice", new SoftwareEngineer());
        Resume<DataScientist> resume2 = new Resume<>("Bob", new DataScientist());
        Resume<ProductManager> resume3 = new Resume<>("Charlie", new ProductManager());

        resume1.display();
        resume2.display();
        resume3.display();
    }
}