import components.map.Map1L;

/**
 * Component to track ratings for movies and shows.
 *
 * @param <K>
 *            the name of the movie or show
 * @param <V>
 *            the rating
 * @author Wes Waterstreet
 *
 */
public class MediaRatingTracker<K, V> extends Map1L<K, V> {
    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Map1L<K, V> rep;

    /**
     * Creator of initial representation.
     */
    private void createNewRep() {
        this.rep = new Map1L<K, V>();
    }

    /**
     * No-argument constructor.
     *
     * @return
     */
    public MediaRatingTracker() {
        this.createNewRep();
    }

    /**
     * stores a tv show or movie and its rating.
     *
     * @return returns if the given show or movie is already rated
     * @param key
     *            the name of the movie or show
     */
    public boolean hasMedia(K key) {
        return this.rep.hasKey(key);
    }

    /**
     * stores a tv show or movie and its rating.
     *
     * @param key
     *            the name of the movie or show
     * @param rating
     *            the rating of the movie or show
     */
    public void addRating(K key, V rating) {
        this.rep.add(key, rating);
    }

    /**
     * stores a tv show or movie and its rating.
     *
     * @param key
     *            the name of the movie or show
     * @return the rating of the movie or show
     */
    public V rating(K key) {
        return this.rep.value(key);
    }

    public static void main(String[] args) {
        MediaRatingTracker<String, Integer> shows = new MediaRatingsTracker1<>();
        shows.add("invincible", 4);
        shows.add("arcane", 5);
        shows.rating("arcane");
        shows.updateRating("invincible", 5);
    }
}
