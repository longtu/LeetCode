public class Solution {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0)
            return 0;

        int [] candy = new int [ratings.length];
        candy(ratings, candy, 0, ratings.length -1);
        
        int sum = 0;
        for(int i = 0; i < candy.length; ++i){
            sum += candy[i];
        }
        return sum;
    }


    private void candy( int [] ratings, int [] candy, int start, int end){
        if(start == end) {
            candy[start] = 1;
            return;
        }
        int maxIndex = start;
        for(int i = start +1; i <= end; ++i){
            if(ratings[i] > ratings[maxIndex])
                maxIndex = i;
        }
        int left = 0;
        if(maxIndex > start){
            candy(ratings, candy, start, maxIndex-1);
            left = candy[maxIndex-1];
            if(ratings[maxIndex] > ratings[maxIndex-1])
                left += 1;
        }
        int right = 0;
        if(maxIndex < end){
            candy(ratings, candy, maxIndex+1, end);
            right = candy[maxIndex+1];
            if(ratings[maxIndex] > ratings[maxIndex+1])
                right += 1;
        }
        candy[maxIndex] = (left > right)?(left):(right);
    }
}
