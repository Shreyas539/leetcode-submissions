class MapSum {
    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
        int sum=0;
    }
    TrieNode root ;
    HashMap<String,Integer> mp;

    public MapSum() {
        root = new TrieNode();
        mp = new HashMap<>();
    }
    
    public void insert(String key, int val) {
        int delta = val - mp.getOrDefault(key,0);
        mp.put(key,val);
        TrieNode cur = root;

        for(char ch:key.toCharArray()){
            int idx = ch-'a';
            if(cur.children[idx]==null){
                cur.children[idx] = new TrieNode();
            }
            cur = cur.children[idx];
            cur.sum+=delta;
        }
        cur.isEnd = true;


        return;
    }
    
    public int sum(String prefix) {
        TrieNode cur = root;
        for(char ch:prefix.toCharArray()){
            int idx = ch-'a';
            if(cur.children[idx]==null){
                return 0;
            }
            cur = cur.children[idx];
        }
        return cur.sum;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */