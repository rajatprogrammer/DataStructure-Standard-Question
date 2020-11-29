package DFS;
//https://leetcode.com/problems/unique-paths-iii/
public class unique_path_3 {

	public static void main(String[] args) {
		int grid[][] = {{1,0,0,0},{0,0,0,0},{0,0,2,-1}};
		unique_path_3 ob1 = new unique_path_3();
		System.out.print(ob1.uniquePathsIII(grid));
	}
	public int uniquePathsIII(int[][] grid) {
        int count = 0;
        int sr = 0;
        int sc = 0;
        int er = 0;
        int ec = 0;
        for(int i=0; i<grid.length ; i++){
          for(int j=0 ; j<grid[0].length ; j++){
             if(grid[i][j] == 0){
                 count++;
             }
             else if(grid[i][j] == 1){
               sr = i;
               sc = j;
             }
            else if(grid[i][j] == 2){
               er = i;
               ec = j;
            }
          }
        }
       
       uniquePathsIII_(grid , sr , sc , er , ec , count);
       return ans;
        
    }
    int ans = 0;
   public void uniquePathsIII_(int grid[][] , int row , int col , int erow , int ecol , int count ){
      if(row == erow && col == ecol){
         if(count == -1){
            ans++;
         }
         return;
      }
     
      int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};
      
      grid[row][col] = -1;
     
      for(int d=0 ; d<4 ; d++){
        
           int nrow = row + dir[d][0];
           int ncol = col + dir[d][1];
           
           if(nrow>=0 && ncol >=0 && nrow<grid.length && ncol<grid[0].length && grid[nrow][ncol]!=-1){
              uniquePathsIII_(grid , nrow , ncol , erow , ecol , count - 1);
           }
      }
      
      grid[row][col] = 0; //backtrack
   }
}
