import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * MediaRatings represented as a java.util.Map with implementations of primary
 * methods.
 *
 * @convention $this.Pair.media() != null and $this.Pair.rating() >= 0 and
 *             $this.Pair.rating() <= 5
 *
 * @correspondence this = [value of $this]
 *
 */
public class MediaRatings1L extends MediaRatingsSecondary {
    /*
     * Private Members
     */

    /**
     * Representation of this.
     */
    private java.util.Map<String, Integer> rep;

    /**
     * Creating initial representation.
     */
    private void createNewRep() {
        this.rep = new HashMap<String, Integer>();
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
        /*
         * This cast cannot fail since the assert above would have stopped
         * execution in that case: source must be of dynamic type Map2<?,?>, and
         * the ?,? must be K,V or the call would not have compiled.
         */
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
        this.rep.put(media, rating);
    }

    @Override
    public final MediaRatings.Pair remove(String media) {
        assert media != null : "Violation of: media is not null";
        assert this.hasMedia(media) : "Violation of: media is in DOMAIN(this)";

        String mediaRemoved = null;
        Set<String> allMedia = this.rep.keySet();
        for (String x : allMedia) {
            if (x.equals(media)) {
                mediaRemoved = x;
                break;
            }
        }
        int ratingRemoved = this.rep.remove(mediaRemoved);
        return new MediaRatings.Pair(mediaRemoved, ratingRemoved);
    }

    @Override
    public final MediaRatings.Pair removeAny() {
        assert this.numberOfRatings() > 0 : "Violation of: this /= empty_set";
        Iterator<java.util.Map.Entry<String, Integer>> it = this.rep.entrySet()
                .iterator();
        java.util.Map.Entry<String, Integer> entry = it.next();
        it.remove();
        return new MediaRatings.Pair(entry.getKey(), entry.getValue());
    }

    @Override
    public final int rating(String media) {
        assert media != null : "Violation of: media is not null";
        assert this.hasMedia(media) : "Violation of: media is in DOMAIN(this)";
        return this.rep.get(media);
    }

    @Override
    public final boolean hasMedia(String media) {
        assert media != null : "Violation of: media is not null";
        return this.rep.containsKey(media);
    }

    @Override
    public final int numberOfRatings() {
        return this.rep.size();
    }
}
