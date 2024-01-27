/* Coding Ninjas
Problem statement
Ninja has a 'GRID' of size 'R' X 'C'. Each cell of the grid contains some chocolates. 
Ninja has two friends Alice and Bob, and he wants to collect as many chocolates as possible with the help of his friends.
Initially, Alice is in the top-left position i.e. (0, 0), and Bob is in the top-right place i.e. (0, ‘C’ - 1) in the grid. 
Each of them can move from their current cell to the cells just below them. When anyone passes from any cell, 
he will pick all chocolates in it, and then the number of chocolates in that cell will become zero. 
If both stay in the same cell, only one of them will pick the chocolates in it.
If Alice or Bob is at (i, j) then they can move to (i + 1, j), (i + 1, j - 1) or (i + 1, j + 1). 
They will always stay inside the ‘GRID’.
Your task is to find the maximum number of chocolates Ninja can collect with the help of his friends by following the above rules. */

//3-d dp
// import java.util.* ;
// import java.io.*; 
// public class Solution {
// 	public static int maximumChocolates(int r, int c, int[][] grid) {
// 		int[][][] dp = new int[r][c][c];
// 		for(int i = 0; i < c; i++) {
// 			for(int j = 0; j < c; j++) {
// 				dp[0][i][j] = Integer.MIN_VALUE;
// 			}
// 		}
// 		dp[0][0][c - 1] = grid[0][0] + grid[0][c- 1]; 

// 		int finalAns = Integer.MIN_VALUE;
// 		for(int i = 1; i < r; i++) {
// 			for(int p = 0; p < c; p++) {
// 				for(int q = 0; q < c; q++) {
// 					int max = Integer.MIN_VALUE;
// 					for(int m = p - 1; m <= p + 1; m++) {
// 						for(int n = q - 1; n <= q + 1; n++) {
// 							if(isValidIndex(m, n, c))
// 								max = Math.max(max, dp[i - 1][m][n]);
// 						}
// 					}
// 					dp[i][p][q] = max + grid[i][p];
// 					if(p != q)
// 						dp[i][p][q] += grid[i][q];
// 					if(i == r - 1)
// 						finalAns = Math.max(finalAns, dp[i][p][q]);
// 				}
// 			}
// 		}
// 		return finalAns;
// 	}

// 	private static boolean isValidIndex(int p, int q, int c) {
// 		return (p >= 0 && q >= 0 && p < c && q < c);
// 	}
// }

//2-d DP
import java.util.* ;
import java.io.*; 
public class Solution {
	public static int maximumChocolates(int r, int c, int[][] grid) {
	    int[][] prev = new int[c][c];
		int[][] dp = new int[c][c];
		for(int i = 0; i < c; i++) {
			for(int j = 0; j < c; j++) {
				prev[i][j] = Integer.MIN_VALUE;
			}
		}
		prev[0][c - 1] = grid[0][0] + grid[0][c- 1]; 

		int finalAns = Integer.MIN_VALUE;
		for(int i = 1; i < r; i++) {
			for(int p = 0; p < c; p++) {
				for(int q = 0; q < c; q++) {
					int max = Integer.MIN_VALUE;
					for(int m = p - 1; m <= p + 1; m++) {
						for(int n = q - 1; n <= q + 1; n++) {
							if(isValidIndex(m, n, c))
								max = Math.max(max, prev[m][n]);
						}
					}
					dp[p][q] = max + grid[i][p];
					if(p != q)
						dp[p][q] += grid[i][q];
					if(i == r - 1)
						finalAns = Math.max(finalAns, dp[p][q]);
				}
			}
			for(int p = 0; p < c; p++) {
				for(int q = 0; q < c; q++) {
					prev[p][q] = dp[p][q];
				}
			}
		}
		return finalAns;
	}

	private static boolean isValidIndex(int p, int q, int c) {
		return (p >= 0 && q >= 0 && p < c && q < c);
	}
}
