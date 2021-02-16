/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemples;

/**
 *
 * @author oscar
 */
public class MyRunnable implements Runnable {
    private String name;
    
    public MyRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 10000000; ++j) ;
            System.out.println("MyRunnable: " + name + " : " + i);
        }
    }
}
    
    
