package problem3_burstballoons

import (
	"fmt"
	"testing"

	"github.com/stretchr/testify/require"
)

func TestBurstBalloons(t *testing.T) {
	tests := []struct {
		input    []int
		expected int
	}{
		{
			input:    []int{3, 1, 5, 8},
			expected: 167,
		},
		{
			input:    []int{8},
			expected: 8,
		},
		{
			input:    []int{1, 5, 8},
			expected: 56,
		},
		{
			input:    []int{8, 2, 6, 8},
			expected: 552,
		},
		{
			input:    []int{2, 4, 3, 5, 1},
			expected: 120,
		},
	}
	for test := range tests {
		t.Run("BurstBalloons "+fmt.Sprintf("%d", test), func(t *testing.T) {
			require.Equal(t, tests[test].expected, BurstBalloons(tests[test].input))
		})
	}

}
