
import java.io.*;
import java.util.*;
import java.util.regex.*;

abstract class Question {
    protected String text;
    protected String correct;
    protected String student;
    protected double points;

    Question(String text, String correct, String student, double points) {
        this.text = text;
        this.correct = correct;
        this.student = student;
        this.points = points;
    }
    abstract String getType();
    abstract double score();
}

class McqQuestion extends Question {
    McqQuestion(String t, String c, String s, double p) { super(t, c, s, p); }
    String getType() { return "MCQ"; }
    double score() { return student.equals(correct) ? points : 0; }
}

class TrueFalseQuestion extends Question {
    TrueFalseQuestion(String t, String c, String s, double p) { super(t, c, s, p); }
    String getType() { return "TF"; }
    double score() { return student.equals(correct) ? points : 0; }
}

class EssayQuestion extends Question {
    EssayQuestion(String t, String c, String s, double p) { super(t, c, s, p); }
    String getType() { return "ESSAY"; }
    double score() {
        String answer = student.toLowerCase();
        int matched = 0;
        for (String keyword : correct.split(",")) {
            String k = keyword.trim().toLowerCase();
            if (!k.isEmpty() && answer.contains(k)) matched++;
        }
        if (matched >= 2) return points * 0.75;
        if (matched == 1) return points * 0.50;
        return 0;
    }
}

public class ExamGrader {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        List<Question> questions = new ArrayList<>();
        Pattern token = Pattern.compile("\"([^\"]*)\"|(\\S+)");

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            List<String> parts = new ArrayList<>();
            Matcher m = token.matcher(line);
            while (m.find()) {
                parts.add(m.group(1) != null ? m.group(1) : m.group(2));
            }
            // parts: type, questionText, correctAnswer, studentAnswer, points
            String type = parts.get(0);
            String text = parts.get(1);
            String correct = parts.get(2);
            String student = parts.get(3);
            double points = Double.parseDouble(parts.get(4));

            switch (type) {
                case "MCQ":   questions.add(new McqQuestion(text, correct, student, points));       break;
                case "TF":    questions.add(new TrueFalseQuestion(text, correct, student, points)); break;
                case "ESSAY": questions.add(new EssayQuestion(text, correct, student, points));     break;
            }
        }

        double total = 0;
        for (Question q : questions) {
            double s = q.score();
            total += s;
            System.out.println(q.getType() + ": " + String.format(Locale.US, "%.2f", s));
        }
        System.out.println("Total Score: " + String.format(Locale.US, "%.2f", total));
    }
}