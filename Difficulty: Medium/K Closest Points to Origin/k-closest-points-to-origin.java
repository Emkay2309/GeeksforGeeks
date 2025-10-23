class Solution {
    class Point implements Comparable<Point>{
        // to store points along with their distance from origin
        int x;
        int y;
        int dist; // distance from origin
        Point(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
        public int compareTo(Point p){
            // max-heap
            return p.dist-this.dist;
        }
    }
    public ArrayList<ArrayList<Integer>> kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>(); // k-size PQ, stores k closest points to origin at every instance
        for(int i=0; i<points.length; i++){
            int x = points[i][0];
            int y = points[i][1];
            // int dist = (int)Math.sqrt((x*x) + (y*y)); // dist of this point from origin
            // We don’t need sqrt() - because comparing distances squared is equivalent to comparing distances (square root is monotonic).
            int dist = (x*x) + (y*y);
            pq.offer(new Point(x, y, dist)); // insert this point to PQ
            if(pq.size()>k) pq.poll(); // remove the farthest if exceeds size k
        }
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        while(!pq.isEmpty()){
            // now store k closest points from pq to final result
            Point p = pq.poll();
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(p.x);
            ans.add(p.y);
            result.add(ans);
        }
        return result;
    }
}
