public class Solution {
    //simple stock price: single transaction
    public int maxProfit(int[] prices) {

        if(prices == null || prices.length == 0)
            return 0;

        int min = prices[0];
        int profit = 0;

        for(int i = 1; i< prices.length; ++i){
            if(prices[i] < min){
                min = prices[i];
                continue;
            }
            profit = (prices[i]-min > profit)?(prices[i]-min):(profit); 
        }
        return profit;
    }

    //simple stock price: multiple transactions, but no overlap
    public int maxProfit(int[] prices) {

        if(prices == null || prices.length == 0)
            return 0;

        int prev = prices[0];
        int profit = 0;

        for(int i = 1; i< prices.length; ++i){
            if(prices[i] > prev)
                profit += prices[i]-prev;
            prev = prices[i]
        }
        return profit;
    }

    //two transactions
    //time exceeds, we can actually do O(N) using two passes
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function

        if(prices == null || prices.length == 0)
            return 0;

        int len = prices.length;

        int [] single = new int[len+1];
        int [] duo = new int [len+1]; 

        for(int i = 1; i<= len; ++i){
            int maxSingle = single[i-1];
            int maxDouble = duo[i-1];
            for(int j = 1; j<i; ++j){
                int priceDiff = prices[i-1] - prices[j-1];
                if(priceDiff > maxSingle)
                    maxSingle = priceDiff;  
                if(priceDiff + single[j] > maxDouble)
                    maxDouble = priceDiff + single[j];
            }
            single[i] = maxSingle;
            duo[i]=maxDouble;
        }
        return (single[len]>duo[len])?(single[len]):(duo[len]);
    }


    //two transactions
    //O(N)
    public class Solution {
        //two transactions
        public int maxProfit(int[] prices) {

            if(prices == null || prices.length == 0)
                return 0;

            int maxProfit[] = new int[prices.length];
            int min = prices[0];
            int profit = 0;

            for(int i = 1; i< prices.length; ++i){
                if(prices[i] < min){
                    min = prices[i];
                    //this is the easy missing part
                    maxProfit[i] = profit;
                    continue;
                }
                profit = (prices[i]-min > profit)?(prices[i]-min):(profit); 
                maxProfit[i] = profit;
            }

            int max = prices[prices.length-1];
            int ret = 0;
            profit = 0;
            for(int i = prices.length-2; i>=0; --i){
                if(prices[i] > max){
                    max =prices[i];
                    continue;
                }
                profit = (max - prices[i] > profit)?(max - prices[i]):(profit); 
                if(profit + maxProfit[i] > ret)
                    ret = profit + maxProfit[i];
            }
            return ret;
        }
    }
}
