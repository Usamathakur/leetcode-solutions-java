class Solution {
    int resultStart;
    int resultLength;
    
    public String longestPalindrome(String s) {
        int strlength = s.length();
        
        if(strlength<2){
            return s;
        }
        for(int start=0;start < strlength -1;start++){
            expandRange(s, start, start);
            expandRange(s, start, start +1);
        }
        return s.substring(resultStart, resultStart + resultLength);
    }
    private void expandRange(String str,int begin, int end){
    while(begin>=0 && end < str.length() && str.charAt(begin) == str.charAt(end)){
        begin--;
        end++;
    }
    if(resultLength < end - begin -1){
        resultStart = begin +1;
        resultLength = end - begin -1;
    }
}
}

