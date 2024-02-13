/* Filename: NonGenericHashMap.java
 * Author: Taylor Marrion
 * Date: 12/6/2019
 * Purpose: 
 */
 
 // Import statements
 import java.util.Map;
 import java.util.HashMap;
 import java.util.Iterator;

/**
* 
*/
public class NonGenericHashMap {
	
 public static void main(String[] args) {
	 
	 // create array
	 String[] arr = new String[]{"This", "is", "a", "test", "program.", "Please", "ignore", "for", "now"};
	 
	 // the following line will cause program to not compile
	 //Map testHashMap = new HashMap();
	 
	 // initialize HashMap
	 Map<String, Integer> testHashMap = new HashMap <String, Integer>();
	 
	 // populate HashMap
	 for (int i = 0; i < arr.length; i++) {
		 String key = arr[i];
		 Integer value = new Integer(key.length());
		 testHashMap.put(key, value);
	 } // end for loop
	 
	 System.out.println("Non-Generic HashMap");
	 System.out.println("Word: length");
	 
	 // iterate through to print each entry set
	 Iterator it = testHashMap.entrySet().iterator();
	 while (it.hasNext()) {
		 HashMap.Entry pair = (HashMap.Entry)it.next();
		 Object key = pair.getKey();
		 Object value = pair.getValue();
		 System.out.println(key + ": " + value);
	 } // end while loop
	 
 } // end method main
 
} // end class