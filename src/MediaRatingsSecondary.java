/**
 * Layered implementations of secondary methods for {@code MediaRatings}.
 */
public abstract class MediaRatingsSecondary implements MediaRatings {

    @Override
    public final void updateRating(String media, int rating) {
        this.remove(media);
        this.add(media, rating);
    }

    @Override
    public final MediaRatings allRatings(int rating) {
        MediaRatings result = this.newInstance();
        for (int i = 0; i < this.numberOfRatings(); i++) {
            MediaRatings.Pair temp = this.removeAny();
            if (temp.rating() == rating) {
                result.add(temp.media(), rating);
            }
            this.add(temp.media(), temp.rating());
        }
        return result;
    }

    @Override
    public final String toString() {
        String value = "";
        int length = this.numberOfRatings();
        for (int i = 0; i < length; i++) {
            MediaRatings.Pair temp = this.removeAny();
            value.concat("<");
            value.concat(temp.media().toString());
            value.concat(", ");
            value.concat(String.valueOf(temp.rating()));
            value.concat(">");
            value.concat(", ");
            this.add(temp.media(), temp.rating());
        }
        return value;
    }

    @Override
    public final int hashCode() {
        int result = 1;
        int length = this.numberOfRatings();
        for (int i = 0; i < length; i++) {
            MediaRatings.Pair temp = this.removeAny();
            result += (temp.media().hashCode());
            this.add(temp.media(), temp.rating());
        }
        return result;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        MediaRatings obj = (MediaRatings) o;

        if (this.numberOfRatings() != obj.numberOfRatings()) {
            return false;
        }

        int length = this.numberOfRatings();
        MediaRatings temp = this.newInstance();
        temp.transferFrom(this);
        for (int i = 0; i < length; i++) {
            MediaRatings.Pair thisPair = temp.removeAny();
            if (!obj.hasMedia(thisPair.media())) {
                return false;
            }
            MediaRatings.Pair objPair = obj.remove(thisPair.media());
            if (!(thisPair.rating() == (objPair.rating()))) {
                return false;
            }
            this.add(thisPair.media(), thisPair.rating());
            obj.add(objPair.media(), objPair.rating());
        }
        return true;
    }
}
