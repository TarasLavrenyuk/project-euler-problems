package problem2_arithmeticsubsequencecounter

import (
	"fmt"
	"testing"

	"github.com/stretchr/testify/require"
)

func TestArithmeticSubsequenceCounter(t *testing.T) {
	tests := []struct {
		nums     []int
		expected int
	}{
		{nums: []int{2, 4, 6, 8, 10}, expected: 7},
		{nums: []int{7, 7, 7, 7, 7}, expected: 16},
		{nums: []int{3, 5, 6, 7, 9, 11}, expected: 9},
	}

	for test := range tests {
		t.Run("ArithmeticSubsequenceCounter "+fmt.Sprintf("%d", test), func(t *testing.T) {
			require.Equal(t, tests[test].expected, ArithmeticSubsequenceCounter(tests[test].nums))
		})
	}
}
