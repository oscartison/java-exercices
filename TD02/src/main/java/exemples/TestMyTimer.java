package exemples;

/**
 * Classe de test de la classe MyTimer
 */
public class TestMyTimer {

    public static void main(String[] args) {
        MyTimer myTimer = new MyTimer(4000);
        myTimer.start();
        try {
            Thread.sleep(10001);
        } catch (InterruptedException e) {
            System.out.println("TestMyTimer: exception " + e);
        }
        myTimer.shouldRun = false;
        System.gc();
        System.out.println("MyTimer: gc called");
        System.out.println("MyTimer: end");
    }

}
