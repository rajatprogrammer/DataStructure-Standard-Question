package DFS;

import java.util.Arrays;
import java.util.PriorityQueue;
/*
 * https://leetcode.com/problems/path-with-minimum-effort/
 * */
public class PathWithMinimum {
	private int[][] DIRECTIONS = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	private int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = { { 1, 2, 2 }, { 3, 8, 2 }, { 5, 3, 5 }, };
		PathWithMinimum ob1 = new PathWithMinimum();
		ob1.helper(0, 0, arr, Integer.MIN_VALUE, new boolean[arr.length][arr[0].length]);
		System.out.println("minimum is -->" + ob1.min);
		System.out.println("minimum is -->" + ob1.optimized(arr));
	}

	private void helper(int x, int y, int[][] heights, int max, boolean[][] visited) {
		if (visited[x][y])
			return;
		if (x == heights.length - 1 && y == heights[0].length - 1)
			min = Math.min(max, min);
		else {
			visited[x][y] = true;
			int oldMax = max;
			for (int[] dir : DIRECTIONS) {
				int newX = x + dir[0], newY = y + dir[1];
				if (outOfBounds(newX, newY, heights))
					continue;
				int height = heights[newX][newY];
				max = Math.max(oldMax, Math.abs(height - heights[x][y]));
				helper(newX, newY, heights, max, visited);
			}

			visited[x][y] = false;
		}
	}

	private boolean outOfBounds(int x, int y, int[][] heights) {
		return x < 0 || x >= heights.length || y < 0 || y >= heights[0].length;
	}

	// optimized using diskastra algorithm and heap

	public int optimized(int[][] heights) {
		int[][] efforts = new int[heights.length][heights[0].length];
		for (int i = 0; i < efforts.length; i++)
			Arrays.fill(efforts[i], Integer.MAX_VALUE);

		// int[] = [dist, row, col];
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
			return a[0] - b[0];
		});

		pq.add(new int[] { 0, 0, 0 });
		while (!pq.isEmpty()) {
			int[] curr = pq.poll();
			int dist = curr[0], x = curr[1], y = curr[2];
			if (dist > efforts[x][y])
				continue;
			if (x == heights.length - 1 && y == heights[0].length - 1)
				return dist;

			for (int[] d : DIRECTIONS) {
				int newX = x + d[0], newY = y + d[1];
				if (!outOfBounds(newX, newY, heights)) {
					int newDist = Math.max(dist, Math.abs(heights[newX][newY] - heights[x][y]));
					if (newDist < efforts[newX][newY]) {
						efforts[newX][newY] = newDist;
						pq.add(new int[] { newDist, newX, newY });
					}
				}
			}
		}

		return -1;
	}

}
