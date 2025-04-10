/**
 * MediaRatings secondary methods.
 */
public interface MediaRatings extends MediaRatingsKernel {
    /**
     * The pair of media and rating for the media ratings tracker.
     *
     * @initially <pre>
     * (String media, Integer rating):
     *  ensures
     *   this = (media, rating)
     * </pre>
     */
    interface MediaRating {
        /**
         * Returns the media for the pair.
         *
         * @return the media
         */
        String media();

        /**
         * Returns the rating for the pair.
         *
         * @return the rating
         */
        int rating();
    }

    /**
     * updates the old rating of the given media with the new rating.
     *
     * @param media
     *            the media to be changed
     * @param rating
     *            The new rating
     * @updates this
     *
     */
    void updateRating(String media, int rating);

    /**
     * Finds the media with the given rating value and stores it in a new
     * tracker.
     *
     * @param rating
     *            the associated rating to be added
     * @return new Media Ratings with only media of the given rating.
     *
     */
    MediaRatings allRatings(int rating);

}
