package components.mediaratings;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * JUnit test fixture for MediaRatings1L kernel methods.
 */
public final class MediaRatings1LTest {
    /*
     * Test cases for kernel methods.
     */

    @Test
    public void testNewInstance() {
        MediaRatings test = new MediaRatings1L();
        MediaRatings testCopy = test.newInstance();

        assertEquals(testCopy, test);
    }

    @Test
    public void testClear() {
        MediaRatings test = new MediaRatings1L();
        MediaRatings testCopy = test.newInstance();
        test.add("media", 3);
        test.clear();

        assertEquals(testCopy, test);
    }

    @Test
    public void testTransferFrom() {
        MediaRatings test = new MediaRatings1L();
        MediaRatings test2 = new MediaRatings1L();
        MediaRatings testCopy = test.newInstance();
        test.add("media", 3);
        testCopy.add("media", 3);
        test2.transferFrom(test);

        assertEquals(testCopy, test2);
    }

    @Test
    public void testAdd() {
        MediaRatings test = new MediaRatings1L();
        MediaRatings testCopy = new MediaRatings1L();
        test.add("media", 3);
        testCopy.add("media", 3);
        assertEquals(testCopy, test);
    }

    @Test
    public void testRemove() {
        MediaRatings test = new MediaRatings1L();
        MediaRatings testCopy = new MediaRatings1L();
        test.add("media", 3);
        MediaRating pair = test.remove("media");
        MediaRating pairCopy = new MediaRating("media", 3);
        assertEquals(pairCopy, pair);
        assertEquals(testCopy, test);
    }

    @Test
    public void testNumberOfRatings() {
        MediaRatings test = new MediaRatings1L();

        test.add("media", 3);
        test.add("media2", 5);
        test.add("media3", 4);
        assertEquals(3, test.numberOfRatings());
    }

    @Test
    public void testRemoveAny() {
        MediaRatings test = new MediaRatings1L();
        test.add("media", 3);
        test.add("media2", 5);
        test.add("media3", 4);
        test.removeAny();
        assertEquals(2, test.numberOfRatings());
    }

    @Test
    public void testRating() {
        MediaRatings test = new MediaRatings1L();
        test.add("media", 3);
        test.add("media2", 5);
        test.add("media3", 4);
        int rating = test.rating("media3");
        int rating2 = test.rating("media2");

        assertEquals(5, rating2);
        assertEquals(4, rating);
    }

    @Test
    public void testHasMedia() {
        MediaRatings test = new MediaRatings1L();
        test.add("media", 3);
        test.add("media2", 5);
        test.add("media3", 4);
        boolean check = test.hasMedia("media3");
        boolean check2 = test.hasMedia("media4");

        assertEquals(true, check);
        assertEquals(false, check2);
    }

}
