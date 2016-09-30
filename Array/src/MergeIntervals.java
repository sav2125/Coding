import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Matcher;

/**
 * Created by siddharthvarshney on 9/13/16.
 */

public class MergeIntervals {
    public static void main(String args[])
    {
        ArrayList<Interval> sample = new ArrayList<Interval>();
        sample.add(new Interval(1,4));
        sample.add(new Interval(3,6));
        sample.add(new Interval(15,18));
        sample.add(new Interval(8,10));
        Collections.sort(sample,new SortIntervals());
        ArrayList<Interval> result = new ArrayList<Interval>();
        Interval prev = sample.get(0);
        for(int i = 1; i < sample.size(); i++)
        {
            Interval curr = sample.get(i);
            if(prev.end < curr.start)
            {
                result.add(prev);
                prev=curr;
            }
            else
            {
                Interval merged = new Interval(prev.start, Math.max(prev.end, curr.end));
                prev = merged;
            }
        }
        result.add(prev);
        for(int i=0;i<result.size();i++)
        {
            System.out.println(result.get(i).start + " " + result.get(i).end);
        }
    }
}
