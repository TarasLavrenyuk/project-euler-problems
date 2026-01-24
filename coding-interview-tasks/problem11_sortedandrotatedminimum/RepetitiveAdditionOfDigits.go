package problem9_maximumsubarraysum

import (
	"strconv"
)

// RepetitiveAdditionOfDigits You are given a positive integer n, you need to add all the digits of n and create a new
// number. Perform this operation until the resultant number has only one digit in it. Return the final number obtained
// after performing the given operation.
func RepetitiveAdditionOfDigits(num int) int {
	if num < 10 {
		return num
	}
	stringedNum := strconv.Itoa(num)
	result := 0
	for _, r := range stringedNum {
		result += int(r - '0')
	}
	return RepetitiveAdditionOfDigits(result)
}
