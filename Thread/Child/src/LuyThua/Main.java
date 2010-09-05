/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package LuyThua;

/**
 *
 * @author SERVER
 */
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Main {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Nhap Vao A:");
        int a = scan.nextInt();
        System.out.println("Nhap vao B:");
        int b = scan.nextInt();

        for(int i=a ;i<=b;i++){
            try {
                LuyThua T = new LuyThua(i);
                T.start();
                T.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

}
