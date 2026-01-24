package problem9_maximumsubarraysum

import (
	"fmt"
	"testing"

	"github.com/stretchr/testify/require"
)

func TestRepetitiveAdditionOfDigits(t *testing.T) {
	tests := []struct {
		num    int
		result int
	}{
		{
			num:    1234,
			result: 1,
		},
		{
			num:    5674,
			result: 4,
		},
		{
			num:    9,
			result: 9,
		},
	}

	for test := range tests {
		t.Run("TestSortedAndRotatedMinimum "+fmt.Sprintf("%d", test), func(t *testing.T) {
			require.Equal(t, tests[test].result, RepetitiveAdditionOfDigits(tests[test].num))
		})
	}
}
