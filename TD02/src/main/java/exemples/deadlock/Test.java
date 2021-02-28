package exemples.deadlock;

//https://www.javatpoint.com/deadlock-in-java

import exemples.deadlock.Resource;
import exemples.deadlock.MyThread;

/**
 * Classe de test instanciant deux threads utilisant une methode a blocs
 * synchronises d'un meme objet.
 */
public class Test {

    public static void main(String[] args) {

        Resource mo = new Resource();
        Resource mo1 = new Resource();
        MyThread t1 = new MyThread("t1", mo,mo1);
        MyThread t2 = new MyThread("t2", mo1,mo);

        t1.start();
        t2.start();
    }
}

