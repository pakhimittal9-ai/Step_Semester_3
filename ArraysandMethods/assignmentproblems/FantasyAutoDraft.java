import java.util.*;

class Player implements Comparable<Player> {
    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    public String getName()          { return name; }
    public int getMatchesPlayed()    { return matchesPlayed; }
    public boolean isInjured()       { return injured; }

    // Fantasy points used for ranking
    public double getFantasyPoints() {
        return battingAverage + 0.5 * matchesPlayed;
    }

    // Descending order by fantasy points
    @Override
    public int compareTo(Player other) {
        return Double.compare(other.getFantasyPoints(), this.getFantasyPoints());
    }
}

public class FantasyAutoDraft {

    // Established players: experience alone is enough
    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    // Newer players: need some experience AND must be fit
    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    static String draftAndRank(Player[] players) {
        // Count draftable players
        int count = 0;
        for (Player p : players) {
            if (isDraftable(p.getMatchesPlayed()) || isDraftable(p.getMatchesPlayed(), p.isInjured())) {
                count++;
            }
        }
        if (count == 0) return "No draftable players";

        // Collect them
        Player[] draftable = new Player[count];
        int idx = 0;
        for (Player p : players) {
            if (isDraftable(p.getMatchesPlayed()) || isDraftable(p.getMatchesPlayed(), p.isInjured())) {
                draftable[idx++] = p;
            }
        }

        Arrays.sort(draftable);   // uses compareTo

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < draftable.length; i++) {
            if (i > 0) sb.append(" | ");
            sb.append(i + 1).append(". ").append(draftable[i].getName());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Player[] players = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };
        System.out.println(draftAndRank(players));   // 1. Rahul | 2. Virat | 3. Dev
    }
}