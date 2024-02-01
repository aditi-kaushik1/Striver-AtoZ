class Solution {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] vis = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        vis[0] = true;
        while(!q.isEmpty()) {
            int currNode = q.remove();
            bfs.add(currNode);
            
            for(Integer it: adj.get(currNode)) {
                if(vis[it] == false) {
                    q.add(it);
                    vis[it] = true;
                }
            }
        }
        return bfs;
    }
}
