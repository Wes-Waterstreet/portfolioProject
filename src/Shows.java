
import components.mediaratings.MediaRating;
import components.mediaratings.MediaRatings;
import components.mediaratings.MediaRatings1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Stores Shows and their Ratings.
 *
 * @author Wes Waterstreet
 *
 */
public final class Shows {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Shows() {
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();
        MediaRatings shows = new MediaRatings1L();
        shows.add("Invincible", 4);
        shows.add("Arcane", 5);
        out.println("Rating for Invincible: " + shows.rating("Invincible")
                + " stars.");
        shows.updateRating("Invincible", 5);
        MediaRating arcane = shows.remove("Arcane");
        out.print("Rating for arcane: " + arcane.rating() + " stars.");
        out.close();

    }
}
