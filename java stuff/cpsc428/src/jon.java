import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class jon {
    
	
	//as with encryption, we create and initialize an object
	//that will execute the hash function
	public static MessageDigest md;
	
	//Truncated versions of hash; just take first few bytes of SHA-1
	//use strings instead of byte arrays as input and output
	//requires java.util.Arrays
	
	//for displaying byte arrays
		public static String byteArrayToHex(byte [] array)
		{
			String s = new String();
			for(int i = 0; i < array.length; i++)
				s = s+String.format("%1$02X", array[i]);
			return s;
		}
		
	public static String H5(String msg){
		return byteArrayToHex(
				Arrays.copyOfRange(md.digest(msg.getBytes()), 0, 5)
						 );
	}
	public static String H6(String msg){
		return byteArrayToHex(
				Arrays.copyOfRange(md.digest(msg.getBytes()), 0, 6)
						 );
	}	
	public static String H7(String msg){
		return byteArrayToHex(
				Arrays.copyOfRange(md.digest(msg.getBytes()), 0, 7)
						 );
	}
	
	public static void main(String[] args){

	    String msg1 = "Alice owes Bob 500 dollars";
	    HashMap<String, String> map = new HashMap<String, String> ();
	    map.put(H5(msg1), msg1);
	    
	    for(int i = 0; i < 10000000; i++){
	        String tmp = "Bob owes Alice" + i + "Dollars";
	        if (map.containsKey(H5(tmp))){
	            System.out.println("With: " + tmp + " and " + map.get(H5(tmp)));
	            map.put(H5(tmp), tmp);
	            
            }
	        else{
	            map.put(H5(tmp), tmp);
	        }
        }

    
		
		/*//Mapping
		HashMap<String, String> map = new HashMap<String, String>();
		//insert into table with map.put(KEY, VALUE); 
		//then use map.get(KEY) to retrieve VALUE
		//lookup is very fast (constant time) even for large table
		map.put("cow",  "moo");
		map.put("duck", "quack");
		map.put("dog",  "bark");
		map.put("giraffe", " ");
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter an animal:");
		String animal = scanner.nextLine();
		scanner.close();
		if (map.containsKey(animal))
			System.out.println("Sound of " + animal + " is " + map.get(animal));
		else
			System.out.println("Don't know sound of " + animal );*/
		
	}
}