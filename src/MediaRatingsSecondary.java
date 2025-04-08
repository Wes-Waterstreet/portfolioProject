/**
 * Layered implementations of secondary methods for {@code MediaRatings}.
 */
public abstract class MediaRatingsSecondary implements MediaRatings {

    @Override
    public void updateRating(String media, int rating) {
        this.remove(media);
        this.add(media, rating);
    }

    @Override
    public MediaRatings allRatings(int rating) {
        MediaRatings result = this.newInstance();
        for (int i = 0; i < this.numberOfRatings(); i++) {
            MediaRatings.Pair<String, Integer> temp = this.removeAny();
            if (temp.rating() == rating) {
                result.add(temp.media(), rating);
            }
            this.add(temp.media(), temp.rating());
        }
        return result;
    }

    @Override
    public String toString() {
        String value = "";
        int length = this.length();
        for (int i = 0; i < length; i++) {
            MediaRatings temp = this.removeAny();
            value.concat("<");
            value.concat(temp.media.toString());
            value.concat(", ");
            value.concat(temp.rating.toString());
            value.concat(">");
            value.concat(", ")
            this.add(temp);
        }
        return value;
    }

    @Override
    public int hashCode() {
        int result = 1;
        int length = this.length();
        for (int i = 0; i < length; i++) {
            MediaRatings temp = this.removeAny();
            result += (temp.media.hashCode());
            this.add(temp);
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MediaRatings<T> obj = (MediaRatings<T>) o;

        if (this.length() != obj.length()) {
            return false;
        }

        int length = this.length();
        for (int i = 0; i < length; i++) {
            MediaRatings thisItem = this.remove();
            MediaRatings otherItem = obj.remove();
            if (!thisItem.equals(otherItem)) {
                return false;
            }
            this.add(thisItem);
            obj.add(otherItem);
        }
        return true;
    }
}
