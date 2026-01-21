package problem9_maximumsubarraysum

import (
	"fmt"
	"testing"

	"github.com/stretchr/testify/require"
)

func TestMaxSubArraySum(t *testing.T) {
	tests := []struct {
		input  []int
		result int
	}{
		{
			input:  []int{2, 3, -8, 7, -1, 2, 3},
			result: 11,
		},
		{
			input:  []int{-1, 0, 8, 4},
			result: 12,
		},
		{
			input:  []int{2, 3, -8, 7, -1, 2, 3, 500, -100},
			result: 511,
		},
		{
			input:  []int{2, 3, -8, 7, -1, 2, 3, 500, -100, 500},
			result: 911,
		},
		{
			input:  []int{-2, -4},
			result: -2,
		},
		{
			input:  []int{-2, -4, -1},
			result: -1,
		},
		{
			input:  []int{5, 4, 1, 7, 8},
			result: 25,
		},
	}

	for test := range tests {
		t.Run("TestMaxSubArraySum "+fmt.Sprintf("%d", test), func(t *testing.T) {
			require.Equal(t, tests[test].result, MaxSubArraySum(tests[test].input))
		})
	}
}
