package probability;
//https://leetcode.com/problems/random-point-in-non-overlapping-rectangles/
import java.util.Arrays;
import java.util.Random;

class Solution {

    int[][] rects;
    int[] offsets;
    int range;
    Random r;
    public Solution(int[][] rects) {
        this.rects = rects;
        this.offsets = new int[rects.length];
        this.range = 0;
        r = new Random();
        
        for (int i = 0; i < rects.length; i++) {
            int[] rect = rects[i];
            
            int x1 = rect[0],
                y1 = rect[1],
                x2 = rect[2],
                y2 = rect[3];
            
            offsets[i] = range;
            range += (x2 - x1 + 1) * (y2 - y1 + 1);
        }
        
    }
    
    public int[] pick() {
        int randIdx = r.nextInt(range), 
            rectIdx = Arrays.binarySearch(offsets, randIdx); 
        
        if (rectIdx < 0) {
            rectIdx = Math.abs(rectIdx + 2);
        }
        
        int[] rect = rects[rectIdx];
        
        int idx = randIdx - offsets[rectIdx], 
            x = rect[0], 
            y = rect[1],
            width = rect[2] - rect[0] + 1, 
            height = rect[3] - rect[1] + 1, 
            row = idx / width, 
            col = idx % width; 
        
        return new int[]{x + col, y + row};   
    }
}

