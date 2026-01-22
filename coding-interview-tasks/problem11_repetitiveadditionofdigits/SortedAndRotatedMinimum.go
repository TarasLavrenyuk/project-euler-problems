package problem9_maximumsubarraysum

// SortedAndRotatedMinimum A sorted array of distinct elements arr[] is rotated at some unknown point, the task is to
// find the minimum element in it.
func SortedAndRotatedMinimum(nums []int) int {
	left := 0
	right := len(nums) - 1

	for left < right {
		if nums[left] < nums[right] {
			return nums[left]
		}

		mid := (left + right) / 2
		if nums[mid] > nums[right] {
			left = mid + 1
		} else {
			right = mid
		}
	}

	return nums[left]
}
