import java.io.*;
import java.util.*;

interface SaverMode {
    default double applySaver(double units) { return units * 0.75; }
}

abstract class Appliance {
    private static final double RATE_PER_UNIT = 8;
    protected double hours;

    Appliance(double hours) { this.hours = hours; }

    abstract String getName();
    abstract double powerWatts();

    double units() { return powerWatts() * hours / 1000; }
    double cost(double units) { return units * RATE_PER_UNIT; }
}

class Fridge extends Appliance {
    Fridge(double h) { super(h); }
    String getName() { return "FRIDGE"; }
    double powerWatts() { return 150; }
}

class AirConditioner extends Appliance implements SaverMode {
    AirConditioner(double h) { super(h); }
    String getName() { return "AC"; }
    double powerWatts() { return 1500; }
}

class Tv extends Appliance {
    Tv(double h) { super(h); }
    String getName() { return "TV"; }
    double powerWatts() { return 100; }
}

class WashingMachine extends Appliance implements SaverMode {
    WashingMachine(double h) { super(h); }
    String getName() { return "WASHER"; }
    double powerWatts() { return 500; }
}

public class ApplianceEnergyReport {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        double total = 0;
        StringBuilder out = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String[] p = br.readLine().trim().split("\\s+");
            double hours = Double.parseDouble(p[1]);
            boolean saver = p.length > 2 && p[2].equals("SAVER");

            Appliance a = null;
            switch (p[0]) {
                case "FRIDGE": a = new Fridge(hours);         break;
                case "AC":     a = new AirConditioner(hours); break;
                case "TV":     a = new Tv(hours);             break;
                case "WASHER": a = new WashingMachine(hours); break;
            }

            double units = a.units();
            if (saver) {
                if (a instanceof SaverMode) {
                    units = ((SaverMode) a).applySaver(units);
                } else {
                    out.append(a.getName()).append(": saver mode not supported\n");
                    continue;
                }
            }
            double cost = a.cost(units);
            total += cost;
            out.append(a.getName()).append(": Units=").append(String.format(Locale.US, "%.2f", units))
               .append(" Cost=").append(String.format(Locale.US, "%.2f", cost)).append("\n");
        }
        System.out.print(out);
        System.out.println("Total Cost: " + String.format(Locale.US, "%.2f", total));
    }
}