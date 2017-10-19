/*
 * @Author Connor Redmon
 * 
 * This is the solution to problem #4 , "Code Breaking".
 * Problem Statement: 
 *Given are:
        Here is the story: 
            •   You have overheard following encrypted message given in hex format: E1, 6E, A5, 77, AF, 54, 39, 04
            •   You know that the message is readable text containing only letters (upper and lower case) and spaces.
            •   Finally, your team of spies has managed to patch together some shards from a paper shredder to recover the first five bytes of the key.  They are: BA, 54, 68, 08, 12. 
What is the complete message in text format (ASCII)? What is the rest of the key?

 * 
 * Answer:
 * 
 * 
 *  
 */
import java.util.ArrayList;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class codeBreaking {
    public static void printByteArray(byte [] array)
    {
    System.out.print("[");
    for(int i = 0; i < array.length-1; i++)
    {
        System.out.print(Integer.toHexString((array[i]>>4)&0x0F).toUpperCase());
        System.out.print(Integer.toHexString(array[i]&0x0F).toUpperCase() + ", ");
    }
    System.out.print(Integer.toHexString(array[array.length-1]>>4&0x0F).toUpperCase());
    System.out.println(Integer.toHexString(array[array.length-1]&0x0F).toUpperCase() + "]");
    }

public static boolean incrementByteArrayByOne(byte [] b) {    
    // starting from back, add one and check if carry over
      // if no carry over, stop and return
      // if carry over, increment next byte and check again
        for(int i = b.length-1; i>=0  ; i--){
            b[i]++;
            if(b[i] != 0x00){
                return false;
                }
            }   
    return true;
    }



public static void main(String[] args) 
{
    Cipher cipher;
    SecretKeySpec key;
    
    byte[] keyBytes = new byte[] {(byte) 0xBA, (byte) 0x54, (byte) 0x68, (byte) 0x08, (byte) 0x12, (byte) 0x00, (byte) 0x00, (byte) 0x00};
    byte[] ct = new byte[] {(byte) 0xE1, (byte) 0x6E, (byte) 0xA5, (byte) 0x77, (byte) 0xAF, (byte) 0x54, (byte) 0x39, (byte) 0x04};
    byte[] pt = new byte[] {(byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00};

    //key = new SecretKeySpec(keyBytes, "DES");
    
  //boolean to control while loop
    boolean stop = false;
    
    //while loop to run through keys
    while (!stop) {
        
        //increments array and stops when all possible combinations completed
        stop = incrementByteArrayByOne(keyBytes);

        //creates new key
        key = new SecretKeySpec(keyBytes, "DES");

        try {

            cipher = Cipher.getInstance("DES/ECB/NoPadding");

            cipher.init(Cipher.DECRYPT_MODE, key);

            pt = cipher.doFinal(ct);
            String plainString = new String(pt);
            
            //variable to count letters
            int count = 0;
            //for loop to check for letters, numbers, and whitespace
            for (int i = 0; i < plainString.length(); i++) {
                //if statement to check for numbers, letters, and whitespace
                if (Character.isLetterOrDigit(plainString.charAt(i))
                        || Character.isWhitespace(plainString.charAt(i))) 
                    //increments the letter count
                    count++;
            }
            //checks for the correct word length
            if (count == 8)
            {
                //prints text for later analysis
                printByteArray(keyBytes);
                System.out.println(plainString);
        }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
}