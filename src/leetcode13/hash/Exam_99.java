package leetcode13.hash;

import java.util.HashMap;

public class Exam_99 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Item<K, V> {
	K key;
	V value;
	Item<K, V> pre, next;

	public Item() {
		super();
	}

	public Item(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}
}

class LRUCache<K, V> {
	Item<K, V> m_start, m_end;
	int m_size, curr_size;
	HashMap<K, Item<K, V>> m_map;

	public LRUCache(int size) {
		this.m_size = size;
		this.curr_size = 0;
		this.m_start = new Item<K, V>();
		this.m_end = new Item<K, V>();

		this.m_start.next = this.m_end;
		this.m_end.pre = this.m_start;

		this.m_map = new HashMap<>();
	}

	public V get(K key) {
		if (this.m_map.containsKey(key)) {

			return this.m_map.get(key).value;
		} else {
			return null;
		}
	}

	public void move2Head(Item<K, V> item) {
		Item<K, V> preItem = item.pre;
		Item<K, V> oldNext = item.next;
		preItem.next = oldNext;
		oldNext.pre = preItem;
		this.insertHead(item);

	}

	public void insertHead(Item<K, V> item) {
		Item<K, V> oldHead = this.m_start.next;
		this.m_start.next = item;
		item.next = oldHead;
		item.pre = this.m_start;
		oldHead.pre = item;
	}

	public void put(K key, V value) {
		Item<K, V> item = new Item<>(key, value);
		if (this.m_map.containsKey(key)) {
			this.move2Head(item);
		} else {
			if (this.curr_size < this.m_size) {
				this.insertHead(item);
				this.curr_size++;
			} else {
				this.removeOld();
				this.insertHead(item);
			}
		}

	}

	public void removeOld() {
		Item<K,V> item = this.m_end.pre;
		if(item!=this.m_start){
			Item<K,V> oldPreItem = item.pre;
			oldPreItem.next = m_end;
			m_end.pre = oldPreItem;
			this.m_map.remove(item);
			item = null; 
		} 
	}

}