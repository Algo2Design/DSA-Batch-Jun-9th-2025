
SubArray : {3, 2, 10}

--> SunArray Maintains Order 
--> SubArray is Contiguous 

subArrays starts with: index --> 0

indexes: 0 --> {3}
indexes: 0, 1 --> {3, 2}
indexes: 0, 1, 2 --> {3, 2, 10}

subArrays starts with: index --> 1

indexes: 1 --> {2}
indexes: 1, 2 --> {2, 10}

subArrays starts with: index --> 0

indexes: 2 --> {10}


--> If there are n elements then there will n(n+1)/2 subArrays  --> 3(3+1)/2 = 6

Algorithm :

Print all possible subArrays: 

int[] nums = {3, 2, 10};
for (int start = 0; start < n; start++) {
		for (int end = start ; end < n; end++) {
			print(nums, start, end); 
		}
	}


public void print(int[] nums, int start, int end) {
	while (start <= end) {
		System.out.print(nums[start]+"  ");
		start++;
	}
	System.out.println();
}


nums = [3, 2, 10]

(start=0, end=0) → [3]  
(start=0, end=1) → [3, 2]  
(start=0, end=2) → [3, 2, 10]  
(start=1, end=1) → [2]  
(start=1, end=2) → [2, 10]  
(start=2, end=2) → [10]  


Time Complexity:n * n * n --> O(n^3)

Space Complexity: O(1)


***************

LeetCode: 53. Maximum Subarray


Solution:1 --> 
BruteForce : 
Time Complexity O(n^3)
Space Complexity: O(1)

class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int n = nums.length;
        for (int start = 0; start < n; start++) {
            for (int end = start ; end < n; end++) {
                int currentSum = getSum(nums, start, end);
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
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

Solution:2 

Intuition:
You're checking all subarrays starting at every index, but instead of creating the subarray and summing each time, you reuse the previous sum to improve from O(n³) to O(n²)

BruteForce : 
Time Complexity O(n^2)
Space Complexity: O(1)


class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int n = nums.length;
        for (int start = 0; start < n; start++) {
            int currentSum = 0;
            for (int end = start ; end < n; end++) {
                currentSum += nums[end];
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }

        /*
                {4, -1, 3} 
                start:0 , end 0 --> 2
                    4 = 4, 4-1 = 3, 3+3 = 6 --> maxSum:6 

                start: 1 end 1 --> 2
                    -1, -1+3 

                 start: 2 end 2 --> 2
                    3 
        */
}



Solution:3 

Kadane's Algorithm':

Intuition:
--> We are greedily accumulating positive values
--> The moment total goes negative, we drop it and start fresh
--> This ensures we always keep maximum possible subarray sum



Time Complexity O(n)
Space Complexity: O(1)

Algorithm:
--> Initialize maxSum to Integer.MIN_VALUE

--> Initialize currentSum to 0

--> Loop through each element in the array:

--> Add current number to currentSum

--> If currentSum becomes negative → reset to 0

--> Update maxSum if currentSum is greater than maxSum

--> After loop ends, return maxSum




class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int index = 0; index < nums.length; index++) {
            currentSum += nums[index];
            maxSum = Math.max(maxSum, currentSum);

            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return maxSum;
    }
}



