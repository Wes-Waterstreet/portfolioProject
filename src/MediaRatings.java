/**
 * MediaRatings secondary methods.
 */

    public interface MediaRatings extends MediaRatingsKernel {

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
