package Graph;
//https://leetcode.com/problems/count-servers-that-communicate/
import java.util.HashMap;

public class count_server {

	public static void main(String[] args) {
		count_server ob1 = new count_server();
		int grid[][] = { { 1, 0, 0, 1, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0 } };
		System.out.print(ob1.countServers(grid));
	}

	public int countServers(int[][] grid) {
		HashMap<Integer, Integer> map1 = new HashMap<>();
		HashMap<Integer, Integer> map2 = new HashMap<>();
		int c = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					map1.put(i, map1.getOrDefault(i, 0) + 1);
					map2.put(j, map2.getOrDefault(j, 0) + 1);
					c++;
				}
			}
		}
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					if (map1.get(i) == 1 && map2.get(j) == 1) {
						c--;
					}
				}
			}
		}
		return c;

	}
}
