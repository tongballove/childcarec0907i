/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package thread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SERVER
 */
public class One {
    synchronized void Display(int num){
        try {
            System.out.println("Enter Praments : " + num);
            Thread.sleep(1000);
            if (num == 11) {
                System.out.println("Hellword :");
            }
            Thread.sleep(1000);
            if (num == 10) {
                System.out.println("Xin Chao :");
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(One.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
