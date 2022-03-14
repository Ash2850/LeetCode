class Solution 
{
    public int waysToMakeFair(int[] nums) 
    {
        if(nums.length == 0 || nums.length == 1) return nums.length;
        int N = nums.length;
        int[] po = new int[N];
        int[] pe = new int[N];
        boolean oddFlag = false;
        //int unity = 1;
        po[0] = 0;
        pe[0] = nums[0];
        for(int i=1; i < N; ++i)
        {
            if((i & 1)==1)
            {
                po[i] = nums[i]+po[i-1];
                pe[i]= pe[i-1];
                oddFlag = true;
            }
            else
            {
                pe[i] = nums[i]+pe[i-1];
                po[i]= po[i-1];
                oddFlag = false; 
            }
        }
        int count = 0;
        int se, so;
        for(int k=0; k < N; k++)
        {
            if(k == 0)
            {
                se = po[N-1];
                so = pe[N-1] - pe[0];
            }
            else if(k == N)
            {
                if(oddFlag)
                {
                    se = pe[N-2];
                    so = po[N-1];
                }
                else
                {
                    se = pe[N-1];
                    so = po[N-2];
                }
            }
            else
            {
                se = pe[k-1]+(po[N-1]-po[k]);
                so = po[k-1]+(pe[N-1]-pe[k]);
            }
            if(se == so){++count;}
        }
        return count;
    }
}