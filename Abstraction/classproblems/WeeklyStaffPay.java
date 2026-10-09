
import java.util.*;

abstract class Staff {
    protected String name;
    Staff(String name) { this.name = name; }

    String getName() { return name; }
    abstract double pay();
}

class FullTimeStaff extends Staff {
    private double salary;
    FullTimeStaff(String n, double salary) { super(n); this.salary = salary; }
    double pay() { return salary; }
}

class HourlyStaff extends Staff {
    private double hours, rate;
    HourlyStaff(String n, double hours, double rate) { super(n); this.hours = hours; this.rate = rate; }
    double pay() {
        if (hours <= 40) return hours * rate;
        return 40 * rate + (hours - 40) * 1.5 * rate;
    }
}

class InternStaff extends Staff {
    private double stipend;
    InternStaff(String n, double stipend) { super(n); this.stipend = stipend; }
    double pay() { return stipend; }
}

public class WeeklyStaffPay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Staff> staff = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            switch (type) {
                case "FULLTIME": staff.add(new FullTimeStaff(name, sc.nextDouble())); break;
                case "HOURLY":   staff.add(new HourlyStaff(name, sc.nextDouble(), sc.nextDouble())); break;
                case "INTERN":   staff.add(new InternStaff(name, sc.nextDouble())); break;
            }
        }

        double total = 0;
        for (Staff s : staff) {
            double p = s.pay();
            total += p;
            System.out.println(s.getName() + ": " + String.format(Locale.US, "%.2f", p));
        }
        System.out.println("Total Payroll: " + String.format(Locale.US, "%.2f", total));
    }
}