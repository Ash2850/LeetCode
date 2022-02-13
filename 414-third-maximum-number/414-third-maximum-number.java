class Solution {
    public int thirdMax(int[] nums) {
        if(nums.length == 1) return nums[0];
        int a = (nums[0] >= nums[1]) ? nums[0]:nums[1];
        int b = (nums[0] >= nums[1]) ? nums[1]:nums[0];
        if(nums.length == 2) return a;
        int temp;
        int c = Integer.MIN_VALUE;
        boolean isNegativeInfinity = false;
        if(a == Integer.MIN_VALUE|| b == Integer.MIN_VALUE) {isNegativeInfinity = true;}
        
        for(int i = 2; i< nums.length; i++){
            if(nums[i] == Integer.MIN_VALUE){
                isNegativeInfinity = true;
            }
            if(nums[i] == a || nums[i] == b){
                //do_nothing
            }
            if(nums[i] < a && nums[i] < b && (nums[i] > c || b == c)){
                c = nums[i];
            }
            if(nums[i] < a && nums[i] > b){
                c = b;
                b = nums[i];
            }
            if(nums[i] > a && nums[i] > b){
                   temp = b;
                   c = temp;
                   b = a;
                   a = nums[i];
            }
        }
        if((c == Integer.MIN_VALUE && !isNegativeInfinity) || c == b || a == b || (a == b && b == c) ) return a;
        else return c;
    }
}