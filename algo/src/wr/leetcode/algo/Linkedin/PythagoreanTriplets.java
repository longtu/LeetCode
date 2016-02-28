package wr.leetcode.algo.Linkedin;



import java.util.*;

public class PythagoreanTriplets {


    public List<int[]> findTriplets( int[] array ) {

        List<MetaData> square = new LinkedList<>();
        for (int a : array) {
            MetaData data = new MetaData( a, ((long)a * (long)a) );
            square.add( data );
        }
        Collections.sort(square, (a,b)->((int)(a.squre - b.squre)));
        //TODO: finish the two sum problem below
        return null;
    }

    class MetaData {
        long squre;
        int base;

        public MetaData( int base, long squre ) {
            this.squre = squre;
            this.base = base;
        }
    }
}


