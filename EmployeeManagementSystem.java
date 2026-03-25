import java.util.Scanner;

// ── Encapsulation ─────────────────────────────────────────────────────────────
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age  = age;
    }

    public String getName() { return name; }
    public int    getAge()  { return age;  }

    public void setName(String name) { this.name = name; }
    public void setAge(int age)      { this.age  = age;  }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age:  " + age);
    }
}

// ── Abstraction ───────────────────────────────────────────────────────────────
abstract class Department {
    public abstract String getDepartmentName();
}

class ITDepartment extends Department {
    @Override
    public String getDepartmentName() {
        return "IT";
    }
}

// ── Inheritance + Polymorphism ────────────────────────────────────────────────
class Employee extends Person {
    private double salary;
    private Department department;

    public Employee(String name, int age, double salary, Department department) {
        super(name, age);
        this.salary     = salary;
        this.department = department;
    }

    // Method Overloading — calculateBonus
    public double calculateBonus(int performanceRating) {
        switch (performanceRating) {
            case 5: return salary * 0.30;
            case 4: return salary * 0.20;
            case 3: return salary * 0.15;
            case 2: return salary * 0.10;
            default: return salary * 0.05;  // rating 1
        }
    }

    // Overload with explicit percentage (alternative call signature)
    public double calculateBonus(double percentage) {
        return salary * percentage;
    }

    // Method Overriding
    @Override
    public void displayDetails() {
        System.out.println("Employee Details:");
        System.out.println("Name: "       + getName());
        System.out.println("Age: "        + getAge());
        System.out.println("Salary: "     + (int) salary);
    }

    public void displayDetails(int performanceRating) {
        displayDetails();
        System.out.println("Bonus: "      + (int) calculateBonus(performanceRating));
        System.out.println("Department: " + department.getDepartmentName());
    }

    public double getSalary()            { return salary; }
    public Department getDepartment()    { return department; }
}

// ── Main ──────────────────────────────────────────────────────────────────────
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name              = sc.next();
        int    age               = sc.nextInt();
        double salary            = sc.nextDouble();
        int    performanceRating = sc.nextInt();

        // Validate constraints
        if (age <= 18) {
            System.out.println("Error: Age must be greater than 18.");
            return;
        }
        if (salary <= 0) {
            System.out.println("Error: Salary must be greater than 0.");
            return;
        }
        if (performanceRating < 1 || performanceRating > 5) {
            System.out.println("Error: Performance rating must be between 1 and 5.");
            return;
        }

        Department dept     = new ITDepartment();
        Employee   employee = new Employee(name, age, salary, dept);

        employee.displayDetails(performanceRating);

        sc.close();
    }
}
