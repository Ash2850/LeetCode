class Solution {
    public int maxDepth(String s) {
        int max = 0;
        Stack<String> stack = new Stack<String>();
        for(int i =0;i < s.length(); i++)
        {
            if(s.charAt(i) == '(')
            {
                stack.push("(");
                max = (max < stack.size()) ? stack.size(): max;
            }
            else if(s.charAt(i) == ')')
            {
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
            else{
                max = (max < stack.size()) ? stack.size(): max;
            }
        }
       return max; 
    }
}