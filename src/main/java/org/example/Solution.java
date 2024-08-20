package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int orangesRotting(int[][] grid) {
        //create a queue of int array
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        //iterate through the given 2d array
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                //find the total of fresh oranges
                if (grid[i][j] == 1) {
                    fresh++;
                    //add locations of rotten oranges into the queue
                } else if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        //create 2 arrays that represent 4 directions a rotten orange can spread
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        int time = 0;
        //process through the queue of rotten oranges
        while(!queue.isEmpty()) {
            //in order to find the time it takes for all the oranges to go rotten
            //each batch of rotten oranges will be processed at different times
            int size = queue.size();
            while(size > 0) {
                size--;
                int x = queue.peek()[0];
                int y = queue.remove()[1];
                //spread rotteness to oranges above, below, on the left, and on the right
                //of the current rotten orange
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    //check if the new location is out of bounds
                    if (nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length && grid[nx][ny] == 1) {
                        //make the current fresh orange rotten
                        grid[nx][ny] = 2;
                        //add the new rotten orange to the queue
                        queue.offer(new int[]{nx, ny});
                        //decrease the total of fresh oranges
                        fresh--;
                    }
                }
            }
            //increase the time
            if (!queue.isEmpty()) {
                time++;
            }
        }
        //if there are still fresh oranges left, then it is impossible to find a time
        //to make all the oranges rotten
        return (fresh == 0) ? time : -1;
    }
}
