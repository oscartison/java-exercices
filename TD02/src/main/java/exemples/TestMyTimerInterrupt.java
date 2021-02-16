/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemples;

public class TestMyTimerInterrupt {

    public static void main(String[] args) {
        MyTimerInterrupt myTimer = new MyTimerInterrupt(1000);
        myTimer.start();
        try {
            Thread.sleep(7011);
        } catch (InterruptedException e) {
            System.out.println("TestMytimer: exception " + e);
        }
        myTimer.interrupt();
    }
}
