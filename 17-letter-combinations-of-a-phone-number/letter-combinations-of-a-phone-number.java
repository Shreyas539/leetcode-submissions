class Solution {
    String[] keypad = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length()==0){
            return res;
        }
        backtrack(digits,0,res,new StringBuilder());
        return res;
    }
    private void backtrack(String digits,int idx,List<String> res,StringBuilder cur){
        if(idx==digits.length()){
            res.add(cur.toString());
            return;
        }

        String letters = keypad[digits.charAt(idx)-'0'];
        for(char c:letters.toCharArray()){
            cur.append(c);
            backtrack(digits,idx+1,res,cur);
            cur.deleteCharAt(cur.length()-1);
        }
    }
}