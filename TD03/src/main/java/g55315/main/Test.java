package g55315.main;

//package main;
//
//import java.util.ArrayList;
//import java.util.List;
//import model.MyThread;
//import view.View;
//
///**
// *
// * @author oscar
// */
//public class Test {
//    public static void main(String[] args) {
//      List<MyThread> list = new ArrayList<>();
//      View v = new View(list);
//      
//      for(int i = 0;i <10; i++) {      
//          int [] data = {1,5,6,2,10,22,2,88,99};
//          list.add(new MyThread(data, "Thread"+i+1, "Bubble sort"));
//          list.get(i).addObserver(v);
//      }
//      
//      for(MyThread myT: list) {
//      //    myT.setDaemon(true);
//          myT.start();
//          
//      }
//    }
//    
//}
