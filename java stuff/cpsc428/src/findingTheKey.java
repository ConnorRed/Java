/*
 * @Author Connor Redmon
 * 
 * This is the solution to problem #3 , "Find The Key".
 * Problem Statement: 
 * Given are:
        Given are:
               Plaintext in ASCII: Captains
               The corresponding ciphertext: BB, 73, 05, D7, 82, E7, 23, 85
               The first four bytes of the Key:  90, 4E, F2, CC
What is the complete key used in this encryption? 

 * 
 * Answer(takes about 10-15mins):
 * [90, 4E, F2, CC, 4B, 8F, 29, 2E]
 *  
 */
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class findingTheKey {
    public static byte[] answer;
    public static byte[] temp;
    public static byte[] pt;
    public static byte[] keyBytes = new byte[] { (byte) 0x90, (byte) 0x4E, (byte) 0xF2,
            (byte) 0xCC, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00 };
    public static byte[] ct = new byte[] { (byte) 0xBB, (byte) 0x73, (byte) 0x05, (byte) 0xD7,
            (byte) 0x82, (byte) 0xE7, (byte) 0x23, (byte) 0x85 };
 

    /*
     * Print out a byte array in hex format
     */
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
    

    public static void main(String[] args) 
    {
        Cipher cipher;
        SecretKeySpec key;
        
        // Here comes the plaintext block (also, 64 bits --> 8 bytes)...
        String ptString = new String("Captains");       
        System.out.println("plaintext: "+ptString);
        pt = ptString.getBytes();
        // Set up the key so it can be used in the algorithm
        key = new SecretKeySpec(keyBytes, "DES");
        
        try {           
            cipher = Cipher.getInstance("DES/ECB/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            temp = cipher.doFinal(pt);
            System.out.println("New Ciphertext Bytes in Hex:");
            printByteArray(temp);
            
            
            if (Arrays.equals(answer, null)) {
                int count = 0;
                for (int i = 0; i < 256; i++) {
                    keyBytes[4] += 1;
                    key = new SecretKeySpec(keyBytes, "DES");
                    cipher.init(Cipher.ENCRYPT_MODE, key);
                    temp = cipher.doFinal(pt);
                    if (Arrays.equals(temp, ct)) {
                        answer = keyBytes;
                        break;
                    }
                    if (Arrays.equals(answer, null)) {
                        for (int j = 0; j < 256; j++) {
                            keyBytes[5] += 1;
                            key = new SecretKeySpec(keyBytes, "DES");
                            cipher.init(Cipher.ENCRYPT_MODE, key);
                            temp = cipher.doFinal(pt);
                            if (Arrays.equals(temp, ct)) {
                                answer = keyBytes;
                                break;
                            }
                            if (Arrays.equals(answer, null)) {
                                for (int k = 0; k < 256; k++) {
                                    keyBytes[6] += 1;
                                    key = new SecretKeySpec(keyBytes, "DES");
                                    cipher.init(Cipher.ENCRYPT_MODE, key);
                                    temp = cipher.doFinal(pt);
                                    if (Arrays.equals(temp, ct)) {
                                        answer = keyBytes;
                                        break;
                                    }
                                    if (Arrays.equals(answer, null)) {
                                        for (int l = 0; l < 256; l++) { 
                                            keyBytes[7] += 1;
                                            key = new SecretKeySpec(keyBytes, "DES");
                                            cipher.init(Cipher.ENCRYPT_MODE, key);
                                            temp = cipher.doFinal(pt);
                                            count++;
                                            if (Arrays.equals(temp, ct)) {
                                                answer = keyBytes;
                                                break;
                                            }
                                            else if (count % 5000000 == 0) {
                                                System.out.println(count);
                                                printByteArray(keyBytes);
                                            }
                                        }
                                    }
                                    else {
                                        break;
                                    }
                                }
                            }
                            else {
                                break;
                            }
                        }
                    }
                    else {
                        break;
                    }
                }
            }
            System.out.println("New KeyBytes in Hex:");
            printByteArray(keyBytes);
            System.out.println("Answer in Hex:     This is the answer");
            printByteArray(answer);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}