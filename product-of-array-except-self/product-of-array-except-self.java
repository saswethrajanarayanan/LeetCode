class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] products = new int[nums.length];
        products[0] = 1;
        for(int i = 1; i < products.length; ++i) {
            products[i] = nums[i - 1] * products[i - 1];
        }
        int rightProduct = 1;
        for(int i = products.length - 1; i >= 0; --i) {
            products[i] = products[i] * rightProduct;
            rightProduct *= nums[i];
        }
        return products;
    }
}