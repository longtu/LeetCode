public class Solution {
	private Map<Character, Integer> getValMap(){
		Map<Character, Integer> valMap = new HashMap<Character,Integer>();
		valMap.put('I', 1);
		valMap.put('V', 5);
		valMap.put('X', 10);
		valMap.put('L', 50);
		valMap.put('C', 100);
		valMap.put('D', 500);
		valMap.put('M', 1000);
		return valMap;
	}
	
	public int romanToInt(String s) {
		int ret = 0;
		
		if(s == null || s.length() == 0)
			return ret;
		char [] arr = s.toCharArray();
		Map<Character, Integer> valMap = getValMap();
		for(int i = 0; i< arr.length;++i){
			if(!valMap.containsKey(arr[i])){
				throw new IllegalArgumentException(s+" is not valid Rome Number");
			}
			int val = valMap.get(arr[i]);
			if(i < arr.length-1){
				if(!valMap.containsKey(arr[i+1])){
					throw new IllegalArgumentException(s+" is not valid Rome Number");
				}
				int nextVal = valMap.get(arr[i+1]);
				if(nextVal > val)
					val *= -1;
			}
			ret+=val;
		}
    	return ret;
    }

	private char[][] getCharMap(){
		char[][] charMap = new char[4][2];
		for(int i = 0; i< 4;++i)
			charMap[i] = new char[2];
		charMap[0][0] = 'I';
		charMap[0][1] = 'V';
		charMap[1][0] = 'X';
		charMap[1][1] = 'L';
		charMap[2][0] = 'C';
		charMap[2][1] = 'D';
		charMap[3][0] = 'M';
		charMap[3][1] = 'M';
		return charMap;
	}

	String getRoman(int digit, int pos, char[][] charMap){
		StringBuilder sb = new StringBuilder();
		if( pos == 3){
			for(int i = 0; i< digit; ++i)
				sb.append('M');
		}
		else{
			if(digit < 4){
				for(int i = 1; i<= digit; ++i)
					sb.append(charMap[pos][0]);
			}
			else if(digit == 4){
				sb.append(charMap[pos][0]);
				sb.append(charMap[pos][1]);
			}
			else if(digit == 5)
				sb.append(charMap[pos][1]);
			else if(digit <9){
				sb.append(charMap[pos][1]);
				for(int i = 6; i<= digit; ++i)
					sb.append(charMap[pos][0]);
			}
			else{
				sb.append(charMap[pos][0]);
				sb.append(charMap[pos+1][0]);
			}
		}
		return sb.toString();
	}
	
    public String intToRoman(int num) {
    	ArrayList<Integer> input = new ArrayList<Integer>();
    	char[][] charMap = getCharMap();
    	while(num >=1){
    		input.add(num%10);
    		num /= 10;
    	}
    	StringBuilder sb = new StringBuilder();
    	for(int i = input.size()-1; i>=0; --i){
    		sb.append(getRoman(input.get(i),i,charMap));
    	}
    	return sb.toString();
    }
}
