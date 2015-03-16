import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    private Map<String, Integer> getStringCountMap(String[] L) {
        HashMap<String, Integer> stringMap = new HashMap<String, Integer>();
        for (int i = 0; i < L.length; ++i) {
            if (stringMap.containsKey(L[i]))
                stringMap.put(L[i], stringMap.get(L[i]) + 1);
            else
                stringMap.put(L[i], 1);
        }
        return stringMap;
    }

    private String[] getMatchArray(String S, Map<String, Integer> stringIndex,
            int len) {
        String[] matchArray = new String[S.length()];
        //increase by 1, condition is equal
        for (int i = 0; i <= S.length() - len; i++) {
            String val = S.substring(i, i + len);
            if (stringIndex.containsKey(val))
                matchArray[i] = val;
            else
                matchArray[i] = null;
        }
        return matchArray;
    }

    private boolean isSubStringConcateAllWords(String[] matchArray, int start,
            int len, int size, Map<String, Integer> stringCountMap) {
        Map<String, Integer> myCount = new HashMap<String, Integer>();
        //herer increase by LEN instead of 1, not equal
        for (int i = start; i < start + len * size; i += len) {
            String matchedString = matchArray[i];
            if (matchedString == null)
                return false;
            if (myCount.containsKey(matchedString)) {
                int val = myCount.get(matchedString) + 1;
                myCount.put(matchedString, val);
                if (val > stringCountMap.get(matchedString))
                    return false;
            } else
                myCount.put(matchedString, 1);
        }
        return true;
    }

    public ArrayList<Integer> findSubstring(String S, String[] L) {

        ArrayList<Integer> ret = new ArrayList<Integer>();
        if (S == null || S.length() == 0 || L == null || L.length == 0)
            return ret;

        Map<String, Integer> stringCountMap = getStringCountMap(L);
        int len = L[0].length();
        int totalWords = L.length;
        String[] matchArray = getMatchArray(S, stringCountMap, len);

        //here increase by 1 instead of LEN, equal is OK
        for (int i = 0; i <= S.length() - totalWords * len; i += 1) {
            if (isSubStringConcateAllWords(matchArray, i, len, totalWords,
                    stringCountMap))
                ret.add(i);
        }
        return ret;
    }

}

