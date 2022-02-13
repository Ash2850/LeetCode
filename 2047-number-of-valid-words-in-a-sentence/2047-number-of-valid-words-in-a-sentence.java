class Solution {
    public int countValidWords(String sentence) {
        char[] ch = sentence.concat(" ").toCharArray();
        int i = 0;
        int count = 0;
        int isPrevSpace = 0 ;
        StringBuilder sb = new StringBuilder();
        Helper helper = new Helper();
        while(i < ch.length){
            if (ch[i] != ' ' )
            {
                sb.append(ch[i]);
                //System.out.println("String ready to be investigated: " + sb.toString());
                //System.out.println(String.format("Value of index %d ", i)+ "char added is : " + ch[i]);
            }  
            else{
                //System.out.println("String detected here is: " + sb.toString() + String.format(" at index : %d", i));
                if((i != 0) && (ch[i-1] != ' ' || i == ch.length ) && helper.checkValidWord(sb.toString()))
                {
                    count++;  
                    System.out.println("VALID String being added is: " + sb.toString());
                    //sb = new StringBuilder();
                }
                sb = new StringBuilder();
            }     
            i++;
        }
        return count;
    }
}

class Helper{
    public boolean checkValidWord(String s){
        if(s.matches("[a-z]+[-][a-z]+[!.,]?") || s.matches("[a-z]+[!.,]?") || s.matches("[!.,]")){
            return true;
        }
        return false;
    }
}