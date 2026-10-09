import java.util.*;

abstract class Connection {
    protected double units;
    Connection(double units) { this.units = units; }

    abstract String getType();
    abstract double bill();
}

class HomeConnection extends Connection {
    HomeConnection(double u) { super(u); }
    String getType() { return "HOME"; }
    double bill() {
        if (units <= 100) return units * 5;
        return 100 * 5 + (units - 100) * 7;
    }
}

class ShopConnection extends Connection {
    ShopConnection(double u) { super(u); }
    String getType() { return "SHOP"; }
    double bill() { return units * 8 + 100; }
}

class FactoryConnection extends Connection {
    FactoryConnection(double u) { super(u); }
    String getType() { return "FACTORY"; }
    double bill() { return Math.max(1000, units * 6); }
}

public class ElectricityBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Connection> connections = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double units = sc.nextDouble();
            switch (type) {
                case "HOME":    connections.add(new HomeConnection(units));    break;
                case "SHOP":    connections.add(new ShopConnection(units));    break;
                case "FACTORY": connections.add(new FactoryConnection(units)); break;
            }
        }

        double total = 0;
        for (Connection c : connections) {
            double b = c.bill();
            total += b;
            System.out.println(c.getType() + ": " + String.format(Locale.US, "%.2f", b));
        }
        System.out.println("Total: " + String.format(Locale.US, "%.2f", total));
    }
}