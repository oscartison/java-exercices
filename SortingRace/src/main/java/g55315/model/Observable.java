package g55315.model;

/**
 *
 * @author aro
 */
public interface Observable {

    /**
     * add an observer to an observable.
     * @param obs the observer to add.
     */
    void addObserver(Observer obs);

    /**
     * notifies the observers that a change was done in the observable.
     */
    void notifyObservers();

    /**
     * notifies the observers that a change was done in the observable.
     * @param arg an argument to give to the observers
     */
    void notifyObservers(Object arg);

}
