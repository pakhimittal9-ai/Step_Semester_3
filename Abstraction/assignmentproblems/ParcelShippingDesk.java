import java.util.*;

interface Insurable {
    double RATE = 0.02;
    double declaredValue();
    default double insurance() { return declaredValue() * RATE; }
}

abstract class Parcel {
    protected double weight;
    protected double value;

    Parcel(double weight, double value) {
        this.weight = weight;
        this.value = value;
    }

    abstract String getType();
    abstract double charge();

    protected double standardCharge() { return 40 + 10 * weight; }

    double insuranceAmount() {
        return (this instanceof Insurable) ? ((Insurable) this).insurance() : 0;
    }
}

class StandardParcel extends Parcel {
    StandardParcel(double w, double v) { super(w, v); }
    String getType() { return "STANDARD"; }
    double charge() { return standardCharge(); }
}

class ExpressParcel extends Parcel implements Insurable {
    ExpressParcel(double w, double v) { super(w, v); }
    String getType() { return "EXPRESS"; }
    double charge() { return 80 + 15 * weight; }
    public double declaredValue() { return value; }
}

class FragileParcel extends Parcel implements Insurable {
    FragileParcel(double w, double v) { super(w, v); }
    String getType() { return "FRAGILE"; }
    double charge() { return standardCharge() + 50; }
    public double declaredValue() { return value; }
}

public class ParcelShippingDesk {
    static String f(double x) { return String.format(Locale.US, "%.2f", x); }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Parcel> parcels = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double w = sc.nextDouble();
            double v = sc.nextDouble();
            switch (type) {
                case "STANDARD": parcels.add(new StandardParcel(w, v)); break;
                case "EXPRESS":  parcels.add(new ExpressParcel(w, v));  break;
                case "FRAGILE":  parcels.add(new FragileParcel(w, v));  break;
            }
        }

        double grand = 0;
        for (Parcel p : parcels) {
            double c = p.charge();
            double ins = p.insuranceAmount();
            grand += c + ins;
            System.out.println(p.getType() + ": Charge=" + f(c) + " Insurance=" + f(ins) + " Total=" + f(c + ins));
        }
        System.out.println("Grand Total: " + f(grand));
    }
}