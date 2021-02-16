/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemples;

public class DeamonThread extends Thread {

    public void run() {
        for (int n = 0; n < 42; ++n) {
            System.out.println("DaemonThread: run " + n);
            try {
                sleep(420);
            } catch (InterruptedException e) {
                System.out.println("DaemonThread thread: exception " + e);
            }
        }
    }

    public static void main(String[] args) {
        DeamonThread d;
        d = new DeamonThread();
        d.setDaemon(true);
        d.start();
        try {
            System.out.println("DaemonThread main: i do nothing during a while");
            sleep(0);
             d.join();
        } catch (InterruptedException e) {
            System.out.println("DaemonThread: exception " + e);
        }
    }
}
