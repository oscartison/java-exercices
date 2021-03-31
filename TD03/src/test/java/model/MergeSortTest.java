package model;

import g55315.model.MergeSort;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author oscar
 */
public class MergeSortTest {

    public MergeSortTest() {
    }

    @Test
    public void testMergeSort() {
        int[] actual = {5, 1, 6, 2, 3, 4};
        int[] expected = {1, 2, 3, 4, 5, 6};
        MergeSort m = new MergeSort(actual);
        m.sort(0, actual.length - 1);
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void testMergeSortPositive() {
        int[] actual = {5, -11, 6, -82, 3, 4};
        int[] expected = {-82, -11, 3, 4, 5, 6};
        MergeSort m = new MergeSort(actual);
        m.sort(0, actual.length - 1);
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void testMergeSortEmpty() {
        int[] actual = {};
        int[] expected = {};
        MergeSort m = new MergeSort(actual);
        m.sort(0, actual.length);
        assertArrayEquals(expected, actual);
    }

}
