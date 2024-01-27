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
