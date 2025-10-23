class Solution {
    class Point {
        int x;
        int y;
        int dist;
        Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    
    public ArrayList<ArrayList<Integer>> kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingInt((Point p) -> p.dist).reversed());
        
        for(int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            int dist = (x * x) + (y * y);
            
            pq.offer(new Point(x, y, dist));
            if(pq.size() > k) {
                pq.poll(); 
            }
        }
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        while(!pq.isEmpty()) {
            Point p = pq.poll();
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(p.x);
            ans.add(p.y);
            result.add(ans);
        }
        return result;
    }
}