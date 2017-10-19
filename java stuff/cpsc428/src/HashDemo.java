import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class HashDemo {
    
    //as with encryption, we create and initialize an object
    //that will execute the hash function
    public static MessageDigest md;
    
    //Truncated versions of hash; just take first few bytes of SHA-1
    //use strings instead of byte arrays as input and output
    //requires java.util.Arrays
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

        // SHA-1 is one of the most widely used hash functions
        // as with cipher object, only call getInstance once
        try { md = MessageDigest.getInstance("SHA-1");
        }
        catch(NoSuchAlgorithmException e) { e.printStackTrace();
        }

        //Hashing
        String input = "This is the message to be hashed";
        System.out.println("Message: " + input);
        System.out.println("SHA-1 Hash: " +byteArrayToHex(md.digest(input.getBytes())));
        //small change produces entirely different result
        input = "this is the message to be hashed";
        System.out.println("Message: " + input);
        System.out.println("Short Hash: " + H6(input));
            
        //Mapping
        HashMap<String, String> 
        map = new HashMap<String, String>();
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
            System.out.println("Don't know sound of " + animal );
        
    }


    //for displaying byte arrays
    public static String byteArrayToHex(byte [] array)
    {
        String s = new String();
        for(int i = 0; i < array.length; i++)
            s = s+String.format("%1$02X", array[i]);
        return s;
    }
}