class Solution {
    public int[] shuffle(int[] nums, int n){
        int[] arr = new int[2*n];
        for(int i=0, j=n, k=0; i< n && j<2*n && k < 2*n; i++, j++, k=k+2){
            arr[k] = nums[i];
            arr[k+1] = nums[j];
        }
        return arr;
    }
}