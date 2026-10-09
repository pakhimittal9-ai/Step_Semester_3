import java.util.*;

abstract class Plot {
    protected String owner;
    Plot(String owner) { this.owner = owner; }

    String getOwner() { return owner; }
    abstract String getShape();
    abstract double area();
}

class CirclePlot extends Plot {
    private double radius;
    CirclePlot(String o, double r) { super(o); radius = r; }
    String getShape() { return "CIRCLE"; }
    double area() { return Math.PI * radius * radius; }
}

class RectanglePlot extends Plot {
    private double length, width;
    RectanglePlot(String o, double l, double w) { super(o); length = l; width = w; }
    String getShape() { return "RECTANGLE"; }
    double area() { return length * width; }
}

class TrianglePlot extends Plot {
    private double base, height;
    TrianglePlot(String o, double b, double h) { super(o); base = b; height = h; }
    String getShape() { return "TRIANGLE"; }
    double area() { return 0.5 * base * height; }
}

public class GardenPlotReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Plot> plots = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String shape = sc.next();
            String owner = sc.next();
            switch (shape) {
                case "CIRCLE":    plots.add(new CirclePlot(owner, sc.nextDouble())); break;
                case "RECTANGLE": plots.add(new RectanglePlot(owner, sc.nextDouble(), sc.nextDouble())); break;
                case "TRIANGLE":  plots.add(new TrianglePlot(owner, sc.nextDouble(), sc.nextDouble())); break;
            }
        }

        double total = 0;
        for (Plot p : plots) {
            double a = p.area();
            total += a;
            System.out.println(p.getOwner() + " (" + p.getShape() + "): " + String.format(Locale.US, "%.2f", a));
        }
        System.out.println("Total Area: " + String.format(Locale.US, "%.2f", total));
    }
}