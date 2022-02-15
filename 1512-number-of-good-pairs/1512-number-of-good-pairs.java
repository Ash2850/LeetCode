class Solution {
    public int numIdenticalPairs(int[] nums){
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length; i++)
        {
            //Integer a = Integer.valueOf(nums[i]);
            if(map.containsKey(nums[i]))
            {
                int prev = map.get(nums[i]);
                map.put(nums[i], prev+1);
                count = count + prev + 1;
            }
            else
            {
                map.put(nums[i], 0);
            }
        }
    return count;
    }
}