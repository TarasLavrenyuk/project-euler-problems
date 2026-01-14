package problem5_2sum

// TwoSum Given an array arr[] and an integer target. You have to return the pair of elements which sum up to target.
// You cannot use the same element twice. Note: Inputs are given such that only one valid answer exists.
func TwoSum(nums []int, target int) []int {
	// Input: arr[] = [2, 9, 10, 4, 15], target = 12
	// Output: [2, 10]
	// Explanation: Pair with sum equal to 12 is (2, 10).
	difference := make(map[int]int) // difference[target - num] = index

	for i, num := range nums {
		missingNumber := target - num
		if _, ok := difference[missingNumber]; ok {
			return []int{missingNumber, num}
		}
		difference[num] = i
	}

	return []int{}
}
