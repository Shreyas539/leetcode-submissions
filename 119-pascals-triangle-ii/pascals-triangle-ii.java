class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res = new ArrayList<>();

        for(int row=0;row<=rowIndex;row++){
            List<Integer> currow = new ArrayList<>();
            currow.add(1);

            for(int j=1;j<row;j++){
                int nextval = res.get(row-1).get(j-1) + res.get(row-1).get(j);
                currow.add(nextval);
            }

            if(row>0) currow.add(1);
            res.add(currow);
        }
        return res.get(rowIndex);
    }
}