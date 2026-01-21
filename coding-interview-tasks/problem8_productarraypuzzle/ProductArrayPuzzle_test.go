package problem8_productarraypuzzle

import (
	"fmt"
	"testing"

	"github.com/stretchr/testify/require"
)

func TestProductArrayPuzzle(t *testing.T) {
	tests := []struct {
		input  []int
		result []int
	}{
		{
			input:  []int{10, 3, 5, 6, 2},
			result: []int{180, 600, 360, 300, 900},
		},
		{
			input:  []int{1, 2, 3, 0},
			result: []int{0, 0, 0, 6},
		},
		{
			input:  []int{1, 2, 3, 0, 0},
			result: []int{0, 0, 0, 0, 0},
		},

		{
			input:  []int{12, 0},
			result: []int{0, 12},
		},
	}

	for test := range tests {
		t.Run("ProductArrayPuzzle "+fmt.Sprintf("%d", test), func(t *testing.T) {
			require.Equal(t, tests[test].result, ProductArrayPuzzle(tests[test].input))
		})
	}
}
