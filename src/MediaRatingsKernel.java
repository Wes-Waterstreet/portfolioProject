import components.standard.Standard;

/**
 * Media ratings kernel component with primary methods.
 *
 * @param <K>
 *            the type of the key entries
 * @param <V>
 *            the type of the value entries
 */
public interface MediaRatingsKernel<K, V> extends Standard<MediaRatings<K, V>> {
    /**
     * A constant, with value 5, holding the max rating allowed.
     */
    int MAXRATING = 5;

    /**
     * Adds the pair ({@code key}, {@code value}) to this.
     *
     * @param key
     *            the media to be added
     * @param value
     *            the associated rating to be added
     * @aliases references {@code key, value}
     * @updates this
     * @requires key is not in DOMAIN(this)
     * @requires value <= MAXRATING
     * @ensures this = #this union {(key, value)}
     */
    void add(K key, V value);

    /**
     * Removes the pair whose first component is {@code key} and returns it.
     *
     * @param key
     *            the media to be removed
     * @return the pair removed
     * @updates this
     * @requires key is in DOMAIN(this)
     * @ensures <pre>
     * remove.key = key  and
     * remove is in #this  and
     * this = #this \ {remove}
     * </pre>
     */
    MediaRatings.Pair<K, V> remove(K key);

    /**
     * Reports the value associated with {@code key} in {@code this}.
     *
     * @param key
     *            the key whose associated value is to be reported
     * @return the value associated with key
     * @aliases reference returned by {@code value}
     * @requires key is in DOMAIN(this)
     * @ensures (key, value) is in this
     */
    V rating(K key);

    /**
     * Returns if the given key is stored in the media ratings already.
     *
     * @param key
     *            the media to be checked
     * @return true iff there is a key stored that is the same
     * @ensures hasKey = (key is in DOMAIN(this))
     */
    boolean hasMedia(K key);

    /**
     * Returns the number of media ratings saved.
     *
     * @return number of ratings saved
     * @ensures numberOfRatings = |this|
     */
    int numberOfRatings();
}
