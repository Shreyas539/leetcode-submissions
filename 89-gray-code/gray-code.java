class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        
        int len = 1<<n;
        for(int i=0;i<len;i++){
            int num = i ^ (i>>1);
           
                res.add(num);
            
        }
        return res;
    }
}