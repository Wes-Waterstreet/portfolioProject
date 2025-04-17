import components.standard.Standard;

/**
 * Media ratings kernel component with primary methods.
 */
public interface MediaRatingsKernel extends Standard<MediaRatings> {
    /**
     * A constant, with value 5, holding the maximum rating allowed.
     */
    int MAXRATING = 5;

    /**
     * A constant, with value 0, holding the minimum rating allowed.
     */
    int MINRATING = 0;

    /**
     * Adds the pair ({@code media}, {@code rating}) to this.
     *
     * @param media
     *            the media to be added
     * @param rating
     *            the associated rating to be added
     * @aliases references {@code media, rating}
     * @updates this
     * @requires media is not in DOMAIN(this)
     * @requires rating <= MAXRATING
     * @ensures this = #this union {(media, rating)}
     */
    void add(String media, int rating);

    /**
     * Removes the pair whose first component is {@code media} and returns it.
     *
     * @param media
     *            the media to be removed
     * @return the pair removed
     * @updates this
     * @requires media is in DOMAIN(this)
     * @ensures <pre>
     * remove.media = media  and
     * remove is in #this  and
     * this = #this \ {remove}
     * </pre>
     */
    MediaRating remove(String media);

    /**
     * Removes any component and returns it.
     *
     * @return the pair removed
     * @updates this
     * @ensures <pre>
     * remove.media = media  and
     * remove is in #this  and
     * this = #this \ {remove}
     * </pre>
     */
    MediaRating removeAny();

    /**
     * Reports the rating associated with {@code media} in {@code this}.
     *
     * @param media
     *            the media whose associated rating is to be reported
     * @return the rating associated with the media
     * @aliases reference returned by {@code rating}
     * @requires media is in DOMAIN(this)
     * @ensures (media, rating) is in this
     */
    int rating(String media);

    /**
     * Returns if the given media is stored in the media ratings already.
     *
     * @param media
     *            the media to be checked
     * @return true iff there is a media stored that is the same
     * @ensures hasMedia = (media is in DOMAIN(this))
     */
    boolean hasMedia(String media);

    /**
     * Returns the number of media ratings saved.
     *
     * @return number of ratings saved
     * @ensures numberOfRatings = |this|
     */
    int numberOfRatings();
}
