package components.mediaratings;
import java.util.LinkedList;
import java.util.Queue;

/**
 * MediaRatings represented as a java.util.Map with implementations of primary
 * methods.
 *
 * @convention $this.Pair.media() != null and $this.Pair.rating() >= 0 and
 *             $this.Pair.rating() <= 5 and MediaRating holds the string and
 *             integer pair which is held in a queue
 *
 * @correspondence this = entries($this.rep)
 *
 */
public class MediaRatings1L extends MediaRatingsSecondary {

    /*
     * Private Members
     */

    /**
     * Representation of this.
     */
    private Queue<MediaRating> rep;

    /**
     * Finds pair with media and moves it to the front of q.
     *
     * @param q
     *            the Queue to be searched
     * @param media
     *            the string to be searched for
     * @updates q
     * @ensures <pre>
     * perms(q, #q)  and MediaRating where MediaRating.media = media is in the front
     * </pre>
     */
    private static void moveToFront(Queue<MediaRating> q, String media) {
        boolean check = false;
        for (int i = 0; i < q.size(); i++) {
            MediaRating temp = q.remove();
            if (temp.media().equals(media)) {
                check = true;
            } else {
                q.add(temp);
            }
            if (check) {
                q.add(temp);
                for (int j = 0; j < q.size() - 1; j++) {
                    MediaRating temp3 = q.remove();
                    q.add(temp3);
                }
            }
        }

    }

    /**
     * Creating initial representation.
     */
    private void createNewRep() {
        this.rep = new LinkedList<MediaRating>();
    }

    /*
     * constructors
     */

    /**
     * No argument constructor.
     */
    public MediaRatings1L() {
        this.createNewRep();
    }

    /*
     * Standard methods
     */

    @Override
    public final MediaRatings newInstance() {
        try {
            return this.getClass().getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }

    @Override
    public final void clear() {
        this.createNewRep();
    }

    @Override
    public final void transferFrom(MediaRatings source) {
        assert source != null : "Violation of: source is not null";
        assert source != this : "Violation of: source is not this";
        assert source instanceof MediaRatings : ""
                + "Violation of: source is of dynamic type Map1L<?,?>";
        MediaRatings1L localSource = (MediaRatings1L) source;
        this.rep = localSource.rep;
        localSource.createNewRep();
    }

    @Override
    public final void add(String media, int rating) {
        assert media != null : "Violation of: media is not null";
        assert !this
                .hasMedia(media) : "Violation of: media is not in DOMAIN(this)";
        assert rating >= MINRATING : "Violation of: rating is not valid";
        assert rating <= MAXRATING : "Violation of: rating is not valid";
        MediaRating temp = new MediaRating(media, rating);
        this.rep.add(temp);
    }

    @Override
    public final MediaRating remove(String media) {
        assert media != null : "Violation of: media is not null";
        assert this.hasMedia(media) : "Violation of: media is in DOMAIN(this)";

        moveToFront(this.rep, media);
        return this.rep.remove();
    }

    @Override
    public final MediaRating removeAny() {
        assert this.numberOfRatings() > 0 : "Violation of: this /= empty_set";

        return this.rep.remove();
    }

    @Override
    public final int rating(String media) {
        assert media != null : "Violation of: media is not null";
        assert this.hasMedia(media) : "Violation of: media is in DOMAIN(this)";
        moveToFront(this.rep, media);
        MediaRating pair = this.rep.peek();
        int result = pair.rating();
        return result;
    }

    @Override
    public final boolean hasMedia(String media) {
        assert media != null : "Violation of: media is not null";
        boolean result = false;
        for (int i = 0; i < this.rep.size(); i++) {
            MediaRating temp = this.rep.remove();
            if (temp.media().equals(media)) {
                result = true;
            }
            this.rep.add(temp);
        }
        return result;
    }

    @Override
    public final int numberOfRatings() {
        return this.rep.size();
    }
}
