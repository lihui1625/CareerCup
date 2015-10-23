package leetcode06.array;

import java.util.ArrayList;
import java.util.List;

public class Exam_07 {

	public static List<Interval> InsertIntenal(List<Interval> intervals,
			Interval newInterval) {
		List<Interval> newIntervalList = new ArrayList<>((intervals == null ? 0
				: intervals.size()) + 1);
		if (intervals == null || intervals.size() == 0) {
			newIntervalList.add(newInterval);
			return newIntervalList;
		}
		int index = 0;
		int end = intervals.size();
		while (index < end && intervals.get(index).end < newInterval.start) {
			newIntervalList.add(intervals.get(index));
			index++;
		}
		int insertplace = index;

		if (insertplace < end) {
			newInterval.start = Math.min(newInterval.start,
					intervals.get(insertplace).start);
			while (index < end && intervals.get(index).start <= newInterval.end) {
				newInterval.end = Math.max(newInterval.end,
						intervals.get(index).end);
				index++;
			}
			newIntervalList.add(newInterval);

		} else { // 已经到尽头
			newIntervalList.add(newInterval);
		}

		while (index < end && intervals.get(index).start > newInterval.end) {
			newIntervalList.add(intervals.get(index));
			index++;
		}
		return newIntervalList;

	}

	public static void main(String[] args) {
		List<Interval> intervalList = new ArrayList<>();
		intervalList.add(new Interval(-11,-8));
		intervalList.add(new Interval(1,2));
		intervalList.add(new Interval(3,5));
		intervalList.add(new Interval(6,7));
		intervalList.add(new Interval(8,9));
		intervalList.add(new Interval(10,18));
		intervalList.add(new Interval(22,25));
		List<Interval> newIntervalList = InsertIntenal(intervalList, new Interval(4,10));
		System.out.println(newIntervalList);
	}

}
