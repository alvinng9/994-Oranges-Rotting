package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
            }
        }
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int result = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                size--;
                int x = q.peek()[0];
                int y = q.remove()[1];
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2;
                        q.offer(new int[]{nx, ny});
                        fresh--;
                    }
                }
            }
            if (!q.isEmpty()) {
                result++;
            }
        }
        return (fresh == 0) ? result : -1;
    }
}
