package exemples;

/**
 * Creation d'une classe thread par derivation de la classe Thread
 */
public class MyThread extends Thread {

    private String name;

    public MyThread(String s) {
        this.name = s;
    }

    public void run() {
        for (int i = 0; i < 10000; ++i) {
            for (int j = 0; j < 50000; ++j) ;
            System.out.println("MyThread: " + name + " : " + i);
        }
    }
}
