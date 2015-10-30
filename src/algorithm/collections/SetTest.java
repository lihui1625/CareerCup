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
		Set<String> set = new HashSet<>();

	}

	public static void treeSetTest() {
		Set<String> set = new TreeSet<>();

	}

	public static void linkedHashSetTest() {
		Set<String> set = new LinkedHashSet<>();

	}

	public static void concurrentSkipListSetTest() {
		Set<String> set = new ConcurrentSkipListSet<>();

	}

	public static void copyOnWriteArraySetTest() {
		Set<String> set = new CopyOnWriteArraySet<>();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
