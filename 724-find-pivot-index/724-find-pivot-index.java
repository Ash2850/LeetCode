class Solution 
{
    public int pivotIndex(int[] nums) 
    {
        int[] p = new int[nums.length];
        p[0] = nums[0];
        for(int i=1; i < nums.length; i++)
        {
            p[i] = nums[i]+p[i-1];
        }
        
        int l, r;
        for(int j=0; j < nums.length; j++)
        {
            if(j==0)
            {
                l = 0;
            }
            else
            {
                l = p[j-1];
            }
            
            if(j==nums.length - 1)
            {
                r = 0;
            }
            else
            {
                r = p[nums.length-1]-p[j];
            }
            if(l==r) return j;
        }
        return -1;
    }
}