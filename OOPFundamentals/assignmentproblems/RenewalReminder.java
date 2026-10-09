import java.time.LocalDate;
import java.util.*;

abstract class Plan {
    protected String name;
    protected LocalDate startDate;
    Plan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }
    String getName() { return name; }
    abstract int validityDays();
    LocalDate renewalDate() { return startDate.plusDays(validityDays()); }
}

class BasicPlan extends Plan {
    BasicPlan(String name, LocalDate d) { super(name, d); }
    int validityDays() { return 30; }
}

class StandardPlan extends Plan {
    StandardPlan(String name, LocalDate d) { super(name, d); }
    int validityDays() { return 90; }
}

class PremiumPlan extends Plan {
    PremiumPlan(String name, LocalDate d) { super(name, d); }
    int validityDays() { return 365; }
}

public class RenewalReminder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Plan> plans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate start = LocalDate.parse(sc.next());
            switch (type) {
                case "BASIC":    plans.add(new BasicPlan(name, start));    break;
                case "STANDARD": plans.add(new StandardPlan(name, start)); break;
                case "PREMIUM":  plans.add(new PremiumPlan(name, start));  break;
            }
        }

        for (Plan p : plans) {
            System.out.println(p.getName() + ": " + p.renewalDate());
        }
    }
}