LeetCode 487. Max Consecutive Ones II

Solution-01: 

BruteForce:

Approach: Brute-force with Nested Loop
--> We use two pointers, start and end, to explore every possible subarray.
--> For each subarray, we count how many 0s it contains.
--> If we find more than 1 zero, we stop checking that subarray.
--> If it's 0 or 1 zero, we update the maxFreqCount.

Algorithm:

--> Initialize maxFreqCount = 0

--> Loop through each index start of the array

--> Initialize noOfZeros = 0

--> Loop from end = start to end of array

--> If nums[end] == 0, increase noOfZeros

--> If noOfZeros > 1, break

--> Otherwise, update maxFreqCount as max(maxFreqCount, end - start + 1)

--> Return maxFreqCount



Time Complexity: O(n^2)
Space Complexity: O(1)

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        int maxFreqCount = 0;

        for (int start = 0; start < nums.length; start++) {

                int noOfZeros = 0;
                for (int end = start; end < nums.length; end++) {
                    if (nums[end] == 0) {
                        noOfZeros++;
                    }

                    if(noOfZeros > 1) {
                        break;
                    }

                    maxFreqCount = Math.max(maxFreqCount, end - start + 1);
                }
        }
        return maxFreqCount;
    }
}

Solution-02:

Sliding Window:
--> We maintain a window [left, right] where:
--> The window contains at most one 0
--> If it has more than one 0, we shrink it from the left

Step-by-Step Algorithm:

Start with left = 0, right = 0

Initialize noOfZeros = 0, maxLen = 0

Loop while right < nums.length:

If nums[right] == 0, increase noOfZeros

If noOfZeros > 1, move left forward and decrease noOfZeros when needed

At each step, calculate currentLen = right - left + 1

Update maxLen = max(maxLen, currentLen)

Move right forward



Time Complexity: O(n)
Space Complexity: O(1)

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0;
        int right = 0;
        int maxLen = 0;
        int noOfZeros = 0;

        while (right < nums.length) {

            if (nums[right] == 0) {
                noOfZeros++;
            }

            // Window is invalid
            while (noOfZeros > 1) {
                if (nums[left] == 0) {
                    noOfZeros--;
                }
                left++;
            }

            int currentLen = right - left + 1;
            maxLen = Math.max(maxLen, currentLen);
            right++;
        }

        return maxLen;
    }
}

******************
1004. Max Consecutive Ones III

Same as LeetCode 487. Max Consecutive Ones II
        --> Instead on at most 1 flip, we solve it for at most k flips

Time Complexity : O(n)
Space Complexity: O(1)

class Solution {
    public int longestOnes(int[] nums, int k) {
         int left = 0;
        int right = 0;
        int maxLen = 0;
        int noOfZeros = 0;

        while (right < nums.length) {

            if (nums[right] == 0) {
                noOfZeros++;
            }

            // when wndow is invalid  
            while (noOfZeros > k) {
                if (nums[left] == 0) {
                    noOfZeros--;
                }
                left++;
            }

            int currentLen = right - left + 1;
            maxLen = Math.max(maxLen, currentLen);
            right++;
        }

        return maxLen;
    }
}

******************

LeetCode 941. Valid Mountain Array



A valid mountain:

* Strictly **increases** to a peak
* Then **strictly decreases**
* Must have **at least 3 elements**
* The peak cannot be at the start or end

---

 ✅ Step-by-Step Intuition:

int index = 0;
int n = nums.length;


### 1. **Walk up (strictly increasing)**

while (index < n-1 && nums[index] < nums[index+1]) {
    index++;
}


### 2. **Peak check:**

If the peak is at the beginning or the end, it’s invalid.

if (index == 0 || index == n-1) {
    return false;
}


### 3. **Walk down (strictly decreasing)**


while (index < n-1 && nums[index] > nums[index+1]) {
    index++;
}


### 4. **Final check:**

We should’ve reached the end of array — that means valid mountain.

return index == n-1;


Time Complexity : O(n)
Space Complexity: O(1)

class Solution {
    public boolean validMountainArray(int[] nums) {
        
        int index = 0;
        int n = nums.length;

        // Walk -- up
        while (index < n-1 && nums[index] < nums[index+1]) {
            index++;
        }

        //Check Balance
        if (index == 0 || index == n-1) {
            return false;
        }

        // Walk -- down
        while (index < n-1 && nums[index] > nums[index+1]) {
            index++;
        }

        return index == n-1;
    }
}