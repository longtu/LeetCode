
public class Solution {
    private boolean isConnect(String src, String dest){
        char[]src_arr = src.toCharArray();
        char[]dest_arr = dest.toCharArray();
        int misMatch = 0;
        for(int i=0; i<src.length(); ++i){
            if(src_arr[i]!=dest_arr[i])
                misMatch +=1;
        }
        return (misMatch == 1);
    }

    private ArrayList<List<Integer>> buildAdjMap(String[] arr){
        int len = arr.length;
        ArrayList<List<Integer>> adjMap = new ArrayList<List<Integer>>();
        for(int i = 0; i< len; ++i){
            List<Integer> thisList = new LinkedList<Integer>();
            for(int j = 0; j< len; ++j){
                boolean val = isConnect(arr[i], arr[j]);
                if(val){
                    thisList.add(j);
                }
            }
            adjMap.add(thisList);
        }
        return adjMap;
    }
        
    public int ladderLength(String start, String end, HashSet<String> dict) {
        if(dict == null || dict.isEmpty() )
            return 0;
        dict.add(start);
        dict.add(end);
        String[] strs = new String[dict.size()];
        int i = 0;
        int start_index = 0;
        for(String key:dict){
            strs[i] = key;
            if(key.equals(start)){
                start_index = i;
            }
            i++;
        }
        ArrayList<List<Integer>> adj = buildAdjMap(strs);
        Set<String> visited = new HashSet<String>();
        return bfs(strs,visited,adj,start_index,end);
    }

    private int bfs(String [] arr, Set<String> visited, ArrayList<List<Integer>> adj, 
            int src, String end){
        //find the end        
        LinkedList<Integer> queue = new LinkedList<Integer>();
        LinkedList<Integer> levels = new LinkedList<Integer>();
        queue.addFirst(src);
        levels.addFirst(1);
        visited.add(arr[src]);

        while(queue.size() >0){
            int i = queue.removeLast();
            int level = levels.removeLast();
            if(arr[i].equals(end)){
             return level; 
            }
            List<Integer> neighbours = adj.get(i);
            for(int j : neighbours){
                if(visited.contains(arr[j]))
                    continue;
                visited.add(arr[j]);
                queue.addFirst(j);
                levels.addFirst(level+1);
            }
        }
        return 0;
    }
}

