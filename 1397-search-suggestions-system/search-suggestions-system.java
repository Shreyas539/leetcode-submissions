class Solution {
    class TrieNode{
        boolean isEnd;
        TrieNode[] children = new TrieNode[26];
        List<String> word = new ArrayList<>();
    }
    TrieNode root = new TrieNode();
    
    List<List<String>> res = new ArrayList<>();
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);

        for(String word:products){
            insert(word);
        }
        int n = searchWord.length();
        for(int i=0;i<n;i++){
            search(searchWord.substring(0,i+1),root);
        }    
        return res;
    }
    private void search(String word,TrieNode root){
        List<String> curList = new ArrayList<>();
        TrieNode cur = root;
        for(char ch:word.toCharArray()){
            int idx = ch-'a';
            if(cur.children[idx]==null){
                res.add(new ArrayList<>());
                return;
            }
            cur = cur.children[idx];
            
        }

        res.add(new ArrayList<>(cur.word));

    }
    private void insert(String word){
        TrieNode cur = root;

        for(char ch:word.toCharArray()){
            int idx = ch-'a';
            if(cur.children[idx]==null){
                cur.children[idx] = new TrieNode();
            }
            cur = cur.children[idx];
            if(cur.word.size()<3){
                cur.word.add(word);
            }
        }
        cur.isEnd = true;
    }
}