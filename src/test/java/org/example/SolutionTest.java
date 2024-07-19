package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void orangesRottingTest() {
        Solution solution = new Solution();
        int[][] inputOne = new int[][] {
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };
        assertEquals(4, solution.orangesRotting(inputOne));

        int[][] inputTwo = new int[][] {
                {2,1,1},
                {0,1,1},
                {1,0,1}
        };
        assertEquals(-1, solution.orangesRotting(inputTwo));

        int[][] inputThree = new int[][] {
                {0, 2}
        };
        assertEquals(0, solution.orangesRotting(inputThree));

        int[][] inputFour = new int[][] {
                {1},
                {2}
        };
        assertEquals(1, solution.orangesRotting(inputFour));
    }

}