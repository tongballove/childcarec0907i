/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package LuyThua;

/**
 *
 * @author SERVER
 */
public class LuyThua extends Thread{
    int i;
    
    public LuyThua(int a){
        i = a;

    }
  
    public void run(){
          int sum =i;
        for(int j=1; j<i ;j++){
           
            sum *= i;
           /// System.out.println(i + "=" + sum);
        }
        System.out.println(i + "=" + sum);
    }

}
