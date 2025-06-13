
LeetCode : 209. Minimum Size Subarray Sum

Solution 1:

Brute Algorithm: 
	Greedy Approch:
	--> We take var minLength, currentLength
	--> Generate All the sub Arrays 
	--> FindOut sum of each subArray 
			If currentSum >= target and currentSubArray Len is less than minLength 
			then update minLength with currentSubArray Len


Time Complexity : O(n^3)
Space Complexity: O(1)

finally return minLength:

		int[] nums = {2, 4, 3, 8};

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int n = nums.length;
		int minLength = Integer.MAX_VALUE;

		for (int start = 0; start < n; start++) {

			for (int end = start; end < n; end++) {

					int currentSum = getSum(nums, start, end);
					if (currentSum >= target) {
							int currentLen = end - start + 1;
							minLength = Math.min(minLength, currentLen);
					}

			}
		}

		return minLength == Integer.MAX_VALUE ? 0 : minLength;

    }

    private int getSum(int[] nums, int start, int end) {
	int sum = 0;
	 while (start <= end) {
	 	sum += nums[start];
	 	start++;
	 }
	 return sum;
}

}

*************************************************

Solution 2:

Instead of recalculating the sum of every subarray from scratch, maintain a currentSum and build it incrementally for each subarray starting at index i.

Time Complexity : O(n^2)
Space Complexity: O(1)

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int n = nums.length;
		int minLength = Integer.MAX_VALUE;

		for (int start = 0; start < n; start++) {
            int currentSum = 0;
			for (int end = start; end < n; end++) {
                    currentSum += nums[end];
					if (currentSum >= target) {
							int currentLen = end - start + 1;
							minLength = Math.min(minLength, currentLen);
					}

			}
		}

		return minLength == Integer.MAX_VALUE ? 0 : minLength;

    }

   

}
*************************************************

Solution 3:

✅ Algorithm: Minimum Size Subarray Sum (Sliding Window)

---

1. Initialize a variable `minLength` to ∞ (this will store the smallest window found).

2. Initialize two pointers:

    `left` to 0 (start of the window)
    `right` to 0 (end of the window)

3. Initialize a variable `windowSum` to 0 to keep track of the sum of elements between `left` and `right`.

4. Start iterating over the array using the `right` pointer:

    At each step, add the current number `nums[right]` to `windowSum`.

5. While `windowSum` is greater than or equal to `target`:

    Calculate the current window size → `currentLength = right - left + 1`.
    Update `minLength` if `currentLength` is smaller.
    Shrink the window from the left by subtracting `nums[left]` from `windowSum` and incrementing `left`.

6. Repeat steps 4–5 until `right` reaches the end of the array.

7. After the loop ends:

    If `minLength` is still ∞, it means no valid window was found → return `0`.
    Otherwise, return `minLength`.

---
Key Concept:

 Expand the window from the right to accumulate enough sum.
 
 Shrink the window from the left to minimize its length without losing the valid condition (`sum ≥ target`).



Time Complexity : O(n)
Space Complexity : O(1)

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int windowSum = 0;

        int left = 0;
        int right = 0;

        while (right < nums.length) {

            windowSum += nums[right];

            while (windowSum >= target) {
                int currentWindowLen = right - left + 1;
                minLen = Math.min(minLen, currentWindowLen);
                windowSum -= nums[left];
                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}

