class PasswordChecker {
    private final String password;

    PasswordChecker(String password) {
        this.password = password;
    }

    String getStrength() {
        int len = password.length();
        if (len < 6) return "Weak";
        if (len < 10) return "Medium";
        return "Strong";
    }
}

public class PasswordCheckerDemo {
    public static void main(String[] args) {
        System.out.println(new PasswordChecker("abcd").getStrength());          // Weak
        System.out.println(new PasswordChecker("abcdefgh").getStrength());      // Medium
        System.out.println(new PasswordChecker("abcdefghij").getStrength());    // Strong
        System.out.println(new PasswordChecker("abcdefghijkl").getStrength());  // Strong
    }
}