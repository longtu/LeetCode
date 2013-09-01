public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

        if(num == null || num.length == 0 )
            return res; 

        if(num.length == 1){
            ArrayList<Integer> re = new ArrayList<Integer>();
            re.add(num[0]);
            res.add(re);
            return res;
        }

        int [] sub = new int[num.length-1];
        System.arraycopy(num,0,sub,0,num.length-1);
        ArrayList<ArrayList<Integer>> all = permuteUnique(sub);
        for(ArrayList<Integer> al : all){
            for(int i = 0; i <= al.size(); ++i){
                ArrayList<Integer> re = new ArrayList<Integer>(al);
                re.add(i, num[num.length-1]);
                res.add(re); 
                if(i < al.size() && al.get(i) == num[num.length-1])
                    break;
            }
        }
        return res;
    }
    //another solution is to sort first, and use recursion and used label:
}
/*
1:    vector<vector<int> > permuteUnique(vector<int> &num) {  
2:      // Start typing your C/C++ solution below  
3:      // DO NOT write int main() function  
4:      vector<vector<int> > coll;  
5:      vector<int> solution;  
6:      if(num.size() ==0) return coll;  
7:      vector<int> visited(num.size(), 0);  
8:      sort(num.begin(), num.end());  
9:      GeneratePermute(num, 0, visited, solution, coll);  
10:      return coll;  
11:    }  
12:    void GeneratePermute(vector<int> & num, int step, vector<int>& visited, vector<int>& solution, vector<vector<int> >& coll)  
13:    {  
14:      if(step == num.size())  
15:      {  
16:        coll.push_back(solution);  
17:        return;  
18:      }  
19:      for(int i =0; i< num.size(); i++)  
20:      {  
21:        if(visited[i] == 0)  
22:        {  
23:          if(i>0 && num[i] == num[i-1] && visited[i-1] ==0)  
24:            continue;  
25:          visited[i] = 1;  
26:          solution.push_back(num[i]);  
27:          GeneratePermute(num, step+1, visited, solution, coll);  
28:          solution.pop_back();  
29:          visited[i] =0;  
30:        }  
31:      }  
32:    }  
*/
