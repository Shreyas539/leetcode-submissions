class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        bc(s,res,0,new ArrayList<>());
        return res;
    }
    private void bc(String s,List<String> res,int start,List<String> cur){
        if(cur.size()==4){
            if(start == s.length()){

            res.add(String.join(".",cur));
            }
        }

        for(int len=1;len<=3;len++){
            if(start+len>s.length()) break;
            String curSeg = s.substring(start,start+len);

            if((curSeg.startsWith("0") && curSeg.length()>1) || Integer.parseInt(curSeg)>255){
                continue;
            }
            cur.add(curSeg);
            bc(s,res,start+len,cur);
            cur.remove(cur.size()-1);
        }
    }
}