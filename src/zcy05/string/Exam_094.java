package zcy05.string;

import java.util.HashMap;
import java.util.Map;

public class Exam_094 {

	public static void main(String[] args) {
		Trie t = new Trie();
		t.insert("abcd");
		t.insert("abce");
		t.insert("abcf");
		t.insert("abdd");
		t.insert("abde");
		t.insert("abdf");
		t.insert("acdf");
		t.insert("afdf");
		
		System.out.println(t.prefexNum("a"));
		System.out.println(t.prefexNum("ab"));
		System.out.println(t.prefexNum("abc"));
		System.out.println(t.prefexNum("abd"));
		
		t.delete("abcd");

		System.out.println(t.prefexNum("a"));
		System.out.println(t.prefexNum("ab"));
		System.out.println(t.prefexNum("abc"));
		System.out.println(t.prefexNum("abd"));
	}

}

class Trie {
	public Node root;

	public Trie() {
		root = new Node();
	}

	public void insert(String word) {
		if (word == null || word.isEmpty()) {
			return;
		}

		Node node = root;
		for (int i = 0; i < word.length(); i++) {
			char cur = word.charAt(i);
			if (!node.map.containsKey(cur)) {
				node.map.put(cur, new Node());
			}
			node = node.map.get(cur);
			node.path++;
		}
		node.end++;
	}

	public boolean exists(String word) {
		if (word == null || word.isEmpty()) {
			return false;
		}
		Node node = root;
		for (int i = 0; i < word.length(); i++) {
			char cur = word.charAt(i);
			if (!node.map.containsKey(cur)) {
				return false;
			}
			node = node.map.get(cur);
		}
		return node.end > 0;
	}

	public boolean delete(String word) {
		if (word == null || word.isEmpty() || !this.exists(word)) {
			return false;
		}
		Node node = root;
		for (int i = 0; i < word.length(); i++) {
			char cur = word.charAt(i);
			if (!node.map.containsKey(cur)) {
				return false;
			}
			node = node.map.get(cur);
			node.path--;
		}
		node.end--;
		return true;
	}
	
	public int prefexNum(String word) {
		if (word == null || word.isEmpty() ) {
			return 0;
		}
		Node node = root;
		for (int i = 0; i < word.length(); i++) {
			char cur = word.charAt(i);
			if (!node.map.containsKey(cur)) {
				return 0;
			}
			node = node.map.get(cur);
		}
		return node.path;
	} 
	 
}

class Node {
	int path;
	int end;
	Map<Character, Node> map;

	public Node() {
		this.path = 0;
		this.end = 0;
		this.map = new HashMap<>();
	}
}