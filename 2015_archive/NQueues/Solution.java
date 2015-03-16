public class Solution {

    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> res = new ArrayList<String[]>();
        int [] pos = new int[n];
        boolean [] visited = new boolean[n];
        for(int i = 0; i< n; ++i)
            visited[i] = false;
        int index = 0;
        solveNQueens(pos, visited, index, n, res);
        return res;
    }
    private void solveNQueens(int [] pos, boolean [] visited, int index, int n,
            ArrayList<String[]> res){
        if(index == n){
            String[] curr = new String[n];   
            for(int i = 0; i<n; ++i){
                char[] currLine = new char[n];
                for(int j = 0; j< n; ++j){
                    if(j!= pos[i])
                        currLine[j] = '.';
                    else
                        currLine[j] = 'Q';
                }
                curr[i] = new String(currLine);
            }
            res.add(curr);
            return;
        }
        for(int i = 0; i<n; ++i){
            if(visited[i] == true)
                continue;
            int j = 0;
            for(j=0; j<index; ++j){
            	int diff = (pos[j]-i > 0)?(pos[j]-i):(i-pos[j]);
            	if(diff == index - j)
            		break;
            }
            if(j < index)
            	continue;
            visited[i] = true;
            pos[index] = i;  
            solveNQueens(pos, visited, index+1, n, res);
            visited[i] = false;
        }
    }
    private void totalNQueens(int [] pos, boolean [] visited, int index, int n,
            int[] res){
        if(index == n){
        	res[0]++;
        	return;
        }
        for(int i = 0; i<n; ++i){
            if(visited[i] == true)
                continue;
            int j = 0;
            for(j=0; j<index; ++j){
            	int diff = (pos[j]-i > 0)?(pos[j]-i):(i-pos[j]);
            	if(diff == index - j)
            		break;
            }
            if(j < index)
            	continue;
            visited[i] = true;
            pos[index] = i;  
            totalNQueens(pos, visited, index+1, n, res);
            visited[i] = false;
        }
    }

    public int totalNQueens(int n) {
        int[] res = new int [1];
        int [] pos = new int[n];
        boolean [] visited = new boolean[n];
        for(int i = 0; i< n; ++i)
            visited[i] = false;
        int index = 0;
        totalNQueens(pos, visited, index, n, res);
        return res[0];
        
    }
}
