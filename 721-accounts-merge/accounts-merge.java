class Solution {
    int[] parent;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        parent = new int[n];

        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        Map<String,Integer> emailToAccount = new HashMap<>();

        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String email = accounts.get(i).get(j);

                if(emailToAccount.containsKey(email)){
                    int prevAcc = emailToAccount.get(email);
                    union(prevAcc,i);
                }else{
                    emailToAccount.put(email,i);
                }
            }
        }

        Map<Integer,List<String>> merged = new HashMap<>();

        for(String email:emailToAccount.keySet()){
            int account = emailToAccount.get(email);

            int root = find(account);

            merged.computeIfAbsent(root,k-> new ArrayList<>()).add(email);
        }

        List<List<String>> res = new ArrayList<>();

        for(Map.Entry<Integer,List<String>> entry:merged.entrySet()){
            int root = entry.getKey();
            List<String> emails = entry.getValue();
            Collections.sort(emails);

            List<String> account = new ArrayList<>();
            account.add(accounts.get(root).get(0));
            account.addAll(emails);
            res.add(account);
        }
        return res;
    }
    private void union(int a,int b){
        int rootA = find(a);
        int rootB = find(b);

        if(rootA==rootB)return;

        parent[rootB] = rootA;
    }

    private int find(int x){
        if(parent[x]==x){
            return x; 
        }

        return parent[x] = find(parent[x]);
    }
}