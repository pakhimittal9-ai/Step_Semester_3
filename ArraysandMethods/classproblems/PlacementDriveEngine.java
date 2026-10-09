import java.util.*;

class Candidate implements Comparable<Candidate> {
    private String name;
    private double cgpa;
    private int codingScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    public String getName()      { return name; }
    public double getCgpa()      { return cgpa; }
    public int getCodingScore()  { return codingScore; }

    // Composite score used for ranking
    public double getCompositeScore() {
        return cgpa * 10 + codingScore * 0.5;
    }

    // Descending order by composite score
    @Override
    public int compareTo(Candidate other) {
        return Double.compare(other.getCompositeScore(), this.getCompositeScore());
    }
}

public class PlacementDriveEngine {

    // Quick filter: strong CGPA alone
    static boolean isEligible(double cgpa) {
        return cgpa >= 7.0;
    }

    // Borderline CGPA rescued by a good coding score
    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    static String shortlistAndRank(Candidate[] candidates) {
        int count = 0;
        for (Candidate c : candidates) {
            if (isEligible(c.getCgpa()) || isEligible(c.getCgpa(), c.getCodingScore())) {
                count++;
            }
        }
        if (count == 0) return "No eligible candidates";

        Candidate[] shortlisted = new Candidate[count];
        int idx = 0;
        for (Candidate c : candidates) {
            if (isEligible(c.getCgpa()) || isEligible(c.getCgpa(), c.getCodingScore())) {
                shortlisted[idx++] = c;
            }
        }

        Arrays.sort(shortlisted);   // uses compareTo

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < shortlisted.length; i++) {
            if (i > 0) sb.append(" | ");
            sb.append(i + 1).append(". ").append(shortlisted[i].getName())
              .append(" (").append(String.format(Locale.US, "%.1f", shortlisted[i].getCompositeScore())).append(")");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Candidate[] candidates = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };
        System.out.println(shortlistAndRank(candidates));
        // 1. Aisha (102.0) | 2. Rohit (100.5) | 3. Karan (85.0)
    }
}