class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        int steps = 1;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        while(!q.isEmpty()){

            int size = q.size();

            for(int i=0;i<size;i++){
                String curword = q.poll();
                char[] curwordarr = curword.toCharArray();

                if(curword.equals(endWord)) return steps;
                for(int j=0;j<curword.length();j++){
                    char orgchar = curwordarr[j];
                    for(char ch='a';ch<='z';ch++){
                        if(ch==orgchar) continue;

                        curwordarr[j]=ch;

                        String newword = new String(curwordarr);

                        if(set.contains(newword)){
                            q.offer(newword);
                            set.remove(newword);
                        }

                    }
                    curwordarr[j] = orgchar;
                }
            }
            steps++;
        }

        return 0;
    }
}