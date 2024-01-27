/*LeetCode
Given a triangle array, return the minimum path sum from top to bottom.
For each step, you may move to an adjacent number of the row below. 
More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row. */

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = (m*(m + 1))/2;
        if(m == 1)
            return triangle.get(0).get(0);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> rowOne = new ArrayList<>(Arrays.asList(triangle.get(0).get(0)));
        ans.add(rowOne);
        for(int i = 1; i < m; i++) {
            List<Integer> currRow = new ArrayList<>();
            currRow.add(ans.get(i - 1).get(0) + triangle.get(i).get(0));
            ans.add(currRow);
        }

        int min = ans.get(m - 1).get(0);
        for(int i = 1; i < m; i++) {
            for(int j = 1; j <= i; j++) {
                int curr = triangle.get(i).get(j);
                if(j == i)
                    curr += ans.get(i - 1).get(j - 1);
                else
                    curr += Math.min(ans.get(i - 1).get(j), ans.get(i - 1).get(j - 1));
                ans.get(i).add(curr);
                if(i == m - 1)
                    min = Math.min(min, curr);
            }
        }
        return min;
    }
}
