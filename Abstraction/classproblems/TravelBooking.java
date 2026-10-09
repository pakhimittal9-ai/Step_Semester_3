import java.util.*;

abstract class Booking {
    private static final double BOOKING_FEE = 50;   // change the fee here only
    protected double distance;

    Booking(double distance) { this.distance = distance; }

    abstract String getMode();
    abstract double baseFare();

    double total() { return baseFare() + BOOKING_FEE; }
}

class BusBooking extends Booking {
    BusBooking(double d) { super(d); }
    String getMode() { return "BUS"; }
    double baseFare() { return 2 * distance; }
}

class TrainBooking extends Booking {
    TrainBooking(double d) { super(d); }
    String getMode() { return "TRAIN"; }
    double baseFare() { return 1.5 * distance; }
}

class FlightBooking extends Booking {
    FlightBooking(double d) { super(d); }
    String getMode() { return "FLIGHT"; }
    double baseFare() { return 2500 + 4 * distance; }
}

public class TravelBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Booking> bookings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double km = sc.nextDouble();
            switch (mode) {
                case "BUS":    bookings.add(new BusBooking(km));    break;
                case "TRAIN":  bookings.add(new TrainBooking(km));  break;
                case "FLIGHT": bookings.add(new FlightBooking(km)); break;
            }
        }

        for (Booking b : bookings) {
            System.out.println(b.getMode() + ": " + String.format(Locale.US, "%.2f", b.total()));
        }
    }
}