package problem3_burstballoons

// BurstBalloons Maximize coins by popping balloons (https://leetcode.com/problems/burst-balloons/description/)
// Why: Interval DP.
// Approach: DP[i][j] = max coins in interval.
// Time: O(n³)
func BurstBalloons(nums []int) int {
	n := len(nums)
	arr := make([]int, n+2)
	arr[0] = 1
	arr[n+1] = 1
	copy(arr[1:], nums)
	dp := make([][]int, n+2)
	for i := range dp {
		dp[i] = make([]int, n+2)
	}

	for i := n - 1; i >= 0; i-- {

		for j := i + 2; j <= n+1; j++ {
			for k := i + 1; k < j; k++ {
				dp[i][j] = max(dp[i][j], dp[i][k]+dp[k][j]+arr[i]*arr[k]*arr[j])
			}
		}
	}

	return dp[0][n+1]
}
