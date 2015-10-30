package leetcode13.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Exam_93 {
	
	public static List<List<String>> anarams (List<String> sources ){
		
		List<List<String>> result = new LinkedList<>();
		Map<String,List<String>> map = new HashMap<>();
		for(String source: sources){
			char[] keyArray =  source.toCharArray();
			Arrays.sort(keyArray);
			String key = new String(keyArray);
			if(!map.containsKey(key)){
				map.put(key, new LinkedList<String>());
			}
			map.get(key).add(source);
 		}
		result.addAll(map.values()); 
		return result;
		
	}

	public static void main(String[] args) {
		List<String> sources = new LinkedList<>();
		sources.add("cat");
		sources.add("tac");
		sources.add("act");
		sources.add("dog");
		sources.add("god");
		System.out.println(anarams (  sources ));

	}

}
