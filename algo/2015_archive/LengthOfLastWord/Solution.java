public class Solution {
    public int lengthOfLastWord(String s) {
        if(s == null || s.isEmpty())
            return 0;
        char [] arr = s.toCharArray();

        //remove trailing spaces
        int end = s.length()-1;
        while(end >-1 && arr[end] == ' ')
            end--;

        if(end == -1)
            return 0;

        int last = -1;
        int i = 0;
        for (; i<=end; ++i){
            if(arr[i] == ' ')
                last = i;
        }
        //easy to mis this '-1' !!!!!!!!!!!!
        return i - last-1;
    }
}

