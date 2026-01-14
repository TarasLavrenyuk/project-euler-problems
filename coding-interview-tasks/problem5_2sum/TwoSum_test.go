package problem5_2sum

import (
	"testing"

	"github.com/stretchr/testify/require"
)

func TestTwoSum(t *testing.T) {
	tests := []struct {
		nums     []int
		target   int
		expected []int
	}{
		{
			nums:     []int{2, 9, 10, 4, 15},
			target:   12,
			expected: []int{2, 10},
		},
		{
			nums:     []int{3, 2, 4},
			target:   8,
			expected: []int{},
		},
		{
			nums:     []int{1, 4, 5, 6, 1},
			target:   2,
			expected: []int{1, 1},
		},
	}
	for test := range tests {
		t.Run("TwoSum", func(t *testing.T) {
			require.Equal(t, tests[test].expected, TwoSum(tests[test].nums, tests[test].target))
		})
	}
}
