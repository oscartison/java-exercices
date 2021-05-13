package model;

import g55315.model.BubbleSort;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author oscar
 */
public class BubbleSortTest {

    public BubbleSortTest() {
    }

    @Test
    public void testBubbleSort() {
        int[] actual = {5, 1, 6, 2, 3, 4};
        int[] expected = {1, 2, 3, 4, 5, 6};
        BubbleSort b = new BubbleSort(actual);
        b.bubbleSort();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testBubbleSortPositive() {
        int[] actual = {5, -11, 6, -82, 3, 4};
        int[] expected = {-82, -11, 3, 4, 5, 6};
        BubbleSort b = new BubbleSort(actual);
        b.bubbleSort();
        assertArrayEquals(expected, actual);
    }
    
        @Test
    public void testMergeSortEmpty() {
        int[] actual = {};
        int[] expected = {};
        BubbleSort b = new BubbleSort(actual);
        b.bubbleSort();
        assertArrayEquals(expected, actual);
    }

}
