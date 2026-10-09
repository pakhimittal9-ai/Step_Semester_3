
import java.util.*;

interface NightService {
    default double nightFare(double dayFare) { return dayFare * 1.20; }
}

abstract class Cab {
    private static final double MIN_FARE = 100;   // shared minimum-fare rule

    abstract String getType();
    abstract double ratePerKm();

    double fare(double km) { return Math.max(MIN_FARE, km * ratePerKm()); }
}

class MiniCab extends Cab {
    String getType() { return "MINI"; }
    double ratePerKm() { return 10; }
}

class SedanCab extends Cab implements NightService {
    String getType() { return "SEDAN"; }
    double ratePerKm() { return 14; }
}

class SuvCab extends Cab implements NightService {
    String getType() { return "SUV"; }
    double ratePerKm() { return 18; }
}

public class CabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        StringBuilder out = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab cab = null;
            switch (type) {
                case "MINI":  cab = new MiniCab();  break;
                case "SEDAN": cab = new SedanCab(); break;
                case "SUV":   cab = new SuvCab();   break;
            }

            double fare = cab.fare(km);
            if (time.equals("NIGHT")) {
                if (cab instanceof NightService) {
                    fare = ((NightService) cab).nightFare(fare);
                } else {
                    out.append(cab.getType()).append(": night service not available\n");
                    continue;
                }
            }
            total += fare;
            out.append(cab.getType()).append(": ").append(String.format(Locale.US, "%.2f", fare)).append("\n");
        }
        System.out.print(out);
        System.out.println("Total: " + String.format(Locale.US, "%.2f", total));
    }
}