package g55315.view;

import java.util.List;
import g55315.model.MyThread;
import g55315.model.Observable;
import g55315.model.Observer;

/**
 *
 * @author oscar
 */
public class View implements Observer{
    private List<MyThread> thrdList;

    public View(List<MyThread> thrd) {
        this.thrdList = thrd;
    }

    @Override
    public synchronized void update(Observable observable, Object arg) {
        System.out.println("Fini");
        
        for(MyThread th : thrdList) {
            System.out.println(th.getName());
            System.out.println("Duree: " + th.getDur());
        }
        System.out.println("");
    }    
}
