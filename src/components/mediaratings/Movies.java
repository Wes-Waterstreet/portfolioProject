package components.mediaratings;

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
        movies.add("movie 1", 3);
        movies.add("movie 2", 4);
        movies.add("movie 3", 2);
        movies.add("movie 4", 5);
        movies.add("movie 5", 4);
        MediaRatings fourStars = movies.allRatings(4);
        int length = fourStars.numberOfRatings();
        out.println("Four star movies: ");
        for (int i = 0; i < length; i++) {
            out.println(fourStars.removeAny().media());
        }
        out.close();
    }
}
