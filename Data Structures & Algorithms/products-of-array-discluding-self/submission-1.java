class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] results = new int[nums.length];

        results[0] = 1;

        // think of the result as 
        // all elements product on the left 
        // times 
        // all elements product on the right

        // build the left side products respect to current idx
        for (int i = 1; i < nums.length; i++) {
            results[i] = results[i - 1] * nums[i - 1];
        }

        int rightSideProduct = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            results[i] = results[i] * rightSideProduct;
            rightSideProduct = rightSideProduct * nums[i];
        }

        return results;
    }
}  
