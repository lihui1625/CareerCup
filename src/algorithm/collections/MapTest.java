package algorithm.collections;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class MapTest {

	public static void hashMapTest() {
		Map<String, String> map = new HashMap<>();

	}

	public static void treeMapTest() {
		Map<String, String> map = new TreeMap<>();
	}

	public static void linkedHashMapTest() {
		Map<String, String> map = new LinkedHashMap<>();
	}

	public static void concurrentHashMapTest() {
		Map<String, String> map = new ConcurrentHashMap<>();
	}

	public static void weakHashMapTest() {
		Map<String, String> map = new WeakHashMap<>();
	}

	public static void hashtableTest() {
		Map<String, String> map = new Hashtable<>();
	}

	public static void propertiesTest() {
		Map map = new Properties();
	}

	public static void concurrentSkipListMapTest() {
		Map<String, String> map = new ConcurrentSkipListMap<>();
	}

	public static void identityHashMapTest() {
		Map<String, String> map = new IdentityHashMap<>();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
