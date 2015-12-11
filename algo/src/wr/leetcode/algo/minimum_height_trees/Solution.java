package wr.leetcode.algo.minimum_height_trees;

import java.util.*;

public class Solution {

    //Method1: use bfs to find height and choose min TLE
    public List<Integer> findMinHeightTrees0(int n, int[][] es) {
        List<Integer> ret = new LinkedList<>();
        if( n  > 0 ) {
            Map<Integer, Set<Integer>> edges = edges(es);
            int minHeight = Integer.MAX_VALUE;
            for (int i = 0; i < n; ++i) {
                int h = bfs(i, edges);
                if (h < minHeight) {
                    minHeight = h;
                    ret = new LinkedList<>();
                }
                if ( h == minHeight) {
                    ret.add(i);
                }
            }
        }
        return ret;
    }

    //Method2: further optimization by checking examples from n = 1 to 6
    //There should be at most 2 solutions
    // we can use any single leaf node and find its longest path length
    // BUG: need to find the nodes that are len/2 (even) or (len+1)/2, (len-1)/2 dist away
    // along the longest path instead of all of them
    public List<Integer> findMinHeightTrees(int n, int[][] es) {
        List<Integer> ret = new LinkedList<>();
        //BUG: about 1 node
        if(n == 1) {
            ret.add(0);
        } else if( n  > 1 ) {
            Map<Integer, Set<Integer>> edges = edges(es);
            for (int i = 0; i < n; ++i) {
                //find first leaf node
                if(edges.getOrDefault(i, new HashSet<>()).size() == 1) {
                    int maxDist = bfs(i, edges);

                    Set<Integer> dists = new HashSet<>();
                    if(maxDist % 2 == 1) { //double solution
                        dists.add((maxDist+1)/2);
                        dists.add((maxDist-1)/2);
                    } else { //single solution
                        dists.add(maxDist/2);
                    }
                    ret = bfs(i, edges, dists, maxDist);
                    //BUG: forogt to break from it
                    break;
                }
            }
        }
        return ret;
    }


    public int bfs(int start, Map<Integer, Set<Integer>> edges) {
        int h = -1;
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> nextQ = new LinkedList<>();
        visited.add(start);
        nextQ.add(start);

        while(!nextQ.isEmpty()) {
            Queue<Integer> q = nextQ;
            nextQ = new LinkedList<>();
            h++;
            while(!q.isEmpty()) {
                int v = q.poll();
                for ( int n : edges.getOrDefault(v, new HashSet<>())) {
                    if(!visited.contains(n)) {
                        visited.add(n);
                        nextQ.offer(n);
                    }
                }
            }
        }
        return h;
    }

    public Map<Integer, Set<Integer>> edges ( int [][] es){

        Map<Integer, Set<Integer>> edges = new HashMap<>();
        for (int[] e : es) {
            int start = e[0];
            int end = e[1];

            Set<Integer> startEdges = edges.getOrDefault(start, new HashSet<>());
            startEdges.add(end);
            edges.put(start, startEdges);

            Set<Integer> endEdges = edges.getOrDefault(end, new HashSet<>());
            endEdges.add(start);
            edges.put(end, endEdges);
        }
        return edges;
    }


    public List<Integer> bfs(int start, Map<Integer, Set<Integer>> edges, Set<Integer> dist, int maxH ) {

        int h = -1;
        List<Integer> ret = new LinkedList<>();
        Map<Integer, Integer> path = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> nextQ = new LinkedList<>();
        visited.add(start);
        nextQ.add(start);

        while(!nextQ.isEmpty()) {
            Queue<Integer> q = nextQ;
            nextQ = new LinkedList<>();
            h++;
            while(!q.isEmpty()) {
                int v = q.poll();
                if(h == maxH) {
                    ret = getNode(path, v, dist);
                    break;
                }
                for ( int n : edges.getOrDefault(v, new HashSet<>())) {
                    if(!visited.contains(n)) {
                        visited.add(n);
                        nextQ.offer(n);
                        path.put(n, v);
                    }
                }
            }
        }
        return ret;
    }

    //BUG: not able to deal with h = 0!!!
    public List<Integer> getNode(Map<Integer, Integer> path, Integer node, Set<Integer> keys) {
        List<Integer> ret = new LinkedList<>();
        int h = 0;
        while(null != node) {
            if(keys.contains(h++)) {
                ret.add(node);
            }
            node = path.get(node);
        }
        return ret;
    }


