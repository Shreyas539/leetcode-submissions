class Solution {
    public boolean isPalindrome(String s) {
        int left =0;
        int right= s.length()-1;

        while(left<right){
            while(left<right && right<s.length() && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while(right >=0 && right>left && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }

            char lchar = s.charAt(left);
            char rchar = s.charAt(right);

            if(Character.toLowerCase(lchar)!=Character.toLowerCase(rchar)){
                return false;
            }else{
                left++;
                right--;
            }
        }
        return true;
    }
}