class Locker {
    private final int lockerNumber;
    private String code;

    Locker(int lockerNumber, String code) {
        this.lockerNumber = lockerNumber;
        this.code = code;
    }

    boolean changeCode(String currentCode, String newCode) {
        if (!code.equals(currentCode)) {     // check first, touch nothing if wrong
            System.out.println("Change rejected: wrong current code");
            return false;
        }
        code = newCode;
        System.out.println("Code changed successfully");
        return true;
    }

    int getLockerNumber() {
        return lockerNumber;
    }
}

public class LockerDemo {
    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");
        l.changeCode("1234", "5678");   // success
        l.changeCode("0000", "9999");   // rejected, code is still "5678"
        l.changeCode("5678", "4321");   // success, proves the code stayed "5678"
    }
}