    public static void main(String[] args) {

        int [][] a = {{1,0},{1,2},{1,3}};
        int [][] b = {{0,3},{1,3},{2,3},{4,3},{5,4}};
        int [][] c = {{0,1},{0,2},{2,3},{0,4},{1,5},{2,6},{4,7},{5,8},{5,9},{4,10},{5,11},{8,12},{6,13},{9,14},{1,15},{6,16},{14,17},{3,18},{4,19},{14,20},{9,21},{16,22},{6,23},{7,24},{9,25},{13,26},{1,27},{17,28},{25,29},{0,30},{29,31},{19,32},{5,33},{19,34},{16,35},{19,36},{10,37},{29,38},{9,39},{31,40},{1,41},{1,42},{20,43},{10,44},{20,45},{0,46},{26,47},{10,48},{32,49},{21,50},{5,51},{15,52},{17,53},{39,54},{17,55},{38,56},{38,57},{10,58},{2,59},{4,60},{43,61},{7,62},{15,63},{45,64},{30,65},{41,66},{26,67},{19,68},{2,69},{38,70},{58,71},{20,72},{13,73},{45,74},{55,75},{13,76},{35,77},{17,78},{65,79},{38,80},{15,81},{22,82},{66,83},{20,84},{41,85},{78,86},{82,87},{10,88},{53,89},{10,90},{68,91},{24,92},{65,93},{18,94},{4,95},{26,96},{63,97},{0,98},{70,99},{3,100},{48,101},{41,102},{99,103},{56,104},{10,105},{83,106},{96,107},{8,108},{86,109},{55,110},{72,111},{67,112},{42,113},{63,114},{65,115},{107,116},{29,117},{112,118},{36,119},{55,120},{48,121},{106,122},{31,123},{75,124},{95,125},{8,126},{1,127},{72,128},{70,129},{123,130},{109,131},{46,132},{99,133},{107,134},{48,135},{120,136},{61,137},{7,138},{127,139},{72,140},{132,141},{4,142},{81,143},{85,144},{91,145},{25,146},{88,147},{147,148},{97,149},{145,150},{140,151},{83,152},{71,153},{66,154},{86,155},{48,156},{29,157},{142,158},{13,159},{159,160},{31,161},{66,162},{140,163},{128,164},{129,165},{43,166},{103,167},{136,168},{39,169},{42,170},{154,171},{59,172},{86,173},{61,174},{51,175},{15,176},{139,177},{30,178},{130,179},{165,180},{47,181},{54,182},{68,183},{160,184},{71,185},{39,186},{30,187},{107,188},{43,189},{89,190},{85,191},{183,192},{26,193},{193,194},{172,195},{1,196},{43,197},{178,198},{128,199},{4,200},{150,201},{58,202},{93,203},{183,204},{15,205},{98,206},{131,207},{7,208},{138,209},{129,210},{186,211},{47,212},{66,213},{155,214},{123,215},{75,216},{161,217},{123,218},{190,219},{205,220},{166,221},{44,222},{64,223},{78,224},{125,225},{163,226},{28,227},{26,228},{25,229},{115,230},{68,231},{7,232},{140,233},{7,234},{111,235},{164,236},{43,237},{166,238},{227,239},{95,240},{79,241},{26,242},{196,243},{51,244},{17,245},{53,246},{122,247},{136,248},{170,249},{130,250},{99,251},{93,252},{41,253},{199,254},{66,255},{244,256},{187,257},{202,258},{219,259},{158,260},{112,261},{178,262},{191,263},{223,264},{5,265},{191,266},{78,267},{112,268},{179,269},{141,270},{26,271},{76,272},{106,273},{176,274},{137,275},{36,276},{80,277},{20,278},{57,279},{67,280},{116,281},{14,282},{82,283},{279,284},{7,285},{256,286},{204,287},{137,288},{183,289},{241,290},{67,291},{274,292},{213,293},{149,294},{69,295},{150,296},{156,297},{232,298},{239,299},{293,300},{89,301},{282,302},{88,303},{193,304},{21,305},{185,306},{17,307},{171,308},{261,309},{139,310},{233,311},{207,312},{140,313},{37,314},{241,315},{215,316},{94,317},{4,318},{274,319},{309,320},{105,321},{217,322},{13,323},{204,324},{259,325},{57,326},{95,327},{88,328},{140,329},{176,330},{211,331},{190,332},{142,333},{327,334},{268,335},{132,336},{63,337},{222,338},{272,339},{255,340},{194,341},{307,342},{247,343},{234,344},{38,345},{213,346},{196,347},{298,348},{343,349},{133,350},{100,351},{143,352},{46,353},{40,354},{177,355},{110,356},{331,357},{255,358},{222,359},{123,360},{164,361},{137,362},{27,363},{151,364},{363,365},{131,366},{273,367},{279,368},{101,369},{133,370},{284,371},{100,372},{216,373},{21,374},{51,375},{262,376},{26,377},{176,378},{217,379},{75,380},{332,381},{199,382},{230,383},{380,384},{301,385},{312,386},{385,387},{171,388},{26,389},{0,390},{228,391},{1,392},{164,393},{355,394},{200,395},{113,396},{265,397},{17,398},{184,399},{399,400},{38,401},{356,402},{129,403},{102,404},{326,405},{38,406},{326,407},{391,408},{181,409},{322,410},{366,411},{214,412},{244,413},{305,414},{140,415},{352,416},{314,417},{379,418},{81,419},{388,420},{334,421},{168,422},{69,423},{88,424},{327,425},{404,426},{372,427},{427,428},{397,429},{2,430},{322,431},{16,432},{351,433},{335,434},{291,435},{426,436},{429,437},{143,438},{19,439},{91,440},{206,441},{289,442},{237,443},{404,444},{405,445},{79,446},{85,447},{159,448},{130,449},{281,450},{104,451},{408,452},{405,453},{94,454},{317,455},{202,456},{297,457},{232,458},{341,459},{381,460},{21,461},{127,462},{173,463},{301,464},{300,465},{304,466},{73,467},{439,468},{427,469},{305,470},{153,471},{20,472},{210,473},{105,474},{77,475},{180,476},{233,477},{250,478},{38,479},{412,480},{431,481},{196,482},{344,483},{63,484},{308,485},{236,486},{56,487},{107,488},{114,489},{237,490},{476,491},{440,492},{462,493},{457,494},{204,495},{123,496},{119,497},{393,498},{237,499},{157,500},{265,501},{453,502},{32,503},{151,504}};
        int [][] d = {};
        int [][] e = {{0,1}};
        Solution sol = new Solution();

        System.out.println(sol.findMinHeightTrees(4,a));
        System.out.println(sol.findMinHeightTrees(6,b));
        System.out.println(sol.findMinHeightTrees(505,c));
        System.out.println(sol.findMinHeightTrees(1,d));
        System.out.println(sol.findMinHeightTrees(2,e));
    }
}