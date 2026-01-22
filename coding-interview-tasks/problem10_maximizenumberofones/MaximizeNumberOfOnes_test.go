package problem9_maximumsubarraysum

import (
	"fmt"
	"testing"

	"github.com/stretchr/testify/require"
)

func TestMaximizeNumberOfOnes(t *testing.T) {
	tests := []struct {
		input  []int
		k      int
		result int
	}{
		{
			input:  []int{1, 0, 1},
			k:      1,
			result: 3,
		},
		{
			input:  []int{1, 0, 0, 1, 0, 1, 0, 1},
			k:      2,
			result: 5,
		},
		{
			input:  []int{1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1},
			k:      2,
			result: 4,
		},
		{
			input:  []int{1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
			k:      2,
			result: 4,
		},
		{
			input:  []int{0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1},
			k:      2,
			result: 5,
		},
		{
			input:  []int{1, 1},
			k:      2,
			result: 2,
		},
		{
			input:  []int{0, 0, 0, 0, 0, 0},
			k:      2,
			result: 2,
		},
		{
			input:  []int{0, 0, 0, 0, 0, 0},
			k:      0,
			result: 0,
		},
	}

	for test := range tests {
		t.Run("TestMaximizeNumberOfOnes "+fmt.Sprintf("%d", test), func(t *testing.T) {
			require.Equal(t, tests[test].result, MaximizeNumberOfOnes(tests[test].input, tests[test].k))
		})
	}
}
