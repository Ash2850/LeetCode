class Solution {
    public boolean validMountainArray(int[] arr) {
        if(arr.length < 3) return false;
        int count = 0;
        int top = 0;
        for(int i=0; i< arr.length-1; i++){
            if(arr[i] == arr[i+1]) return false; //At any time plateauing
            else if(arr[i] > arr[i+1] && count < 1){
                count++;
                top = i;
                if(top == 0) return false;
            }
          
            else if(arr[top] > arr[i] && arr[i] > arr[i+1] && count >= 1){
                count++;
            }
            else if(arr[top] <=  arr[i] && count >= 1) return false;
            else if(arr[i] <= arr[i+1] && count >= 1) return false;
            
        }
        if(arr[top] ==  arr[arr.length - 1] && count >= 1){return false;}
        //if(arr[arr.length - 1] > arr[])
        if(count == arr.length - top -1) return true;
        return false;
    }
}