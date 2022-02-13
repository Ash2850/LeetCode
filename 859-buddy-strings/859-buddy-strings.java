class Solution {
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length() ||( s.length() == 1 && goal.length() == 1)) return false;
        char[] ch = s.toCharArray();
        char[] gch = goal.toCharArray();
        if(s.equals(goal)){
            HashSet<Character> set = new HashSet<>();
            for(int i = 0; i < ch.length; i++){
                if(set.contains(Character.valueOf(ch[i]))){
                    return true;
                }
                else{
                    set.add(Character.valueOf(ch[i]));
                }
            }
            return false;
        }
        else{
            int fI = 0;
            int sI = 0;
            int count = 0;
            int i = 0;
            while(i < ch.length){
                if(ch[i] != gch[i]){
                    count++;
                    if(count == 1) {
                        fI = i;
                    }
                    if(count == 2) {
                        sI = i;
                    }
                }
                i++;
            }
            if(count == 2){
                char temp = ch[fI];
                ch[fI] = ch[sI];
                ch[sI] = temp;
                String str = new String(ch);
                if(str.equals(goal)) return true;
                else return false;
            }
            else return false;
        }
    }
}