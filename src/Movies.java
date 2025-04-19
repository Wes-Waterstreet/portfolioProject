
import components.mediaratings.MediaRatings;
import components.mediaratings.MediaRatings1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Stores Movies and there ratings and prints out movies of a certain rating.
 *
 * @author Wes Waterstreet
 *
 */
public final class Movies {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Movies() {
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();
        MediaRatings movies = new MediaRatings1L();
        movies.add("movie1", 3);
        movies.add("movie2", 4);
        movies.add("movie3", 2);
        movies.add("movie4", 5);
        movies.add("movie5", 4);
        MediaRatings fourStars = movies.allRatings(4);
        int length = fourStars.numberOfRatings();
        out.println(movies.toString());
        out.println("Four star movies: ");
        for (int i = 0; i < length; i++) {
            out.println(fourStars.removeAny().media());
        }
        out.close();
    }
}
