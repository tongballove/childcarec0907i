/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI.Component;

/**
 *
 * @author Nguyen Dinh Tan
 */



import java.security.*;

public class MD5Password {

    public static String getEncodedPassword(String clearTextPassword)
            throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");

        md.update(clearTextPassword.getBytes());

        return HexString.bufferToHex(md.digest());
    }

    public static boolean testPassword(String clearTextTestPassword,
            String encodedActualPassword)
            throws NoSuchAlgorithmException {
        String encodedTestPassword = MD5Password.getEncodedPassword(
                clearTextTestPassword);

        return (encodedTestPassword.equals(encodedActualPassword));
    }
//
//    public static void main(String args[]) {
//        try {
//            System.out.println(getEncodedPassword("A04398"));
//        } catch (NoSuchAlgorithmException ne) {
//            ne.printStackTrace();
//        }
//    }

    
}
