class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        bc(n,res,new StringBuilder(),0,0);
        return res;
    }
    private void bc(int n,List<String> res,StringBuilder sb,int open,int close){
        if(sb.toString().length() == 2*n){
            res.add(sb.toString());
            return;
        }

        if(open<n){
            sb.append("(");
            bc(n,res,sb,open+1,close);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close<open){
            sb.append(")");
            bc(n,res,sb,open,close+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}