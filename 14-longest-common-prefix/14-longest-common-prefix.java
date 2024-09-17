class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1) return strs[0];
        if(strs[0].length() == 0) return strs[0];
        int maxLCP = 0;
        String exp = new String(strs[0]);
        int count = 0;
        int N = strs[0].length();
        int i;
        for(i = 0; i< N; i++){
            count = 0;
            for(String s : strs){
                String sub = new String();
                if(i+1 <= s.length()){ //Possible flaw - check again later
                    sub = s.substring(0, i+1);
                }
                
                if(sub.contains(exp.substring(0, i+1))){
                    count ++;
                }
            }    
            if(count == strs.length){
                maxLCP = i;
            }
            else if(count < strs.length && i == 0){ return new String();}
        }
        return new String(exp.substring(0, maxLCP+1));
    }
}

