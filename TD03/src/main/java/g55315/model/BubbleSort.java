package g55315.model;

/**
 *
 * @author oscar
 */
public class BubbleSort extends Sort{

    public BubbleSort(int[] arr) {
        super(arr);
    }

    /**
     * Algo du cours DEV1
     *
     * @param myArray
     */
    public void bubbleSort() {
        int n = arr.length;
        nbOperations++;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[j] 
                    int temp = arr[j];
                    nbOperations++;

                    arr[j] = arr[j + 1];
                    nbOperations++;

                    arr[j + 1] = temp;
                    nbOperations++;

                }
            }
        }
    }
}
