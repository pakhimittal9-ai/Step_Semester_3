import java.util.*;

interface BusUser {
    double TRANSPORT_FEE = 12000;   // transport fee in one place
}

abstract class Student {
    protected String name;
    Student(String name) { this.name = name; }

    String getName() { return name; }
    abstract double tuitionAndOther();

    double totalFee() {
        double fee = tuitionAndOther();
        if (this instanceof BusUser) fee += BusUser.TRANSPORT_FEE;
        return fee;
    }
}

class DayScholar extends Student implements BusUser {
    DayScholar(String n) { super(n); }
    double tuitionAndOther() { return 40000; }
}

class Hosteller extends Student {
    Hosteller(String n) { super(n); }
    double tuitionAndOther() { return 40000 + 60000; }
}

class ScholarshipStudent extends Student implements BusUser {
    ScholarshipStudent(String n) { super(n); }
    double tuitionAndOther() { return 40000 / 2; }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            switch (type) {
                case "DAY_SCHOLAR": students.add(new DayScholar(name));         break;
                case "HOSTELLER":   students.add(new Hosteller(name));          break;
                case "SCHOLAR":     students.add(new ScholarshipStudent(name)); break;
            }
        }

        double total = 0;
        for (Student s : students) {
            double fee = s.totalFee();
            total += fee;
            System.out.println(s.getName() + ": " + String.format(Locale.US, "%.2f", fee));
        }
        System.out.println("Total Collected: " + String.format(Locale.US, "%.2f", total));
    }
}