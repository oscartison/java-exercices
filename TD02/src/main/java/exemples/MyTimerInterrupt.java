/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemples;

public class MyTimerInterrupt extends Thread {

    private int laps;

    public MyTimerInterrupt(int laps) {
        this.laps = laps;
    }

    @Override
    public void run() {
        while (!interrupted()) {
            try {
                System.out.println("MyTimer: not interrupted");
                sleep(laps);
            } catch (InterruptedException e) {
                System.out.println("MyTimer: exception " + e);
                return;   // essayer avec et sans ce return !
            }
        }
    }
}
