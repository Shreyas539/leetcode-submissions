class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;

        // PriorityQueue<int[]> pqleft = new PriorityQueue<>((a,b)->a[0]-b[0]);
        // PriorityQueue<int[]> pqright = new PriorityQueue<>((a,b)->a[0]-b[0]);
         PriorityQueue<int[]> pqleft = new PriorityQueue<>((a,b) -> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
        PriorityQueue<int[]> pqright = new PriorityQueue<>((a,b) -> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);

        int left = 0,right=n-1;

        while(left<candidates && left<=right){
            pqleft.offer(new int[]{costs[left],left++});
        }
        while(right>=n-candidates && right>=left){
            pqright.offer(new int[]{costs[right],right--});
        }

        long ans = 0;
        int cnt=0;
        for(int hire=0;hire<k;hire++){
            if(pqright.isEmpty() || (!pqleft.isEmpty() && pqleft.peek()[0]<=pqright.peek()[0])){
                int[] worker = pqleft.poll();
                ans+=worker[0];
                if(left<=right){
                    pqleft.offer(new int[]{costs[left],left++});
                }
            }else{
                int[] worker = pqright.poll();
                ans+=worker[0];
                if(right>=left){
                    pqright.offer(new int[]{costs[right],right--});
                }
            }
        }

        return ans;
    }
}