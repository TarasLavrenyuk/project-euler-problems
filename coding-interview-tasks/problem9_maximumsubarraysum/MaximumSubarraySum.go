package problem9_maximumsubarraysum

// MaxSubArraySum You are given an integer array nums[]. You need to find the maximum sum of a subarray (containing at
// least one element) in the array nums[].
// Note: A subarray is a continuous part of an array.
func MaxSubArraySum(nums []int) int {
	bestResult := nums[0]
	currentSum := nums[0]
	singleBiggest := nums[0]
	head := 1

	for head < len(nums) {
		current := nums[head]

		if current >= 0 {
			currentSum = current + max(0, currentSum)
			if currentSum > bestResult {
				bestResult = currentSum
			}
		} else {
			if current > currentSum {
				currentSum = current
				if currentSum > bestResult {
					bestResult = currentSum
				}
			} else if currentSum+current < 0 {
				currentSum = 0
			} else {
				currentSum += current
			}
		}

		singleBiggest = max(singleBiggest, current)

		head++
	}

	return max(bestResult, singleBiggest)
}
