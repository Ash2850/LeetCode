class Solution {
    public boolean canBeIncreasing(int[] nums) {
        //if(nums == null || nums.length == 0 ) return false;
        //if(nums.length == 1) return true;
        int index = -1;
        int count = 0;
        //find discontinous points 
        for(int i=0; i < nums.length-1; i++){
            if(nums[i] >= nums[i+1]){
                count++;
                index = i;
            }
        }
        
        /*if zero return true, if only one discontinous point - investigate else return false*/
        
        if(count == 0){
            return true;
        }
        else if(count == 1){
            if(nums.length == 2) return true;
            if(nums.length == 3) return true;
            if(index == 0 || index == nums.length-2){
                return true;//Missed edge case in hurry
            }
            else if(nums[0] <= nums[index+1] && (nums[index+2] > nums[index] || nums[index-1] < nums[index+1])){
                return true; // tricky case [1,2,1,3]
            }
            else if(nums[0] > nums[index+1] && (nums[index+2] > nums[index])){
                return true;
            }
            else{
                return false;
            }
        }
        else return false;
    }
}