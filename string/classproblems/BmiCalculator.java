import java.util.Random;

public class BmiCalculator {

    static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal";
        } else if (bmi < 30) {
            return "Overweight";
        }
        return "Obese";
    }

    static void printWellnessReport(double[] heights, double[] weights) {
        System.out.printf("%-8s | %-10s | %-11s | %-6s | %s%n", "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            System.out.printf("%-8d | %-10.2f | %-11.1f | %-6.2f | %s%n", i + 1, heights[i], weights[i], bmi, getBmiStatus(bmi));
        }
    }

    public static void main(String[] args) {
        int team = 10;
        double[] heights = new double[team];
        double[] weights = new double[team];
        Random random = new Random();
        for (int i = 0; i < team; i++) {
            heights[i] = 1.50 + random.nextDouble() * 0.50;
            weights[i] = 45 + random.nextDouble() * 65;
        }
        printWellnessReport(heights, weights);
    }
}