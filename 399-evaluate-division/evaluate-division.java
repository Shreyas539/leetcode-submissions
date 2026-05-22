import java.util.AbstractMap.SimpleEntry;

class Solution {
    class Pair{
        String node;
        double weight;
        
        public Pair(String node,double weight){
            this.node = node;
            this.weight = weight;
        }
    }
    

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = values.length;

        Map<String,List<Pair>> adj = new HashMap<>();

        for(int i=0;i<n;i++){
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double wt = values[i];

            adj.putIfAbsent(u,new ArrayList<>());
            adj.putIfAbsent(v,new ArrayList<>());

            adj.get(u).add(new Pair(v,wt));
            adj.get(v).add(new Pair(u,1.0/wt));
        }

        double[] ans = new double[queries.size()];

        for(int i=0;i<queries.size();i++){
            String u = queries.get(i).get(0);
            String v = queries.get(i).get(1);

            ans[i] = bfs(adj,u,v);
        }

        return ans;

    }

    private double bfs(Map<String,List<Pair>> adj,String u,String v){
        if(!adj.containsKey(u) || !adj.containsKey(v)) return -1.0;

        if(u.equals(v)) return 1.0;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(u,1.0));
        Set<String> vis = new HashSet<>();
        vis.add(u);

        while(!q.isEmpty()){

            Pair cur = q.poll();
            String node = cur.node;
            double wt = cur.weight;

            if(node.equals(v)) return wt;

            for(Pair nbrs : adj.get(node)){
                if(!vis.contains(nbrs.node)){
                    vis.add(nbrs.node);
                    q.offer(new Pair(nbrs.node,wt*nbrs.weight));
                }
            }
        }

        return -1.0;
    }


}