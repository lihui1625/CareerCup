package career08.oop;

import java.util.List;

public class Exam_8_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


abstract class Entry{
	Direcory parent;
	String name;
	abstract int size();
	String owner;
	String mod;
}

class File extends Entry{ 
	 int size;
	 String content;	
	 int size(){throw new RuntimeException("to do");}
}

class Direcory extends Entry{ 
	List<Entry> entries;
	int size() { throw new RuntimeException("to do");} 
	int items() { throw new RuntimeException("to do");} 
	void del(Entry e){};
	void add(Entry e){}; 
}


