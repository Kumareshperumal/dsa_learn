package september_learn.dfs;

public class MaxAreaIsland {
    public static void main(String[] args) {
        int[][] arr = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};
//        int[][] arr = {{0,1},{0,1}};
        System.out.println(maxAI(arr));
    }

    public static int maxAI(int[][] grid) {
        int max = 0;
        for(int r =0;r<grid.length;r++){
            for(int c=0;c<grid[0].length;c++){
                max = Math.max(max,dfsM(grid,r,c));
            }
        }
        return max;
    }

    private static int dfsM(int[][] grid, int r, int c){
        if(r > grid.length-1 || c > grid[0].length-1 || r < 0 || c < 0 ) return 0;
        if(grid[r][c] == 1){
            grid[r][c] = 2;
            int count = 1;
            count += dfsM(grid, r+1, c);
            count += dfsM(grid, r-1, c);
            count += dfsM(grid, r, c+1);
            count += dfsM(grid, r, c-1);
            return count;
        }
        return 0;
    }
}
