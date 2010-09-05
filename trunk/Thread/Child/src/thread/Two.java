/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package thread;

/**
 *
 * @author SERVER
 */

public class Two implements Runnable {

    int number;
    One objOne;
    Thread objth;
    public Two(One one_num, int num){
        objOne = one_num;
        number = num;
        objth = new Thread(this);
        objth.start();
    }
    public void run() {
       // throw new UnsupportedOperationException("Not supported yet.");
        objOne.Display(number);

        
    }

}
