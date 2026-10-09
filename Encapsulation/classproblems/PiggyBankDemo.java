class PiggyBank {
    private final String id;
    private double savings;

    PiggyBank(String id) {
        this.id = id;
        this.savings = 0;
    }

    void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit rejected: amount must be greater than 0");
            return;
        }
        savings += amount;
    }

    void withdraw(double amount) {
        if (amount <= 0 || amount > savings) {
            System.out.println("Withdraw rejected");
            return;
        }
        savings -= amount;
    }

    double getSavings() {
        return savings;
    }

    String getId() {
        return id;
    }
}

public class PiggyBankDemo {
    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");
        pb.deposit(100);
        System.out.println("savings = " + pb.getSavings());   // 100.0
        pb.withdraw(30);
        System.out.println("savings = " + pb.getSavings());   // 70.0
        pb.withdraw(500);                                      // rejected
        System.out.println("savings = " + pb.getSavings());   // 70.0
    }
}