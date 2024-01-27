//Solution 1
//Bottom up by using 2 variables - no need of a dp array
import java.util.*;
public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int prev = 0;
        if(n == 0)
            System.out.println(0);
        int curr = 1;
        for(int i = 2; i <= n; i++) {
            int temp = curr;
            curr += prev;
            prev = temp;
        }
		System.out.println(curr);
	}
}

//Solution 2
//Top down approach
class Solution {
    public int fib(int n) {
        int[] dp = new int[n + 1];
        for(int i = 0; i <= n; i++)
            dp[i] = -1;
        return fibHelper(n, dp);
    }

    private int fibHelper(int n, int[] dp) {
        if(n == 0 || n == 1)
            return n;
        if(dp[n] != -1)
            return dp[n];
        return dp[n] = fibHelper(n - 1, dp) + fibHelper(n - 2, dp);
    }
}
