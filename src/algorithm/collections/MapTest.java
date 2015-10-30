package algorithm.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class MapTest {

	public static void hashMapTest() {
		Map<String, String> map = new HashMap<>();
		map.put("a", "A");
		map.put(null, "null");
		map.put("null", null);
		map.put("b", "B");
		map.put("b", "BB");

		String nulls = map.get(null);

		String as = map.get("a");

		map.remove("a");

		boolean b = map.isEmpty();

		Set<String> keys = map.keySet();

		Collection<String> values = map.values();

		map.containsKey(null);

		map.containsKey("a");

		map.containsValue(null);

		map.containsValue("A");

		map.clear();

	}

	public static void treeMapTest() {
		Map<String, String> map = new TreeMap<>();
		map.put("a", "A");
		// map.put(null, "null");
		map.put("null", null);
		map.put("b", "B");
		map.put("b", "BB");

		// String nulls = map.get(null);

		String as = map.get("a");

		map.remove("a");

		boolean b = map.isEmpty();

		Set<String> keys = map.keySet();

		Collection<String> values = map.values();

		// map.containsKey(null);

		map.containsKey("a");

		map.containsValue(null);

		map.containsValue("A");

		map.clear();

		NavigableMap<String, String> navigableMap = new TreeMap<>();
		navigableMap.put("a", "A");
		// navigableMap.put(null, "null");
		navigableMap.put("null", null);
		navigableMap.put("b", "B");
		navigableMap.put("b", "BB");

		navigableMap.ceilingEntry("a");
		navigableMap.lowerEntry("a");
		navigableMap.floorEntry("a");

	}

	public static void linkedHashMapTest() {
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		map.put("a", "A");
		map.put(null, "null");
		map.put("null", null);
		map.put("b", "B");
		map.put("b", "BB");

	}

	public static void concurrentHashMapTest() {
		Map<String, String> map = new ConcurrentHashMap<>();
		map.put("a", "A");
		map.put(null, "null");
		map.put("null", null);
		map.put("b", "B");
		map.put("b", "BB");

		String nulls = map.get(null);

		String as = map.get("a");

		map.remove("a");

		boolean b = map.isEmpty();

		Set<String> keys = map.keySet();

		Collection<String> values = map.values();

		map.containsKey(null);

		map.containsKey("a");

		map.containsValue(null);

		map.containsValue("A");

		map.clear();
	}

	public static void weakHashMapTest() {
		Map<String, String> map = new WeakHashMap<>();
		map.put("a", "A");
		map.put(null, "null");
		map.put("null", null);
		map.put("b", "B");
		map.put("b", "BB");

		String nulls = map.get(null);

		String as = map.get("a");

		map.remove("a");

		boolean b = map.isEmpty();

		Set<String> keys = map.keySet();

		Collection<String> values = map.values();

		map.containsKey(null);

		map.containsKey("a");

		map.containsValue(null);

		map.containsValue("A");

		map.clear();
	}

	public static void hashtableTest() {
		Map<String, String> map = new Hashtable<>();
		map.put("a", "A");
		map.put(null, "null");
		map.put("null", null);
		map.put("b", "B");
		map.put("b", "BB");

		String nulls = map.get(null);

		String as = map.get("a");

		map.remove("a");

		boolean b = map.isEmpty();

		Set<String> keys = map.keySet();

		Collection<String> values = map.values();

		map.containsKey(null);

		map.containsKey("a");

		map.containsValue(null);

		map.containsValue("A");

		map.clear();
	}

	public static void propertiesTest() {
		Map map = new Properties();
		map.put("a", "A");
		map.put(null, "null");
		map.put("null", null);
		map.put("b", "B");
		map.put("b", "BB");

		Object nulls = map.get(null);

		Object as = map.get("a");

		map.remove("a");

		boolean b = map.isEmpty();

		Set<String> keys = map.keySet();

		Collection<String> values = map.values();

		map.containsKey(null);

		map.containsKey("a");

		map.containsValue(null);

		map.containsValue("A");

		map.clear();
	}

	public static void concurrentSkipListMapTest() {
		Map<String, String> map = new ConcurrentSkipListMap<>();
		map.put("a", "A");
		map.put(null, "null");
		map.put("null", null);
		map.put("b", "B");
		map.put("b", "BB");

		String nulls = map.get(null);

		String as = map.get("a");

		map.remove("a");

		boolean b = map.isEmpty();

		Set<String> keys = map.keySet();

		Collection<String> values = map.values();

		map.containsKey(null);

		map.containsKey("a");

		map.containsValue(null);

		map.containsValue("A");

		map.clear();
	}

	public static void identityHashMapTest() {
		Map<String, String> map = new IdentityHashMap<>();
		map.put("a", "A");
		map.put(null, "null");
		map.put("null", null);
		map.put("b", "B");
		map.put("b", "BB");

		String nulls = map.get(null);

		String as = map.get("a");

		map.remove("a");

		boolean b = map.isEmpty();

		Set<String> keys = map.keySet();

		Collection<String> values = map.values();

		map.containsKey(null);

		map.containsKey("a");

		map.containsValue(null);

		map.containsValue("A");

		map.clear();
	}

	public static void main(String[] args) {
		// hashMapTest();
		// treeMapTest();
		// concurrentHashMapTest();
		// Random r = new Random();
		// Map<String, String> map = new HashMap<>(1);
		// for (int i = 0; i < 40; i++) {
		// String key = r.nextInt(5) + "";
		// String v = i + "";
		// map.put(key, v);
		// }
		// map.get(null);
		// map.get(1);
		// map.get("1");
		//
		HashMap<Integer, Integer> map = new HashMap<>(1); 
		map.put(5, 5);   
		System.out.println(map.get(1));
		
		HashMap<String, String> map2 = new HashMap<>(1); 
		map2.put("5", "5");   
		System.out.println(map2.get(Object.class));
	}

}
