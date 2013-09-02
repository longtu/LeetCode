public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(matrix == null||matrix.length==0||matrix[0].length==0 )
            return res;
        int height = matrix.length;
        int width = matrix[0].length;
        return sprialOrder(matrix, 0, 0, width-1, height-1); 
    }
    private ArrayList<Integer> sprialOrder(int[][] matrix, int startX,
            int startY, int width, int height){
        //Missed the single line; should have captured during test!!!!!!!!!!
        if(width == 0 && height ==0){
            ArrayList<Integer> res =  new ArrayList<Integer>();
            res.add(matrix[startY][startX]);
            return res;
        }
        if(height ==0){
            ArrayList<Integer> res =  new ArrayList<Integer>();
            for(int x = startX; x<= startX+width; ++x)
                res.add(matrix[startY][x]);
            return res;
        }
        if(width ==0){
            ArrayList<Integer> res =  new ArrayList<Integer>();
            for(int y = startY; y<= startY+height; ++y)
                res.add(matrix[y][startX]);
            return res;
        }

        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int x = startX; x< startX+width; ++x)
            res.add(matrix[startY][x]);
        for(int y = startY; y< startY+height;++y)
            res.add(matrix[y][startX+width]);
        for(int x = startX+width; x > startX; --x)
            res.add(matrix[startY+height][x]);
        for(int y = startY+height; y> startY;--y)
            res.add(matrix[y][startX]);
        if(width >= 2 && height >=2 ){
            res.addAll( sprialOrder(matrix, startX+1, startY+1, width-2,
                        height-2));
        }
        return res;
    }
}
