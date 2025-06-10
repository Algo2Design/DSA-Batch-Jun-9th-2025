int[] arr = {10, 20, 30, 40};

int n = arr.length;

arr[0] --> 10;
arr[1] --> 20
arr[2] --> 30;
arr[3] --> 40

iteraton: Time Complexity : O(n)

for (int index = 0; index < n; index++) {
	println(arr[index])
	
}


does num 40 exist? Time Complexity : O(n)

for (int index = 0; index < n; index++) {
	if (arr[index] == 40) {
		return true;
	}
}
return false;

*****************
Time complexity for index based operations in an array:

access --> O(1)
update --> O(1)
delete --> O(n) As the all the elements should be move an index before



When to go for Array: 

Requirement: 
	-> Simple interation of complete elements (Becomes faster as the memory locations are continuous)
	-> Access or update based on index  

Not recomended for:
	Delete operation :O(n) (Because all the elements should be moved an index before)

**************************

Leet Code : 485. Max Consecutive Ones

https://leetcode.com/problems/max-consecutive-ones/

Input: nums = [1,1,0,1,1,1]
Output: 3


Algorithm :

-> Maintain two variables 
		maxCounter --> tracks global continues one's
		currentCounter --> tracks current countinues one's

--> Scan through complete Array 
		if value is 1 then increment currentCounter
		if value is 0 
			--> then compare maxCounter & currentCounter then update maxCounter 
			if required
			--> reset currentCounter to 0 for scan next seq elements:


--> return Math.max(currentCounter, maxCounter)


Time Complexity : O(n)
Space Complexity : O(1)




























