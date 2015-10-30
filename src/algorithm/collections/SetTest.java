package algorithm.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ConcurrentSkipListSet;

;

public class SetTest {

	public static void hashSetTest() {
		Set<String> set = new HashSet<>(); //完全基于 HashMap

	}

	public static void treeSetTest() {
		Set<String> set = new TreeSet<>();  //完全基于TreeMap

	}

	public static void linkedHashSetTest() {
		Set<String> set = new LinkedHashSet<>(); //完全基于HashSet

	}

	public static void concurrentSkipListSetTest() {
		Set<String> set = new ConcurrentSkipListSet<>(); //完全基于ConcurrentSkipListMap

	}

	public static void copyOnWriteArraySetTest() {
		Set<String> set = new CopyOnWriteArraySet<>();  //完全基于CopyOnWriteArrayList
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
