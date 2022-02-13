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
                    System.out.println("Inside first duplication check");
                    System.out.println(String.format("Numbers are %d and %d", nums[i], nums[i-1]));
                    String temp1 = helper.set2String(nums[i-1]+1, nums[i]-1);
                    System.out.println(res);
                    if(!res.contains(temp1)){
                        System.out.println("Inside equals comparision");
                        res.add(temp1);
                    }
                }
                if(nums[i+1] - nums[i] > 1){
                    System.out.println("Inside second duplication check");
                    System.out.println(String.format("Numbers are %d and %d", nums[i], nums[i+1]));
                    String temp = helper.set2String(nums[i]+1, nums[i+1]-1);
                    System.out.println(res);
                    if(!res.contains(temp)){
                        System.out.println("Inside equals comparision");
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
        System.out.println(String.format("Upper and lower bounds are %d and %d", u, l));
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

