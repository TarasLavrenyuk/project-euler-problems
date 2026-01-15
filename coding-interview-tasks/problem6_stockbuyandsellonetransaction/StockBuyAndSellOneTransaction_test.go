package problem6_stockbuyandsellonetransaction

import (
	"testing"

	"github.com/stretchr/testify/require"
)

func TestStockBuyAndSellOneTransaction(t *testing.T) {
	tests := []struct {
		prices         []int
		expectedProfit int
	}{
		{
			prices:         []int{7, 10, 1, 3, 6, 9, 2},
			expectedProfit: 8,
		},
		{
			prices:         []int{7, 10, 1, 2},
			expectedProfit: 3,
		},
		{
			prices:         []int{7, 6, 4, 3, 1},
			expectedProfit: 0,
		},
		{
			prices:         []int{1, 3, 6, 9, 11},
			expectedProfit: 10,
		},
	}
	for test := range tests {
		t.Run("StockBuyAndSellOneTransaction", func(t *testing.T) {
			require.Equal(t, tests[test].expectedProfit, StockBuyAndSellOneTransaction(tests[test].prices))
		})
	}
}
