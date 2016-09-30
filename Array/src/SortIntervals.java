import java.util.Comparator;

/**
 * Created by siddharthvarshney on 9/13/16.
 */
class SortIntervals implements Comparator<Interval>{
    @Override
    public int compare(Interval a, Interval b)
    {
        if(a.start <= b.start)
            return -1;
        else
            return 1;
    }
}
