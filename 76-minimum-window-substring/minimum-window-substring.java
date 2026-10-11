class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length()) return "";
        Map<Character,Integer> freqOfT = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();

        for(char ch:t.toCharArray()){
            freqOfT.put(ch,freqOfT.getOrDefault(ch,0)+1);
        }
        int need = freqOfT.size();
        int l=0;
        int start =0;
        int have=0;
        int minLen = Integer.MAX_VALUE;
        for(int r=0;r<s.length();r++){
            char ch = s.charAt(r);
            window.put(ch,window.getOrDefault(ch,0)+1);

            if(freqOfT.containsKey(ch) && window.get(ch).intValue()==freqOfT.get(ch).intValue() ){
                have++;
            }

            while(have==need){
                if(r-l+1<minLen){
                    minLen  = r-l+1;
                    start = l;
                }
                char leftChar = s.charAt(l);
                window.put(leftChar,window.get(leftChar)-1);
                if(freqOfT.containsKey(leftChar) && window.get(leftChar)<freqOfT.get(leftChar)){
                    have--;
                }
                l++;
            }
        }

        return minLen==Integer.MAX_VALUE ? "" : s.substring(start,start+minLen);
    }
}