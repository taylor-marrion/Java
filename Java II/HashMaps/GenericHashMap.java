/* Filename: GenericHashMap.java
 * Author: Taylor Marrion
 * Date: 12/6/2019
 * Purpose: 
 */
 
 // Import statements
 import java.util.Map;
 import java.util.HashMap;

/**
* 
*/
public class GenericHashMap {
	
 public static void main(String[] args) {
	 
	 // create array
	 String[] arr = new String[]{"This", "is", "a", "test", "program.", "Please", "ignore", "for", "now"};
	 
	 // initialize HashMap
	 Map<String, Object> testHashMap = new HashMap <String, Object>();
	 
	 // populate HashMap
	 for (String str : arr) {
		 String key = str;
		 Object value = new Integer(str.length());
		 testHashMap.put(key, value);
	 } // end for-each loop
	 
	 System.out.println("Generic HashMap");
	 System.out.println("Word: length");
	 
	 // print each entry set to console
	 for (HashMap.Entry<String, Object> element : testHashMap.entrySet()) {
		 String key = element.getKey();
		 Object value = element.getValue();
		 System.out.println(key + ": " + value);
	 } // end for-each loop	 
	 	
 } // end method main
 
} // end class