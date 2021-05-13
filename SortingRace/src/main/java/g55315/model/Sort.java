package g55315.model;

/**
 * abstract class that represents a sort
 * @author oscar
 */
public abstract class Sort {
    
    protected int[] arr;
    protected long nbOperations;

    /**
     * the constructor of the class
     * @param arr the array to sort
     */
    public Sort(int[] arr) {
        this.arr = arr;
        this.nbOperations = 0;
    }
}
