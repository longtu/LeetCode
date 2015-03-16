public class Solution {
        public int[] plusOne(int[] digits) {
        if(digits == null) 
            digits = new int[0];
        int carry = 1;
        LinkedList<Integer> res = new LinkedList<Integer>();
        for(int i = 1; i <= digits.length; ++i){
            int val = digits[digits.length-i] + carry;
            if(val < 10)
                carry = 0;
            else
                carry = 1;
            //add First instead of addFront
            res.addFirst(val%10);
        }
        if(carry == 1)
            res.addFirst(1);
        int [] ret = new int[res.size()];
        //from List to array you can use List.toArray(new I [size])
        //however only support non-primitive
        int i = 0;
        for(Integer val: res){
        	ret[i++] = val;
        }
        return ret; 
    }
}
