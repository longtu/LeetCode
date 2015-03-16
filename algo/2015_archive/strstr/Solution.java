public class Solution {

    public String strStr(String haystack, String needle) {
        if (needle == null || needle.isEmpty())
            return haystack;
        if (haystack == null)
            return null;
        char[] hays = haystack.toCharArray();
        char[] key = needle.toCharArray();
        // This is the save we can do, check needle size
        for (int i = 0; i <= hays.length - key.length; ++i) {
            int k = 0;
            for (; k < key.length; ++k) {
                if (hays[i + k] != key[k])
                    break;
            }
            if (k == key.length)
                return haystack.substring(i);
        }
        return null;
    }

    private static int CHAR_SET = 26;

    public String strstrfast(String haystack, String needle) {
        if (needle == null || needle.isEmpty())
            return haystack;
        if (haystack == null)
            return null;
        char[] key = needle.toCharArray();

        //hashValue started as 0
        int hashValue = 0;
        for (int i = 0; i < key.length; ++i) {
            hashValue *= CHAR_SET;
            hashValue += (key[i] - '0');
        }

        //max bit value started as 1 and loop with N-1 times
        int maxPosVal = 1;
        for (int i = 1; i < key.length; ++i)
            maxPosVal *= CHAR_SET;
        // System.out.println("WR" + maxPosVal);

        char[] src = haystack.toCharArray();
        //hashValue started as 0
        int currHash = 0;
        for (int i = 0; i <= src.length - key.length; ++i) {
            if (i > key.length - 1)
                currHash -= maxPosVal * (src[i - key.length] - '0');
            currHash *= CHAR_SET;
            currHash += (src[i] - '0');
            // System.out.println("RW" + i + "," + currHash);
            if (currHash == hashValue)
                return haystack.substring(i - key.length + 1);
        }
        return null;
    }

    public static void main(String[] args) {
        String[] tests = { "123456", "", null, "123", "12345455234" };
        Solution sol = new Solution();
        for (String key : tests) {
            System.out.println(sol.strStr(key, "234"));
            System.out.println(sol.strstrfast(key, "234"));
        }
    }
}

