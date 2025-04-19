package components.mediaratings;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * JUnit test fixture for MediaRatings's secondary methods.
 *
 * @author Wes Waterstreet
 *
 */
public final class MediaRatingsTest {
    /*
     * Test cases for secondary methods.
     */

    @Test
    public void testUpdateRating() {
        MediaRatings test = new MediaRatings1L();
        MediaRatings testCopy = test.newInstance();
        test.add("Media", 2);
        testCopy.add("Media", 4);
        test.updateRating("Media", 4);

        assertEquals(testCopy, test);
    }

    @Test
    public void testAllRatings() {
        MediaRatings test = new MediaRatings1L();
        MediaRatings testCopy = test.newInstance();
        test.add("Media", 2);
        test.add("Media2", 4);
        test.add("Media3", 5);
        test.add("Media4", 4);
        test.add("Media5", 4);

        testCopy.add("Media2", 4);
        testCopy.add("Media4", 4);
        testCopy.add("Media5", 4);

        MediaRatings testFour = test.allRatings(4);

        assertEquals(testCopy, testFour);
    }

    @Test
    public void testToString() {
        MediaRatings test = new MediaRatings1L();
        test.add("Media", 2);
        String stringTest = test.toString();

        assertEquals("<Media, 2>", stringTest);
    }

    @Test
    public void testEquals() {
        MediaRatings test = new MediaRatings1L();
        MediaRatings testCopy = new MediaRatings1L();
        test.add("Media", 2);
        testCopy.add("Media", 2);
        boolean check = test.equals(testCopy);

        assertEquals(true, check);
    }

    @Test
    public void testEquals2() {
        MediaRatings test = new MediaRatings1L();
        MediaRatings testCopy = new MediaRatings1L();
        test.add("Media", 2);
        testCopy.add("Medias", 2);
        boolean check = test.equals(testCopy);

        assertEquals(false, check);
    }

    @Test
    public void testEquals3() {
        MediaRatings test = new MediaRatings1L();
        MediaRatings testCopy = new MediaRatings1L();
        test.add("Media", 2);
        testCopy.add("Media", 3);
        boolean check = test.equals(testCopy);

        assertEquals(false, check);
    }

    @Test
    public void testHashCode() {
        MediaRatings test = new MediaRatings1L();
        MediaRatings testCopy = new MediaRatings1L();
        String media = "Media";
        test.add(media, 2);
        testCopy.add(media, 2);
        int testHash = test.hashCode();
        int testCopyHash = testCopy.hashCode();

        assertEquals(testCopyHash, testHash);
        assertEquals(media.hashCode(), testHash);
    }

}
