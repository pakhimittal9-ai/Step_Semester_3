class AttendanceSheet {
    private final String[] present;
    private int count;

    AttendanceSheet(int maxClassSize) {
        present = new String[maxClassSize];
        count = 0;
    }

    void markPresent(String name) {
        if (isPresent(name)) return;          // no duplicates
        if (count == present.length) {
            System.out.println("Class is full");
            return;
        }
        present[count++] = name;
    }

    int getPresentCount() {
        return count;
    }

    boolean isPresent(String name) {
        for (int i = 0; i < count; i++) {
            if (present[i].equals(name)) return true;
        }
        return false;
    }
}

public class AttendanceSheetDemo {
    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println(sheet.getPresentCount());   // 2
        System.out.println(sheet.isPresent("Ben"));    // true
        System.out.println(sheet.isPresent("Chen"));   // false
    }
}