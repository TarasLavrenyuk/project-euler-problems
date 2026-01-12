package problem2_arithmeticsubsequencecounter

// ArithmeticSubsequenceCounter Count all arithmetic subsequences (https://leetcode.com/problems/arithmetic-slices-ii-subsequence/description/)
// Why: Advanced DP pattern.
// Approach: DP map at each index.
// Time: O(n²)
func ArithmeticSubsequenceCounter(nums []int) int {
	// create a map for each number in the nums and store there stepsSize->numberOfSteps values
	dp := make([]map[int]int, len(nums))
	for i := range dp {
		dp[i] = make(map[int]int)
	}
	result := 0

	for i := 0; i < len(nums); i++ {
		for j := 0; j < i; j++ {
			stepSize := nums[i] - nums[j]
			numberOfPreviousSteps := dp[j][stepSize]

			dp[i][stepSize] = dp[i][stepSize] + numberOfPreviousSteps + 1
			result += numberOfPreviousSteps
		}
	}
	return result
}
