package exemples.deadlock;

/**
 * Thread utilisant une methode d'une instance de MyObject
 */
public class MyThread extends Thread {

    private Resource myObject;
    private Resource myObject2;

    public MyThread(String name, Resource myObject, Resource myObject2) {
        super(name);
        this.myObject = myObject;
        this.myObject2 = myObject2;
    }

    public void run() {
        synchronized (myObject) {
            System.out.println("Thread: locked resource 2");

            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }

            synchronized (myObject2) {
                System.out.println("Thread: locked resource 1");
            }
        }
    }
}
