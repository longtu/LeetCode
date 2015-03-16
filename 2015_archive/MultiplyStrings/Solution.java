public class Solution {
    public String multiply(String num1, String num2) {

        String ret = "";
        if (num1 == null || num2 == null || num1.isEmpty() || num2.isEmpty())
            return ret;

        char[] left = num1.toCharArray();
        char[] right = num2.toCharArray();
        boolean isNeg = false;

        int leftStart = 0;
        if (left[0] == '+' || left[0] == '-')
            leftStart++;
        int rightStart = 0;
        if (right[0] == '+' || right[0] == '-')
            rightStart++;
        if (left[0] == '-')
            isNeg = true;
        isNeg = (right[0] == '-') ? (!isNeg) : (isNeg);

        if (leftStart != 0 || rightStart != 0)
            return ((isNeg) ? ("-") : (""))
                    + multiply(num1.substring(leftStart),
                            num2.substring(rightStart));

        // no signs here, only pos*pos
        String res = "";
        for (int i = right.length - 1; i >= 0; --i) {
            String currRes = multiply(left, right[i], right.length - 1 - i);
            res = merge(res, currRes);
        }
        return removeLeadingZeros(res);
    }

    private String merge(String src, String dest) {
        char[] srcArr = src.toCharArray();
        char[] destArr = dest.toCharArray();
        int len = 1 + ((srcArr.length > destArr.length) ? (srcArr.length)
                : (destArr.length));
        char[] ret = new char[len];
        int carry = 0;
        //use of j here to help to index the array
        int j = 0;
        for (int i = len - 1; i >= 0; --i, ++j) {
            if (srcArr.length > j)
                carry += (srcArr[srcArr.length - j - 1]) - '0';
            if (destArr.length > j)
                carry += (destArr[destArr.length - j - 1]) - '0';
            ret[i] = (char) (carry % 10 + '0');
            carry = carry / 10;
        }
        int start = (ret[0] == '0') ? (1) : (0);
        return new String(ret).substring(start);
    }

    private String multiply(char[] num1, char val, int tail) {
        int len = tail + num1.length + 1;
        char[] ret = new char[len];
        int carry = 0;
        for (int i = len - 1; i >= 0; --i) {
            if (i > num1.length) {
                ret[i] = '0';
                continue;
            }
            if ((i <= num1.length) && (i > 0))
                carry = (val - '0') * (num1[i - 1] - '0') + carry;
            ret[i] = (char) (carry % 10 + '0');
            carry = carry / 10;
        }
        int start = (ret[0] == '0') ? (1) : (0);
        return new String(ret).substring(start);
    }
    //remember to remove leading zeros and signs
    private String removeLeadingZeros(String src) {
        if (src == null || src.isEmpty())
            return src;
        char[] arr = src.toCharArray();
        int i = 0;
        for (; i < arr.length - 1; ++i) {
            if (arr[i] != '+' && arr[i] != '0')
                break;
        }
        return src.substring(i);
    }
/*
    public static void main(String[] args) {
        Solution sol = new Solution();
        Integer left = 0;
        Integer right = 22;
        System.out.println(sol.multiply(left.toString(), right.toString()));
        System.out.println(left * right);
    }*/
}

