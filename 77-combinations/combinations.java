class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        bc(1,res,n,k,new ArrayList<>());
        return res;
    }
    private void bc(int start,List<List<Integer>> res,int n,int k,List<Integer> cur){

        if(cur.size()==k){
            res.add(new ArrayList<>(cur));
            return;
        }

        for(int i=start;i<=n;i++){
            
            cur.add(i);
            bc(i+1,res,n,k,cur);
            cur.remove(cur.size()-1);
            
        }
    }
}