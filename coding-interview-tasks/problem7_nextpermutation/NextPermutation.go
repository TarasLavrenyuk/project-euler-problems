package problem7_nextpermutation

// NextPermutation Given an array of integers arr[] representing a permutation, implement the next permutation that
// rearranges the numbers into the lexicographically next greater permutation. If no such permutation exists, rearrange
// the numbers into the lowest possible order (i.e., sorted in ascending order).
// Note: A permutation of an array of integers refers to a specific arrangement of its elements in a sequence or linear
// order.
func NextPermutation(nums []int) []int {
	reverseFrom := 0
	for i := len(nums) - 1; i >= 2; i-- {
		// search for the first decreasing number
		if nums[i-1] < nums[i] {
			// find the next larger number from the right
			nextLargerIndex := nextLarger(nums, nums[i-1], i)

			// swap nums[i-1] with the next larger number from the right
			nums[i-1], nums[nextLargerIndex] = nums[nextLargerIndex], nums[i-1]

			reverseFrom = i
			break
		}
	}

	reverse(nums, reverseFrom)
	return nums
}

// nums is sorted descending
func nextLarger(nums []int, largerThen, fromIndex int) int {
	for i := fromIndex + 1; i < len(nums)-1; i++ {
		if i == len(nums)-1 || largerThen > nums[i+1] {
			return i
		}
	}
	return len(nums) - 1
}

func reverse(nums []int, from int) {
	end := len(nums) - 1
	for from < end {
		nums[from], nums[end] = nums[end], nums[from]
		from++
		end--
	}
}
