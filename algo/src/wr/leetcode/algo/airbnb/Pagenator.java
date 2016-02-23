package wr.leetcode.algo.airbnb;

import java.util.*;
import java.util.stream.Collectors;

public class Pagenator {
    public static final int PAGE = 3;
    final List<String> records;
    public Pagenator( String [] records ) {
        this.records = new LinkedList<>(Arrays.asList(records));
    }

    List<String> getNextPage() {
        List<String> ret = new LinkedList<>();
        Set<String> hosts = new HashSet<>();
        Iterator<String> ite = records.iterator();
        while(ite.hasNext()) {
            String record = ite.next();
            String hostId = record.split(",")[0];
            if (!hosts.contains(hostId)) {
                hosts.add(hostId);
                ret.add(record);
                ite.remove();
            }
            if (ret.size() == PAGE) {
                break;
            }
        }
        return ret;
    }

    public static void main(String[] args) {

        String[] strs = new String[]{
                "1,28,300.1,SanFrancisco",
                "4,5,209.1,SanFrancisco",
                "20,7,208.1,SanFrancisco",
                "23,8,207.1,SanFrancisco",
                "16,10,206.1,Oakland",
                "1,16,205.1,SanFrancisco",
                "6,29,204.1,SanFrancisco",
                "7,20,203.1,SanFrancisco",
                "8,21,202.1,SanFrancisco",
                "2,18,201.1,SanFrancisco",
                "2,30,200.1,SanFrancisco",
                "15,27,109.1,Oakland",
                "10,13,108.1,Oakland",
                "11,26,107.1,Oakland",
                "12,9,106.1,Oakland",
                "13,1,105.1,Oakland",
                "22,17,104.1,Oakland",
                "1,2,103.1,Oakland",
                "28,24,102.1,Oakland",
                "18,14,11.1,SanJose",
                "6,25,10.1,Oakland",
                "19,15,9.1,SanJose",
                "3,19,8.1,SanJose",
                "3,11,7.1,Oakland",
                "27,12,6.1,Oakland",
                "1,3,5.1,Oakland",
                "25,4,4.1,SanJose",
                "5,6,3.1,SanJose",
                "29,22,2.1,SanJose",
                "30,23,1.1,SanJose"
        };
        Pagenator pagenator = new Pagenator(strs);
        PageNatorV2 v2 = new PageNatorV2(strs);
        List<String> ret = pagenator.getNextPage();
        List<String> ret2 = v2.getNextPage();
        while( !ret.isEmpty() ) {
            System.out.println(ret2);
            System.out.println(ret);
            System.out.println(ret2.equals(ret));
            System.out.println();
            ret = pagenator.getNextPage();
            ret2 = v2.getNextPage();
        }
    }
}

class PageNatorV2 extends Pagenator{
    final List<String> buffer = new LinkedList<>();
    final Iterator<String> ite = records.iterator();

    public PageNatorV2( String [] records )
    {
        super(records);
    }

    @Override
    List<String> getNextPage() {
        Map<String, String> ret = new LinkedHashMap<>();
        Iterator<String> bufferIteRead = buffer.iterator();

        while(ret.size() < PAGE && bufferIteRead.hasNext()) {
            String record = bufferIteRead.next();
            String host = record.split(",")[0];
            if(!ret.containsKey(host)) {
                ret.put(host, record);
                bufferIteRead.remove();
            }
        }

        while (ret.size() < PAGE && ite.hasNext()) {
            String record = ite.next();
            String host = record.split(",")[0];
            if(!ret.containsKey(host)) {
                ret.put(host, record);
            } else {
                buffer.add(record);
            }
        }
        return ret.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
    }
}
