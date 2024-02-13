/* Filename: AP16.java
 * Author: Taylor Marrion
 * Date: March 1, 2022
 * Purpose: 
 */
 
 // Import statements
 //import java.util.*;
 import java.util.Arrays;
 import java.util.HashMap;
 import java.util.Random;

/**
* 
*/
public class AP16 {
	
	static final int BYTE_LENGTH = 8;
	
	static int reverseBits(int x){
		int result = 0;
		
		while (x > 0) {
			result <<= 1;
			result += (x & 1);
			x >>= 1;
		}
		
		return result;
	} // end reverseBits
	
	/* reverse bits, retaining length of n bits */
	static int reverseBits(int x, int n){
		int result = 0;
		for (int i = 0; i < n; i++){
			result <<= 1;
			result += (x & 1);
			x >>= 1;
		}
		return result;
	} // end reverseBits
	
	/* reverse bits, retaining length of n bits */
	static char reverseBits(char x, int n){
		char result = 0;
		for (int i = 0; i < n; i++){
			result <<= 1;
			result += (x & 1);
			x >>= 1;
		}
		return result;
	} // end reverseBits
	
	/* reverse bits, retaining length of n bits */
	static byte reverseBits(byte x, int n){
		byte result = 0;
		for (int i = 0; i < n; i++){
			result <<= 1;
			result += (x & 1);
			x >>= 1;
		}
		return result;
	} // end reverseBits
	
	static byte badHashV2(String str){
		byte result = 0;
		byte[] arr = str.getBytes();
		
		for (int i = 0; i < arr.length; i++){
			result ^= arr[i];
			result ^= reverseBits(result, BYTE_LENGTH);
		}
		
		return result;
	} // end badHashV2
	
	static String randomString(){
		
		String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
		String alphaNumeric = upperAlphabet + lowerAlphabet + numbers;
		
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		int length = 10;
		
		for(int i = 0; i < length; i++) {
			int index = random.nextInt(alphaNumeric.length());
			char randomChar = alphaNumeric.charAt(index);
			sb.append(randomChar);
		}
		
		return sb.toString();
	} // end randomString
	
 public static void main(String[] args) {
	 
	 // Display a Welcome note
	 System.out.println("Hi!");
	 
	 // Start code
	 
	 // Problem 1
	 System.out.println("\n========= Problem 1 - Set Up =========");
	 // String to array of chars
	 String str_0 = "Hash";
	 char[] arr_0 = str_0.toCharArray();
	 System.out.println(Arrays.toString(arr_0));
	 byte[] bytes_0 = str_0.getBytes();
	 System.out.println(Arrays.toString(bytes_0));
	 
	 // test int reverseBits
	 int num1 = 13;
	 int num2 = reverseBits(num1, BYTE_LENGTH);
	 System.out.println("Test int 13: " + Integer.toBinaryString(num1));
	 System.out.println("Reversed: " + Integer.toBinaryString(num2));
	 
	 // test char reverseBits
	 char c1 = 0b01100001;	// 'a'
	 char c2 = reverseBits(c1, BYTE_LENGTH);
	 System.out.println("Test char 'a': " + Integer.toBinaryString(c1));
	 System.out.println("Reversed char: " + Integer.toBinaryString(c2));
	 
	 // test byte for reverseBits
	 byte b1 = 0b01100010;
	 byte b2 = reverseBits(b1, BYTE_LENGTH);
	 System.out.println("Test byte 'b': " + Integer.toBinaryString(b1));
	 System.out.println("Reversed byte: " + Integer.toBinaryString(b2));
	 
	 // test badHashV2
	 byte hash_0 = badHashV2(str_0);
	 String hashBits_0 = String.format("%8s", Integer.toBinaryString(hash_0)).replace(' ', '0');
	 System.out.println("BadHashv2 of \"" + str_0 + "\": " + hash_0 + " = 0b" + hashBits_0);
	 
	 System.out.println("\n========= Problem 1 - Part a =========");
	 // String to array of chars
	 String str_1a = "Cyber";
	 char[] arr_1a = str_1a.toCharArray();
	 System.out.println(Arrays.toString(arr_1a));
	 byte[] bytes_1a = str_1a.getBytes();
	 System.out.println(Arrays.toString(bytes_1a));
	 
	 // test badHashV2
	 byte hash_1a = badHashV2(str_1a);
	 String hashBits_1a = String.format("%8s", Integer.toBinaryString(hash_1a)).replace(' ', '0');
	 System.out.println("BadHashv2 of \"" + str_1a + "\": " + hash_1a + " = 0b" + hashBits_1a);
	 
	 System.out.println("\n========= Problem 1 - Part c =========");
	 HashMap<Integer, String> stringHashes = new HashMap<Integer, String>();
	 for (int i = 0; i < 16; i++){
		 String tempStr = randomString();
		 int tempHash = badHashV2(tempStr);
		 
		 if (stringHashes.containsKey(tempHash)){
			 System.out.println("Collision!");
		 }
		 
		 stringHashes.put(tempHash, tempStr);
		 String tempHashBits = String.format("%8s", Integer.toBinaryString(tempHash)).replace(' ', '0');
		 System.out.println("BadHashv2 of \"" + tempStr + "\": " + tempHash + " = 0b" + tempHashBits);
		 
	 }
	 
	 // Display a Goodbye note
	 System.out.println("\nGoodbye!");

 } // end method main
 
} // end class