package g55315.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class MyThread extends Thread implements Observable {

    private List<Observer> listObservers;
    private int[] data;
    private long dur;
    private String sort;

    public MyThread(int[] data, String name, String sort,Observer obs) {
        super(name);
        this.data = data;
        listObservers = new ArrayList<>();
        listObservers.add(obs);
        this.sort = sort;
    }

    @Override
    public void addObserver(Observer obs) {
        listObservers.add(obs);
    }

    @Override
    public void notifyObservers() {
        notifyObservers(null);
    }

    @Override
    public void notifyObservers(Object arg) {
        for (Observer obs : listObservers) {
            obs.update(this, arg);
        }
    }

    @Override
    public void run() {
        synchronized(data) {
            LocalDateTime begin = LocalDateTime.now();
                if (sort.equals("Bubble sort")) {
                BubbleSort sorted = new BubbleSort(data);
                sorted.bubbleSort();
                LocalDateTime end = LocalDateTime.now();
                this.dur = Duration.between(begin, end).toMillis();
                this.notifyObservers(new StateSort(data.length, dur, sort, sorted.nbOperations));
            } else {
                MergeSort sorted = new MergeSort(data);
                sorted.sort(0, data.length - 1);
                LocalDateTime end = LocalDateTime.now();
                this.dur = Duration.between(begin, end).toMillis();
                this.notifyObservers(new StateSort(data.length, dur, sort, sorted.nbOperations));
       
        }
        }
    }

    public String getSort() {
        return sort;
    }

    public int getSize() {
        return data.length;
    }

    public long getDur() {
        return dur;
    }
}
