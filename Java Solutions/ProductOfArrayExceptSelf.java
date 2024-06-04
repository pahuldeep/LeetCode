public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {

        //Forward product
        int[] answer = new int[nums.length];
        answer[0] = 1;
        for(int i = 1; i < nums.length; i++){
            answer[i] = answer[i-1] * nums[i-1];
        }

        //Backward product
        int product = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            answer[i] = product * answer[i];
            product = product * nums[i];
        }
        return answer;
    }
}
