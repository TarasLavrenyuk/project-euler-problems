package problem8_productarraypuzzle

// ProductArrayPuzzle Given an array, input[] construct a product array, res[] where each element in res[i] is the
// product of all elements in input[] except input[i]. Return this resultant array, res[].
// Note: Each element is res[] lies inside the 32-bit integer range.
func ProductArrayPuzzle(input []int) []int {
	res := make([]int, len(input))
	total := 1
	numOfZeros := 0

	for _, num := range input {
		if num == 0 {
			if numOfZeros < 1 {
				numOfZeros++
				continue
			} else {
				total = 0
				break
			}
		} else {
			total *= num
		}
	}

	for i, num := range input {
		if num != 0 {
			if numOfZeros > 0 {
				res[i] = 0
				continue
			} else {
				res[i] = total / num
			}
		} else {
			res[i] = total
		}
	}

	return res
}
