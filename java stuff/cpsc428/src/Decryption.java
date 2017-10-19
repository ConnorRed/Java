/*
 * @Author Connor Redmon
 * 
 * This is the solution to problem #2 , "Decryption".
 * Problem Statement: 
 *Given are:
			8 characters of ciphertext: 2C, 80, 18, C5, DE, 10, CF, 07
			Note: This is again exactly one block size.
			Key bytes: 46, AA, 20, 1E, F4, 3C, 92, D2
What is the decoded plaintext? Specify it as a character string (using ASCII). 
Note: If everything worked, the plaintext should really be readable as ordinary English text
 * 
 * Answer:
 * 	plaintext bytes:
	Readable
 * 
 * 	
 */

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Decryption {

	/*
	 * Print out a byte array in hex format
	 */
	public static void printByteArray(byte[] array) {
		System.out.print("[");
		for (int i = 0; i < array.length - 1; i++) {
			System.out.print(Integer.toHexString((array[i] >> 4) & 0x0F)
					.toUpperCase());
			System.out.print(Integer.toHexString(array[i] & 0x0F).toUpperCase()
					+ ", ");
		}
		System.out.print(Integer.toHexString(
				array[array.length - 1] >> 4 & 0x0F).toUpperCase());
		System.out.println(Integer.toHexString(array[array.length - 1] & 0x0F)
				.toUpperCase() + "]");
	}

	public static void main(String[] args) {
		Cipher cipher;
		SecretKeySpec key;

		byte[] keyBytes;
		byte[] pt;
		byte[] ct;

		keyBytes = new byte[] { (byte) 0x46, (byte) 0xAA, (byte) 0x20,
				(byte) 0x1E, (byte) 0xF4, (byte) 0x3C, (byte) 0x92, (byte) 0xD2 };
		ct = new byte[] { (byte) 0x2C, (byte) 0x80, (byte) 0x18, (byte) 0xC5,
				(byte) 0xDE, (byte) 0x10, (byte) 0xCF, (byte) 0x07 };

		// Set up the key so it can be used in the algorithm
		key = new SecretKeySpec(keyBytes, "DES");

		try {
			// Create the actual DES cipher, in Electronic Code Book mode, with
			// no padding
			cipher = Cipher.getInstance("DES/ECB/NoPadding");

			// Initialize the cipher with the key and set it up for decryption
			cipher.init(Cipher.DECRYPT_MODE, key);

			// Decrypt the ciphertext
			pt = cipher.doFinal(ct);

			// Display the plaintext
			System.out.println("plaintext bytes:");
			String printString = new String(pt);
			System.out.println(printString);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}