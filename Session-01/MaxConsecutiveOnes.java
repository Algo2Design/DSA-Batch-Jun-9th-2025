class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int currentCounter = 0;
        int maxCounter = 0;

        for (int index = 0; index < nums.length; index++) {
            if (nums[index] == 1) {
                currentCounter ++;
            }else {
                maxCounter = Math.max(maxCounter, currentCounter);
                currentCounter = 0;
            }
        }
        
        return Math.max(maxCounter, currentCounter);
    }
}

public class MaxConsecutiveOnes {
	public static void main(String[] args) {
		Solution  s = new Solution();
		int[] nums = {1,1,0,1,1,1};
		int count = s.findMaxConsecutiveOnes(nums);
		System.out.println( "MaxConsecutiveOnes = "+count);
	}
}