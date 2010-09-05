/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package thread;

/**
 *
 * @author SERVER
 */

public class TestThread implements Runnable {
    int id;
    public TestThread(int id){
        this.id = id;
    }
    public void run(){
        for(int i=1; i<id; i++){
            System.out.println("Thead " + id +":" + i);
        }
    }
}
