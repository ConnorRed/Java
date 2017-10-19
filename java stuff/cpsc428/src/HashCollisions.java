/*
 * @Author Connor Redmon
 * @Author Janai Norman
 * 
 * Problem: For this project, you will use the “birthday paradox” to search for collisions in a hash function. 
 * The file SHAdemo.java contains various things that will be useful for this assignment, including a demo 
 * of the java HashMap class. The birthday attack requires us to build up a large table of messages 
 * with known hash values and then repeatedly look for things in this table; HashMap lets us do this efficiently.
 * 
 * 	Solution: Unfortunately, we were unable to find the collisions with the H6 hash. However, we were able to detect 
 * hashes with the five-byte output. The way the attack works is by mapping the the first string to the hash map for referance.
 * After that we increment our second string and search for the hashed value in the table. If the value is found, it is printed. If
 * the value is not found, the hash will be put back into the table. This runs 100,000,000 times. This takes a couple of hours to 
 * completely finish.
 * 
 *  Collisions found (H5): 
 *  H5 Collision found: Bob owes Alice $371758
	D011C41BB4
	D011C41BB4
	H5 Collision found: Bob owes Alice $1168550
	22E7C08421
	22E7C08421
	H5 Collision found: Bob owes Alice $2486199
	7E67EFCC73
	7E67EFCC73
	H5 Collision found: Bob owes Alice $2919272
	0D71B5E8BA
	0D71B5E8BA
	H5 Collision found: Bob owes Alice $3501866
	61A37B6D53
	61A37B6D53
	H5 Collision found: Bob owes Alice $733930
	98E3FAEE1E
	98E3FAEE1E
	H5 Collision found: Bob owes Alice $1154765
	64D1E0B59C
	64D1E0B59C
	H5 Collision found: Bob owes Alice $117202
	6FFFC7617F
	6FFFC7617F
	H5 Collision found: Bob owes Alice $63865
	5463D23A0B
	5463D23A0B
	H5 Collision found: Bob owes Alice $1987180
	BB911A0F6C
	BB911A0F6C
	H5 Collision found: Bob owes Alice $5254480
	CAF25C8037
	CAF25C8037
	H5 Collision found: Bob owes Alice $3948637
	DFD5DF9F36
	DFD5DF9F36
	H5 Collision found: Bob owes Alice $3813506
	9B92DC71DF
	9B92DC71DF
	H5 Collision found: Bob owes Alice $5473904
	1848AF82D1
	1848AF82D1
	H5 Collision found: Bob owes Alice $5846669
	BA91E1D49A
	BA91E1D49A
	H5 Collision found: Bob owes Alice $6331251
	BB67EBFB7E
	BB67EBFB7E
	H5 Collision found: Bob owes Alice $2926908
	9455CFF53C
	9455CFF53C
	H5 Collision found: Bob owes Alice $186522
	A9A5043DBA
	A9A5043DBA
	H5 Collision found: Bob owes Alice $5801019
	95C7B4111A
	95C7B4111A
	H5 Collision found: Bob owes Alice $6502343
	81B6373621
	81B6373621
	H5 Collision found: Bob owes Alice $2874708
	9DC2E29C2A
	9DC2E29C2A
	H5 Collision found: Bob owes Alice $1899089
	AB8AEC31E6
	AB8AEC31E6
	H5 Collision found: Bob owes Alice $4463560
	C62A9250E6
	C62A9250E6
	H5 Collision found: Bob owes Alice $7436315
	19B574EE4C
	19B574EE4C
	H5 Collision found: Bob owes Alice $2585147
	E8D1780819
	E8D1780819
	H5 Collision found: Bob owes Alice $5510584
	524A7D9246
	524A7D9246
	H5 Collision found: Bob owes Alice $5820217
	CF73B336E3
	CF73B336E3
	H5 Collision found: Bob owes Alice $8383285
	F243007AE9
	F243007AE9
	H5 Collision found: Bob owes Alice $8022189
	E449DF8D5C
	E449DF8D5C
	H5 Collision found: Bob owes Alice $6207605
	BC8A389C42
	BC8A389C42
	H5 Collision found: Bob owes Alice $5120679
	279EA2A149
	279EA2A149
	H5 Collision found: Bob owes Alice $1786446
	83C0AF1570
	83C0AF1570
	H5 Collision found: Bob owes Alice $4730134
	77A4C2CD86
	77A4C2CD86
	H5 Collision found: Bob owes Alice $7558787
	6097415A6B
	6097415A6B
	H5 Collision found: Bob owes Alice $293869
	8C4E02ABC9
	8C4E02ABC9
	H5 Collision found: Bob owes Alice $1161783
	90A38FA733
	90A38FA733
	H5 Collision found: Bob owes Alice $5984992
	CE7EB61C4D
	CE7EB61C4D
	H5 Collision found: Bob owes Alice $1172747
	60FD9E3318
	60FD9E3318
 *  
 */
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;

public class HashCollisions {
	public static int hashingCounter = 1000;
	public static MessageDigest md;

	public static String H5(String msg) {
		return byteArrayToHex(Arrays.copyOfRange(md.digest(msg.getBytes()), 0,
				5));
	}

	public static String H6(String msg) {
		return byteArrayToHex(Arrays.copyOfRange(md.digest(msg.getBytes()), 0,
				6));

	}

	public static String byteArrayToHex(byte[] array) {
		String s = new String();
		for (int i = 0; i < array.length; i++)
			s = s + String.format("%1$02X", array[i]);
		return s;
	}

	public static void findH5Collisions() {
		String input1 = "Alice owes Bob $500";
		String input2 = "Bob owes Alice $";
		HashMap<String, String> map = new HashMap<String, String>();
		map.put(H5(input1), input1); // adds first hashed input to hashmap for
										// referance
		for (int i = 0; i <= 100000000; i++) {
			input2 = "Bob owes Alice $";
			input2 += "" + (i); // increments second string
			// System.out.println(input2);
			String hold2 = H5(input2); // hashes the incremented string
			// System.out.println(hold2);
			if (map.containsKey(hold2)) {
				System.out.println("H5 Collision found: "); // If
																				// the
																				// hash
																				// matches
																				// the
																				// first one, print
				System.out.println(input2);
				System.out.println(H5(input2));
				System.out.println(map.get(hold2));
				System.out.println(H5(map.get(hold2)));

				// break;
			} else {
				map.put((hold2), input2); // if not in hash map, put there for
											// comparison
			}

		}

	}

	public static void findH6Collisions() {
		String input1 = "Alice owes Bob $500";
		String input2 = "Bob owes Alice $";
		HashMap<String, String> map = new HashMap<String, String>();
		map.put(H6(input1), input1); // adds first hashed input to hashmap for
										// referance
		for (int i = 0; i <= 1000000000; i++) {
			input2 = "Bob owes Alice $";
			input2 += "" + (i); // increments second string
			// System.out.println(input2);
			String hold2 = H6(input2); // hashes the incremented string
			// System.out.println(hold2);
			if (map.containsKey(hold2)) {
				System.out.println(map.get((hold2))); // If the hash matches the
														// // first one, print
				System.out.println(H6(input2));
				System.out.println(H6(map.get(hold2)));

				// break;
			} else {
				map.put((hold2), input2); // if not in hash map, put there for
											// comparison
			}

		}

	}

	public static void main(String[] args) {
		try {
			md = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		findH5Collisions();
		findH6Collisions();
	}
}
