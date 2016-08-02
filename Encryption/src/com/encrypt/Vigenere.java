package com.encrypt;

import java.util.HashMap;

public class Vigenere {

	private static HashMap<Character, Integer> charIntMap = new HashMap<Character,Integer>();
	private static HashMap<Integer, Character> intCharMap = new HashMap<Integer,Character>();
	private final static char[] alphaArray = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

	public static void main(String[] args) {
		init();
		String encryptedText = encrypt("Chal main tujhe ek baat kehta hu secret hai.. haha haha !","boom");
		System.out.println(encryptedText);
		String decryptedText = decrypt(encryptedText,"boom");
		System.out.println(decryptedText);
		
	}

	//	The crow flies at midnight!
	//	boom
	//	Uvs osck rmwse bh auebwsih!

	/**
	 * Initialize the hashmap to retain the values of the characters.
	 */
	private static void init(){
		for(int i=0;i<alphaArray.length;i++){
			charIntMap.put(alphaArray[i], i);
			intCharMap.put(i, alphaArray[i]);
			System.out.println(alphaArray[i] +" pos:"+ i);
		}
	}

	/**
	 * Encrypt using Vienere cryptic method.
	 * @param inputText
	 * @param key
	 */
	private static String encrypt(String inputText, String key) {

		inputText = inputText.toLowerCase() ;
		// initialization of temp variables.
		Character tempChar = null;
		StringBuffer sb = new StringBuffer();
		for(int i=0, j=0;i<inputText.length();i++){
			if(!(inputText.charAt(i)<'a' || inputText.charAt(i)>'z')){
				tempChar = intCharMap.get((charIntMap.get(key.charAt(j%key.length())) + charIntMap.get(inputText.charAt(i)))%26);
				// increment the key counter only when its in a-z range.
				j++;
				sb.append(tempChar);
			}else{
				sb.append(inputText.charAt(i));
			}
		}
		return sb.toString();
	}
	
	/**
	 * Encrypt using Vienere cryptic method.
	 * @param inputText
	 * @param key
	 */
	private static String decrypt(String inputText, String key) {
		inputText = inputText.toLowerCase() ;
		// initialization of temp variables.
		Character tempChar = null;
		StringBuffer sb = new StringBuffer();
		for(int i=0, j=0;i<inputText.length();i++){
			if(!(inputText.charAt(i)<'a' || inputText.charAt(i)>'z')){
				tempChar = intCharMap.get(Math.abs((charIntMap.get(inputText.charAt(i)) - (charIntMap.get(key.charAt(j%key.length()))))+26)%26);
				// increment the key counter only when its in a-z range.
				j++;
				sb.append(tempChar);
			}else{
				sb.append(inputText.charAt(i));
			}
		}
		return sb.toString();
	}
	

}
