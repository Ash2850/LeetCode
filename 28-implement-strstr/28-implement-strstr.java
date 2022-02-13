class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.isEmpty()) return 0;
        if(needle.length() > haystack.length()) return -1;
        char[] h = haystack.toCharArray();
        char[] n = needle.toCharArray();
        int i = 0;
        int j = 0; //max limit of j is needle.length
        int firstIndexRepeat = 0;
        boolean freq = false;
        while(i < h.length){
            if(n[j] == h[i]){
                if(h[i] == n[0] && j >= 1 && !freq){ firstIndexRepeat = i; freq = true;}
                j++;
                if(j == n.length) return i-j+1;
            }
            else if(h[i] == n[0] && j >= 1 && !freq){
                j = 1;
            }
            else{
                if(j >= 1 && freq){
                    i = firstIndexRepeat - 1;
                    firstIndexRepeat = 0;
                    freq = false;
                }
                j = 0; //reset
            }
            i++;
        }
        return -1;
    }
}