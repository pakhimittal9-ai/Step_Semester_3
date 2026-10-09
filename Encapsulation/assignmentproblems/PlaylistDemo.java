
import java.util.Arrays;

class Playlist {
    private String[] songs;
    private int count;

    Playlist(int maxSize) {
        songs = new String[maxSize];
        count = 0;
    }

    void addSong(String title) {
        if (count == songs.length) {
            System.out.println("Playlist is full");
            return;
        }
        songs[count++] = title;
    }

    // Returns a copy, never the private array itself
    String[] getSongs() {
        return Arrays.copyOf(songs, count);
    }

    int getSongCount() {
        return count;
    }
}

public class PlaylistDemo {
    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        copy[0] = "Hacked";

        System.out.println(p.getSongs()[0]);     // Song A
        System.out.println(p.getSongCount());    // 2
    }
}