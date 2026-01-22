package problem9_maximumsubarraysum

// MaximizeNumberOfOnes Given a binary array nums[] containing only 0s and 1s and an integer k, you are allowed to flip
// at most k 0s to 1s. Find the maximum number of consecutive 1's that can be obtained in the array after performing the
// operation at most k times.
func MaximizeNumberOfOnes(nums []int, k int) int {
	bestResult := 0
	currentResult := 0
	flipsLeft := k
	tail := 0
	head := 0

	for head < len(nums) {
		if nums[head] == 1 {
			currentResult++
			head++
		} else {
			if flipsLeft > 0 {
				// happy path
				flipsLeft--
				currentResult++
				head++
			} else {
				// need to move tail forward
				if nums[tail] == 0 {
					flipsLeft++
				}
				currentResult--
				tail++
			}
		}

		bestResult = max(bestResult, currentResult)
	}

	return bestResult
}
