package career08.oop;

import java.util.Iterator;
import java.util.LinkedList;

public class Exam_8_10 {

}

class MyHash<K, V> {
	final int MAX_SIZE = 10000;
	LinkedList<Cell<K, V>>[] items;

	public MyHash() {
		items = (LinkedList<Cell<K, V>>[]) new LinkedList[MAX_SIZE];
	}
	
	public int hashCodeOfKey(K key){
		return key.toString().length()%items.length;
	}

	public void put(K key, V value){
		int x = this.hashCodeOfKey(key);
		if(this.items[x]==null){
			this.items[x] = new LinkedList<>();
		}
		LinkedList<Cell<K, V>> list = this.items[x];
		Iterator<Cell<K, V>> iterator = list.iterator();
		while(iterator.hasNext()){
			Cell<K, V> c = iterator.next();
			if(c.equalTo(key)){
				list.remove(c);
				break;
			}
		}
		list.add(new Cell(key,value));
	}
}

class Cell<K, V> {
	K k;
	V v;
	
	

	public Cell(K k, V v) { 
		this.k = k;
		this.v = v;
	}



	boolean equalTo(K k) {
		return this.k.equals(k);
	}

}