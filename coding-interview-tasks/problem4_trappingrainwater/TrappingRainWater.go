package problem4_trappingrainwater

// TrappingRainWater Given an array arr[] of size n consisting of non-negative integers, where each element represents
// the height of a bar in an elevation map and the width of each bar is 1, determine the total amount of water that can
// be trapped between the bars after it rains.
func TrappingRainWater(heights []int) int {
	leftPointer := 1
	rightPointer := len(heights) - 2

	leftMax := heights[leftPointer-1]
	rightMax := heights[rightPointer+1]

	result := 0

	for leftPointer <= rightPointer {
		if leftMax >= rightMax {
			result += max(0, rightMax-heights[rightPointer])
			rightMax = max(rightMax, heights[rightPointer])

			rightPointer--
		} else {
			result += max(0, leftMax-heights[leftPointer])
			leftMax = max(leftMax, heights[leftPointer])

			leftPointer++
		}
	}

	return result
}
