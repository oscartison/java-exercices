package g55315.model;

/**
 *
 * @author oscar
 */
public class MergeSort extends Sort {

    public MergeSort(int[] arr) {
        super(arr);
    }

    /**
     * function that sorts an array using merge sort
     * @param l the left side of the array
     * @param m rhe middle of the array
     * @param r the ride side of the array
     */
    //https://www.geeksforgeeks.org/merge-sort/
    public void merge(int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        nbOperations++;
        int n2 = r - m;
        nbOperations++;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];
        nbOperations++;
        nbOperations++;

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
        }
        nbOperations++;

        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
        }
        nbOperations++;

        /* Merge the temp arrays */
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
        nbOperations++;

        // Initial index of merged subarry array
        int k = l;
        nbOperations++;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                nbOperations++;

                arr[k] = L[i];
                nbOperations++;

                i++;
                nbOperations++;

            } else {
                arr[k] = R[j];
                nbOperations++;

                j++;
                nbOperations++;

            }
            k++;
            nbOperations++;

        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            nbOperations++;

            arr[k] = L[i];
            nbOperations++;

            i++;
            nbOperations++;

            k++;
            nbOperations++;

        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            nbOperations++;

            arr[k] = R[j];
            nbOperations++;

            j++;
            nbOperations++;

            k++;
            nbOperations++;

        }
    }

    /**
     * sorts an array
     * @param l the begin of the array
     * @param r the end of the array
     */
    // Main function that sorts arr[l..r] using
    // merge()
    public void sort(int l, int r) {
        if (l < r) {
            nbOperations++;

            // Find the middle point
            int m = l + (r - l) / 2;
            nbOperations++;

            // Sort first and second halves
            sort( l, m);
            sort( m + 1, r);

            // Merge the sorted halves
            merge(l, m, r);
        }
    }

}
