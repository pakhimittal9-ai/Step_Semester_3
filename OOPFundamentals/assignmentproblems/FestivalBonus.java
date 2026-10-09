import java.util.*;

abstract class Employee {
    protected String name;
    protected double salary;
    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    String getName() { return name; }
    abstract double bonus();
}

class FullTime extends Employee {
    FullTime(String name, double salary) { super(name, salary); }
    double bonus() { return salary * 0.10; }
}

class PartTime extends Employee {
    PartTime(String name, double salary) { super(name, salary); }
    double bonus() { return salary * 0.05; }
}

class Intern extends Employee {
    Intern(String name, double salary) { super(name, salary); }
    double bonus() { return 2000; }
}

public class FestivalBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();
            switch (type) {
                case "FULLTIME": employees.add(new FullTime(name, salary)); break;
                case "PARTTIME": employees.add(new PartTime(name, salary)); break;
                case "INTERN":   employees.add(new Intern(name, salary));   break;
            }
        }

        double total = 0;
        for (Employee e : employees) {
            double b = e.bonus();
            total += b;
            System.out.println(e.getName() + ": " + String.format(Locale.US, "%.2f", b));
        }
        System.out.println("Total Bonus: " + String.format(Locale.US, "%.2f", total));
    }
}