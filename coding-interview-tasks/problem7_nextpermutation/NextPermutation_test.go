package problem7_nextpermutation

import (
	"testing"

	"github.com/stretchr/testify/require"
)

func TestNextPermutation(t *testing.T) {
	tests := []struct {
		input    []int
		expected []int
	}{
		{
			input:    []int{2, 4, 1, 7, 5, 0},
			expected: []int{2, 4, 5, 0, 1, 7},
		},
		{
			input:    []int{1, 2, 3},
			expected: []int{1, 3, 2},
		},
		{
			input:    []int{3, 2, 1},
			expected: []int{1, 2, 3},
		},
		{
			input:    []int{1, 1, 5},
			expected: []int{1, 5, 1},
		},
		{
			input:    []int{5},
			expected: []int{5},
		},
		{
			input:    []int{1, 2},
			expected: []int{2, 1},
		},
		{
			input:    []int{1, 1, 5},
			expected: []int{1, 5, 1},
		},
		{
			input:    []int{1, 2, 7, 4, 3, 1},
			expected: []int{1, 3, 1, 2, 4, 7},
		},
		{
			input:    []int{5, 4, 3, 2, 1},
			expected: []int{1, 2, 3, 4, 5},
		},
		{
			input:    []int{1},
			expected: []int{1},
		},
		{
			input:    []int{1, 2},
			expected: []int{2, 1},
		},
		{
			input:    []int{2, 1},
			expected: []int{1, 2},
		},
		{
			input:    []int{2, 2, 2},
			expected: []int{2, 2, 2},
		},
		{
			input:    []int{2, 3, 1, 3, 3},
			expected: []int{2, 3, 3, 1, 3},
		},
	}

	for test := range tests {
		t.Run("NextPermutation", func(t *testing.T) {
			require.Equal(t, tests[test].expected, NextPermutation(tests[test].input))
		})
	}
}
