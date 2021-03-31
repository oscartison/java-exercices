package g55315.model;

import java.time.Duration;

/**
 *
 * @author oscar
 */
public class StateSort {
    private int size;
    private long dur;
    private String sort;
    private long nbOperations;

    public StateSort(int size, long dur, String sort, long nbOperations) {
        this.size = size;
        this.dur = dur;
        this.sort = sort;
        this.nbOperations = nbOperations;
    }

    public int getSize() {
        return size;
    }

    public long getDur() {
        return dur;
    }

    public String getSort() {
        return sort;
    }

    public long getNbOperations() {
        return nbOperations;
    }
    
    
    
}
