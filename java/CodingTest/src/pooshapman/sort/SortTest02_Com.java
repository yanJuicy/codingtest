package pooshapman.sort;

import java.util.*;

public class SortTest02_Com {
    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }


    public static void main(String[] args) {
        Interval in1 = new Interval(1, 4);
        Interval in2 = new Interval(2, 6);
        Interval in3 = new Interval(3, 10);
        Interval in4 = new Interval(15, 18);

        List<Interval> intervals = new ArrayList<>();
        intervals.add(in1);
        intervals.add(in2);
        intervals.add(in3);
        intervals.add(in4);
        List<Interval> list = solve(intervals);
        print(list);
    }

    private static void print(List<Interval> list) {
        for (Interval in : list) {
            System.out.println(in.start + " " + in.end);
        }
    }

    private static List<Interval> solve(List<Interval> list) {
        if (list.isEmpty()) {
            return list;
        }

        Collections.sort(list, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        List<Interval> result = new ArrayList<>();

        Interval before = list.get(0);
        for (int i=1; i<list.size(); i++) {
            Interval curr = list.get(i);
            if (before.end >= curr.start) {
                before.end = Math.max(curr.end, before.end);
            } else {
                result.add(before);
                before = curr;
            }
        }

        if (!result.contains(before)) {
            result.add(before);
        }


        return result;
    }
}
