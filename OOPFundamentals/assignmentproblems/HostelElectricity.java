import java.util.*;

abstract class Room {
    protected double units;
    Room(double units) { this.units = units; }
    abstract String getType();
    abstract double bill();
}

class SingleRoom extends Room {
    SingleRoom(double units) { super(units); }
    String getType() { return "SINGLE"; }
    double bill() { return units * 8; }
}

class SharedRoom extends Room {
    private int occupants;          // extra value lives inside this class only
    SharedRoom(double units, int occupants) {
        super(units);
        this.occupants = occupants;
    }
    String getType() { return "SHARED"; }
    double bill() { return (units * 6) / occupants; }
}

class AcRoom extends Room {
    AcRoom(double units) { super(units); }
    String getType() { return "AC"; }
    double bill() { return units * 10 + 200; }
}

public class HostelElectricity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Room> rooms = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double units = sc.nextDouble();
            switch (type) {
                case "SINGLE": rooms.add(new SingleRoom(units)); break;
                case "SHARED": rooms.add(new SharedRoom(units, sc.nextInt())); break;
                case "AC":     rooms.add(new AcRoom(units)); break;
            }
        }

        double total = 0;
        for (Room r : rooms) {
            double b = r.bill();
            total += b;
            System.out.println(r.getType() + ": " + String.format(Locale.US, "%.2f", b));
        }
        System.out.println("Total: " + String.format(Locale.US, "%.2f", total));
    }
}