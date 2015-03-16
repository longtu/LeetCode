import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0)
            return 0;

        int[] candy = new int[ratings.length];

        candy(ratings, candy);
        int sum = 0;
        for (int i = 0; i < candy.length; ++i) {
            sum += candy[i];
        }
        return sum;
    }

    // length >=2
    private void candy(int[] ratings, int[] candy) {
        Queue<Integer> readyList = new LinkedList<Integer>();
        for (int i = 0; i < candy.length; ++i) {
            if (i > 0 && ratings[i - 1] < ratings[i])
                continue;
            if (i < candy.length - 1 && ratings[i + 1] < ratings[i])
                continue;
            readyList.add(i);
        }

        while (!readyList.isEmpty()) {
            Integer index = readyList.remove();

            int left = 1;
            if (index + 1 < candy.length && candy[index + 1] != 0) {
                if (ratings[index] > ratings[index + 1])
                    left = candy[index + 1] + 1;
                else
                    left = candy[index + 1];
            }
            int right = 1;
            if (index > 0 && candy[index - 1] != 0) {
                if (ratings[index] > ratings[index - 1])
                    right = candy[index - 1] + 1;
                else
                    right = candy[index - 1];
            }
            candy[index] = (left > right) ? (left) : (right);

            if ((index - 1 >= 0) && (candy[index - 1] == 0)) {
                if ((index - 2 < 0) || candy[index - 2] != 0
                        || ratings[index - 2] >= ratings[index - 1])
                    readyList.add(index - 1);
            }

            if ((index + 1 <= candy.length - 1) && (candy[index + 1] == 0)) {
                if ((index + 2 > candy.length - 1) || candy[index + 2] != 0
                        || ratings[index + 2] >= ratings[index + 1])
                    readyList.add(index + 1);
            }
        }
    }
/*
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] test = { 1, 3, 3, 3, 2, 1 };
        System.out.println(sol.candy(test));
    }*/
}

