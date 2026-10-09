import java.util.*;

abstract class Ticket {
    private static final double CONVENIENCE_FEE = 20;   // written in one place only
    protected int count;

    Ticket(int count) { this.count = count; }

    abstract String getSeat();
    abstract double price();

    double amount() { return count * (price() + CONVENIENCE_FEE); }
}

class RegularTicket extends Ticket {
    RegularTicket(int c) { super(c); }
    String getSeat() { return "REGULAR"; }
    double price() { return 150; }
}

class PremiumTicket extends Ticket {
    PremiumTicket(int c) { super(c); }
    String getSeat() { return "PREMIUM"; }
    double price() { return 250; }
}

class RecklinerTicket extends Ticket {
    RecklinerTicket(int c) { super(c); }
    String getSeat() { return "RECLINER"; }
    double price() { return 400; }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Ticket> bookings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String seat = sc.next();
            int count = sc.nextInt();
            switch (seat) {
                case "REGULAR":  bookings.add(new RegularTicket(count));  break;
                case "PREMIUM":  bookings.add(new PremiumTicket(count));  break;
                case "RECLINER": bookings.add(new RecklinerTicket(count)); break;
            }
        }

        double total = 0;
        for (Ticket t : bookings) {
            double a = t.amount();
            total += a;
            System.out.println(t.getSeat() + ": " + String.format(Locale.US, "%.2f", a));
        }
        System.out.println("Total: " + String.format(Locale.US, "%.2f", total));
    }
}