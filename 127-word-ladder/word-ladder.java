class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        int steps = 1;

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        while(!q.isEmpty()){


            int len = q.size();

            for(int i=0;i<len;i++){
                String word = q.poll();
                if(word.equals(endWord)) return steps;
                char[] wordArr = word.toCharArray();

                for(int j=0;j<word.length();j++){
                    char orgchar = word.charAt(j);

                    for(char c='a';c<='z';c++){
                        if(c==orgchar)continue;

                        wordArr[j]=c; 

                        String newword = new String(wordArr);
                        if(wordSet.contains(newword)){
                            wordSet.remove(newword);
                            q.offer(newword);
                        }
                    }

                    wordArr[j]=orgchar;
                }
            }
            steps++;
        }

        return 0;
    }
}