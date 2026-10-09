import java.io.*;
import java.time.LocalDate;
import java.util.*;

abstract class LibraryItem {
    protected String title;
    LibraryItem(String title) { this.title = title; }
    String getTitle() { return title; }
    abstract int borrowDays();
    LocalDate dueDate(LocalDate today) { return today.plusDays(borrowDays()); }
}

class Book extends LibraryItem {
    Book(String title) { super(title); }
    int borrowDays() { return 14; }
}

class Dvd extends LibraryItem {
    Dvd(String title) { super(title); }
    int borrowDays() { return 7; }
}

class Magazine extends LibraryItem {
    Magazine(String title) { super(title); }
    int borrowDays() { return 3; }
}

public class LibraryDueDates {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LocalDate today = LocalDate.of(2023, 10, 26);

        int n = Integer.parseInt(br.readLine().trim());
        List<LibraryItem> items = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = br.readLine().trim();
            int space = line.indexOf(' ');
            String type = line.substring(0, space);
            String title = line.substring(space + 1).trim();
            if (title.startsWith("\"") && title.endsWith("\"") && title.length() >= 2) {
                title = title.substring(1, title.length() - 1);
            }
            switch (type) {
                case "BOOK":     items.add(new Book(title));     break;
                case "DVD":      items.add(new Dvd(title));      break;
                case "MAGAZINE": items.add(new Magazine(title)); break;
            }
        }

        for (LibraryItem item : items) {
            System.out.println(item.getTitle() + ": " + item.dueDate(today));
        }
    }
}