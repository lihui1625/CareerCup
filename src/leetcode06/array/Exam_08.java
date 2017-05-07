package leetcode06.array;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Exam_08 {

  public static List<Interval> merge(List<Interval> intervals) {

    if (intervals == null) {
      return null;
    }
    if (intervals.size() == 1) {
      return intervals;
    }

    List<Interval> newIntervals = new LinkedList<>();

    Collections.sort(intervals, new Comparator<Interval>() {

      @Override
      public int compare(Interval o1, Interval o2) {
        if (o1.start != o2.start) {
          return o1.start - o2.start;
        }
        return o1.start - o2.end;
      }

    });

    Interval baseInterval = intervals.get(0);
    for (int i = 1; i < intervals.size(); i++) {
      if (baseInterval.end >= intervals.get(i).start) {
        baseInterval.end = Math.max(baseInterval.end, intervals.get(i).end);
      } else {
        newIntervals.add(baseInterval);
        baseInterval = intervals.get(i);
        if (i == intervals.size() - 1) {
          newIntervals.add(baseInterval);
        }
      }
    }

    return newIntervals;

  }

  public static void main(String[] args) {
    List<Interval> intervals = new LinkedList<>();
    intervals.add(new Interval(1, 5));
    intervals.add(new Interval(6, 10));
    intervals.add(new Interval(4, 6));
    intervals.add(new Interval(15, 20));
    List<Interval> newIntervals = merge(intervals);
    System.out.println(newIntervals);

  }

}
