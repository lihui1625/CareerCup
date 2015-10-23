package leetcode06.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Exam_03 {

	private Map<Integer, Integer> map = new HashMap<>();

	public boolean save(int input) {
		if (map.containsKey(input)) {
			map.put(input, (map.get(input) + 1));
		} else {
			map.put(input, 1);
		}
		return true;
	}

	public boolean test(int tagert) {
		if (tagert % 2 == 0 && map.containsKey(tagert / 2)
				&& map.get(tagert / 2) >= 2) {

			return true;
		}
		Set<Integer> keySet = map.keySet();
		for (Integer key : keySet) {
			if (map.containsKey(tagert - key)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Exam_03 exam_03 = new Exam_03();
		Random r = new Random();
		for (int i = 0; i < 50; i++) {
			exam_03.save(r.nextInt(50) - 25);
		}
		System.out.println(exam_03.test(40)); 
	}

}
