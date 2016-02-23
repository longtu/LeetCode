package wr.leetcode.algo.airbnb;

public class StringDecoder {
    public static final String TRUTH = "kljJJ324hijkS_";
    public static final int code = 1234567;

    public Integer decodeFind(String badEncString) {
        if (badEncString == null || badEncString.length() == 0) {
            return -1;
        }
        StringBuilder sb = new StringBuilder(badEncString);
        return decodeFind(0, sb);
    }

    private Integer decodeFind(int start, StringBuilder sb) {
        Integer ret = null;
        int n = sb.length();
        if(n == start) {
            ret = decode(sb.toString());
            if(ret != null) {
                System.out.println(sb.toString().equals(TRUTH));
            }
        } else if (start < n) {
            ret = decodeFind(start+1, sb);
            if (null == ret) {
                char ch = sb.charAt(start);
                if (Character.isUpperCase(ch)) {
                    sb.setCharAt( start, Character.toLowerCase(ch));;
                } else if (Character.isLowerCase(ch)) {
                    sb.setCharAt( start, Character.toUpperCase(ch));
                }
                ret = decodeFind(start+1, sb);
            }
        }
        return ret;
    }

    public Integer decode(String testEncStr) {
        String truth = TRUTH;

        if (testEncStr.equals(truth)) {
            return code;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        StringDecoder solution = new StringDecoder();
        String badEncStr = "kLjjj324hijks_";
        Integer result = solution.decodeFind(badEncStr);

        System.out.println(result.equals(code));
    }
}
