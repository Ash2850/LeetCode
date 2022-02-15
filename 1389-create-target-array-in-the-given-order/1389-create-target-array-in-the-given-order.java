class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int[] arr = new int[nums.length];
        /*for(int i =0; i< nums.length; i++){
            arr[i] = -1;
        }*/
        for(int i =0; i< nums.length; i++){
            if(index[i] < i && i!=0)
            {
                int temp = arr[index[i]];
                for(int j = index[i]; j < arr.length-1; j++)
                {
                    int temp1 = arr[j+1];
                    arr[j+1] = temp;
                    temp = temp1;
                }
                arr[index[i]] = nums[i];
            }
            else
            {
                arr[index[i]] = nums[i];
            }
        }
        return arr;
    }
}