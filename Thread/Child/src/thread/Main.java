/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package thread;

/**
 *
 * @author SERVER
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
       // TestThread T = new TestThread(1);
        //T.start();
        //T.join();
        Thread T1 = new Thread(new TestThread(1));
        Thread T2 = new Thread(new TestThread(2));
        T1.start();
        T2.start();
        T1.join();
        T2.join();
    }

}
