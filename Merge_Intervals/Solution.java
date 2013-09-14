public class Solution {

    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    private boolean overlaps(Interval src, Interval dest) {
        return (src.start-dest.start)*(src.end-dest.start) <= 0;
    }
    private Interval mergeInterval(Interval src, Interval dest){
        return new Interval( (src.start < dest.start)?(src.start):(dest.start),
                (src.end > dest.end)?(src.end):(dest.end));
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {

        ArrayList<Interval> res = new ArrayList<Interval>();
        if(intervals == null)
            return res;

        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval src, Interval dest) {
                int ret = src.start - dest.start;
                return ret;
            }});

        Interval curr = null;
        Interval next = null;
        for(int i = 0; i< intervals.size(); ++i ){
            //curr is empty
            if(curr == null){
                curr = intervals.get(i);
                continue;
            }
            next = intervals.get(i);
            //curr not empty, curr and next overlaps
            if(overlaps(curr, next)){
                curr = mergeInterval(curr, next); 
                continue;
            }
            //no overlaps
            res.add(curr);
            curr = next; 
        }
        if(curr != null)
            res.add(curr);
        return res;

    }

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> ret = new ArrayList<Interval>();
        if(intervals == null){
            ret.add(newInterval);
            return ret;
        }
        intervals.add(newInterval);
        return merge(intervals);
    }
}
