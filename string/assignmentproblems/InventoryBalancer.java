import java.util.Scanner;

public class InventoryBalancer {

    static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int totalA = 0;
        int totalB = 0;
        int max = Integer.MIN_VALUE;
        String section = "";
        int index = -1;
        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            if (sectionA[i] > max) {
                max = sectionA[i];
                section = "Section A";
                index = i;
            }
        }
        for (int i = 0; i < sectionB.length; i++) {
            totalB += sectionB[i];
            if (sectionB[i] > max) {
                max = sectionB[i];
                section = "Section B";
                index = i;
            }
        }
        String status = totalA == totalB ? "Balanced" : "Not Balanced";
        System.out.println("Section A Total: " + totalA + " | Section B Total: " + totalB + " | Status: " + status
                + " | Highest Quantity: " + max + " (" + section + ", Item " + (index + 1) + ")");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of items per section: ");
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        System.out.println("Enter Section A quantities:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println("Enter Section B quantities:");
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        analyzeInventory(a, b);
        sc.close();
    }
}