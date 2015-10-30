package algorithm.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListTest {

	public static void arrayListTest() {
		List<String> list = new ArrayList<>();
		list.add("a");

	}

	public static void linkedListTest() {
		List<String> list = new LinkedList<>();
	}

	public static void copyOnWriteArrayListTest() {
		List<String> list = new CopyOnWriteArrayList<>();

	}

	public static void copyOnWriteLinkedtListTest() {
		throw new NoClassDefFoundError("there is no  CopyOnWriteLinkedtList");
	}

	public static void vectorTest() {
		List<String> list = new Vector<>();

	}

	public static void main(String[] args) {
		arrayListTest();

	}

}
