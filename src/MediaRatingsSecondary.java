/**
 * Layered implementations of secondary methods for {@code Map}.
 *
 * @param <String>
 *            String entries for media
 * @param <Integer>
 *            Integer values for rating
 */
@SuppressWarnings("hiding")
public abstract class MediaRatingsSecondary<String, Integer>
        implements MediaRatings<String, Integer> {
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
    @Override
    public void updateRating(String media, int rating) {
        this.remove(media);
        this.add(media, rating);
    }

    /**
     * Finds the media with the given rating value and stores it in a new
     * tracker.
     *
     * @param rating
     *            the associated rating to be added
     * @return new Media Ratings with only media of the given rating.
     *
     */
    @Override
    public MediaRatings<String, Integer> allRatings(int rating) {
        MediaRatings<String, Integer> result = this.newInstance();
        for (int i = 0; i < this.numberOfRatings(); i++) {
            MediaRatings.Pair<String, Integer> temp = this.removeAny();
            if (temp.rating() == rating) {
                result.add(temp.media(), rating);
            }
            this.add(temp.media(), temp.rating());
        }
        return result;
    }
}
