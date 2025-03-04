/**
 * MediaRatings secondary methods.
 *
 * @param <K>
 *            the type of the key entries
 * @param <V>
 *            the type of the value entries
 */
public interface MediaRatings<K, V> extends MediaRatingsKernel<K, V> {
    /**
     * The pair of media and rating for the media ratings tracker.
     *
     * @param <K>
     *            the type of the key entries
     * @param <V>
     *            the type of the value entries
     * @initially <pre>
     * (K key, V value):
     *  ensures
     *   this = (key, value)
     * </pre>
     */
    interface Pair<K, V> {
        /**
         * Returns the key for the pair.
         *
         * @return the key
         */
        K key();

        /**
         * Returns the rating for the pair.
         *
         * @return the rating
         */
        V value();
    }

    /**
     * updates the old rating of the given media with the new rating.
     *
     * @param key
     *            the media to be added
     * @param value
     *            the associated rating to be added
     * @updates this
     *
     */
    void updateRating(K key, V value);

    /**
     * Finds the media with the given rating value and stores it in a new
     * tracker.
     *
     * @param value
     *            the associated rating to be added
     * @return new Media Ratings with only media of the given rating.
     *
     */
    MediaRatings<K, V> allRatings(V value);

}
