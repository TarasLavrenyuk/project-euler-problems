package problem4_trappingrainwater

import (
	"fmt"
	"testing"

	"github.com/stretchr/testify/require"
)

func TestTrappingRainWater(t *testing.T) {
	tests := []struct {
		heights  []int
		expected int
	}{
		{
			heights:  []int{2, 1, 5, 3, 1, 0, 4},
			expected: 9,
		},
		{
			heights:  []int{3, 0, 1, 0, 4, 0, 2},
			expected: 10,
		},
		{
			heights:  []int{3, 0, 2, 0, 4},
			expected: 7,
		},
		{
			heights:  []int{1, 2, 3, 4, 5},
			expected: 0,
		},
	}

	for test := range tests {
		t.Run("TrappingRainWater "+fmt.Sprintf("%d", test), func(t *testing.T) {
			require.Equal(t, tests[test].expected, TrappingRainWater(tests[test].heights))
		})
	}
}
