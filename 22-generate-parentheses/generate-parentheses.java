class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(n,new StringBuilder(),res,0,0);
        return res;
    }
    private void backtrack(int n,StringBuilder cur,List<String> res,int open,int close){
        if(cur.length()==2*n){
            res.add(cur.toString());
            return;
        }

        if(open<n){
            cur.append('(');
            backtrack(n,cur,res,open+1,close);
            cur.deleteCharAt(cur.length()-1);
        }
        if(close<open){
            cur.append(')');
            backtrack(n,cur,res,open,close+1);
            cur.deleteCharAt(cur.length()-1);
        }
    }
}