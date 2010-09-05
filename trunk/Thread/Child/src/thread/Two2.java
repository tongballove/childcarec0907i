/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package thread;

/**
 *
 * @author SERVER
 */
public class Two2 {

    public  static void main(String [] ars){
        One o = new One();
        int num=10;
        Two t1 = new Two(o, num++);
        Two t2 = new Two(o, num++);

    }

}
