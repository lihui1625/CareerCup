package leetcode13.hash;

import java.util.HashMap;

public class Exam_95 {
	
	public static String minWindow(String s, String t){
		if(s==null || t==null  ){
			return "";
		}
		int sLen = s.length();
		int tLen = t.length();
		if( s.length()==0 || t.length()==0 || sLen < tLen){
			return "";
		}
		HashMap<Character,Integer> tMap = new HashMap<>();
		for(int i=0; i< tLen;i ++){
			char c = t.charAt(i);
			if(!tMap.containsKey(c)){
				tMap.put(c, 1);
			}
			else{
				tMap.put(c, tMap.get(c)+1);
			}
		}
		
		HashMap<Character,Integer> foundMap = new HashMap<>();
		int count = 0;
		int start = 0;
		int minLen = Integer.MAX_VALUE;
		int minLenStart = -1;
		for(int i=0; i<sLen;i++){
			char c = s.charAt(i);
			if(!tMap.containsKey(c)){
				continue;
			}
			if(!foundMap.containsKey(c)){
				foundMap.put(c, 1);
			}
			else{
				foundMap.put(c, foundMap.get(c)+1);
			}
			if(foundMap.get(c) <= tMap.get(c)){
				count++;
			}
			if(count>=tLen){
				char startChar = s.charAt(start);
				while(!foundMap.containsKey(startChar) || foundMap.get(startChar) > tMap.get(startChar)){
					if(foundMap.containsKey(startChar)){
						foundMap.put(startChar, foundMap.get(startChar)-1);
					}
					start++;
					startChar = s.charAt(start);
				}
				int len = i-start+1;
				if(len < minLen){
					minLen = len;
					minLenStart = start;
				}
			}
			
		}
		if(minLenStart>=0){
			return s.substring(minLenStart, minLenStart + minLen);
		}
		return "";
	}

	public static void main(String[] args) {
		 System.out.println( minWindow("asdfasadfqwrfdsafasdfsd", "adsaddfsf"));

	}

}
