package g55315.model;

import java.time.Duration;

/**
 * class that represents the state of a sort
 * @author oscar
 */
public class StateSort {
    private int size;
    private long dur;
    private String sort;
    private long nbOperations;

    /**
     * constructor of the state of a sort
     * @param size the size of the array
     * @param dur the duration of the sort
     * @param sort the sort algorithm
     * @param nbOperations the number of operations for 1 sorts
     */
    public StateSort(int size, long dur, String sort, long nbOperations) {
        this.size = size;
        this.dur = dur;
        this.sort = sort;
        this.nbOperations = nbOperations;
    }

    /**
     * a getter for the size og the arrau
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * a getter for the duration of a sort
     * @return the duration
     */
    public long getDur() {
        return dur;
    }

    /**
     * a getter for the name of the sort algorithm
     * @return the sort algorithm
     */
    public String getSort() {
        return sort;
    }

    /**
     * a getter for the number of oberations in the sort
     * @return the number of operations
     */
    public long getNbOperations() {
        return nbOperations;
    }
    
    
    
}
