package exemples;

public class TestMyThread {

    public static void main(String[] args) {
        MyRunnable r = new MyRunnable("one");
        Thread t = new Thread(r);
        t.start();
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 10000000; ++j) ;
            System.out.println("TestMyRunnable: " + i);
        }
        new Thread(() -> {
            for (int i = 0; i < 10; ++i) {
                for (int j = 0; j < 50000; ++j) ;
                System.out.println("MyThread: lambda: " + i);
                // System.out.println("MyThread: " + name + ": " + i);
            }
        }).start();

        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 50000; ++j) ;
            System.out.println("TestMyThread: " + i);
        }
    }

}
