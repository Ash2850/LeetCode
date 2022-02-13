class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        int N = nums.length;
        List<String> res = new ArrayList<String>();
        Helper helper = new Helper();
        if(nums.length == 0) {
            res.add(helper.set2String(lower, upper));
            return res;
        }
        for(int i = 0; i < N; i++){
            if(i == 0 && i == N-1){
                if(lower == upper) return res;
                if(nums[i] == upper){res.add(helper.set2String(lower, nums[i]-1));}
                else if(nums[i] == lower){res.add(helper.set2String(nums[i]+1, upper));}
                else{
                    res.add(helper.set2String(lower, nums[i]-1));
                    res.add(helper.set2String(nums[i]+1, upper));
                }
            }
            else if(i == 0){
                if(nums[i] > lower){
                   res.add(helper.set2String(lower, nums[i]-1));
                }
            }
            else if(i == N-1){
                if(nums.length == 2 && nums[i] - nums[i-1] > 1){
                    res.add(helper.set2String(nums[i-1]+1, nums[i]-1));
                }
                if(nums[i] < upper){
                    res.add(helper.set2String(nums[i]+1, upper));
                }
            }
            else{
                if(nums[i] - nums[i-1] > 1){    
                    String temp1 = helper.set2String(nums[i-1]+1, nums[i]-1);
                    if(!res.contains(temp1)){
                        res.add(temp1);
                    }
                }
                if(nums[i+1] - nums[i] > 1){
                    String temp = helper.set2String(nums[i]+1, nums[i+1]-1);
                    if(!res.contains(temp)){
                        res.add(temp);
                    }
                }
            }
        }
        return res;
    }
}

class Helper{
    public String set2String(int l, int u){
        if(l == u){
            return new String(Integer.toString(l));
        }
        else{
            return new StringBuilder()
                        .append(Integer.toString(l))
                        .append("-").append(">")
                        .append(Integer.toString(u)).toString();
        }
    }
}

