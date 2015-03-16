public class Solution{

    private int pow2(int k){
        int val = 0x01;
        for(int i = 0; i<k; ++i)
            val = val << 1;
        return val; 
    }

    /*O(N)*/
    public byte reverseByteBit(byte b){
        int input = b;
    	int output = 0x00;
        for(int i = 0; i<4; ++i){
            int left = pow2(i) & input;
            int right = pow2(7-i) & input;
            left = left<<(7-i*2);
            right = right >> (7-i*2);
            output |= ( left | right);
        }
        return (byte)output;
    }
    
    /*log(N)*/
    public byte reverseByteBitFast(byte b){
    	int input = b;
    	int output = 0x00;
    	output = ((input & 0xf0)>>4 | (input & 0x0f)<<4);
    	output = ((output & 0xcc)>>2 | (output & 0x33)<<2);
    	output = ((output & 0xaa)>>1 | (output & 0x55)<<1);
    	return (byte)output;
    }


    public static void main(String [] args){
    	Solution sol = new Solution();
    	int [] test = {1,5,8,10,55,77,99,44,155,255};
    	for(int i = 0; i<256; ++i){
    		System.out.print(String.format("%x, ", i));
    		System.out.print(String.format(" %x", sol.reverseByteBit((byte)i)));
    		System.out.println(String.format(", %x", sol.reverseByteBitFast((byte)i)));
    	}
    	
    }
}

