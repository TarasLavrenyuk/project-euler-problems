package problem6_stockbuyandsellonetransaction

// StockBuyAndSellOneTransaction Given an array prices[] of length n, representing the prices of the stocks on different
// days. The task is to find the maximum profit possible by buying and selling the stocks on different days when at most
// one transaction is allowed. Here one transaction means 1 buy + 1 Sell. If it is not possible to make a profit then
// return 0.
// Note: Stock must be bought before being sold.
func StockBuyAndSellOneTransaction(prices []int) int {
	potentialBuyDay := 0
	bestProfit := prices[0] - prices[potentialBuyDay]

	for day, price := range prices {
		if price < prices[potentialBuyDay] {
			potentialBuyDay = day
		}
		if price-prices[potentialBuyDay] > bestProfit {
			bestProfit = price - prices[potentialBuyDay]
		}
	}

	return max(bestProfit, 0)
}
