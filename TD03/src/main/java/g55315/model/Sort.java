package g55315.model;

/**
 *
 * @author oscar
 */
public abstract class Sort {
    
    protected int[] arr;
    protected long nbOperations;

    public Sort(int[] arr) {
        this.arr = arr;
        this.nbOperations = 0;
    }
}
