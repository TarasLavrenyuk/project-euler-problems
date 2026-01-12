package problem1_wordbreak

import "strings"

// WordBreak Determine if a string can be segmented into dictionary words (https://leetcode.com/problems/word-break/description/)
// Why: Tests recursive + DP decomposition.
// Approach: DP with substrings and memoization.
// Time: O(n²)
func WordBreak(str string, wordDict []string) bool {
	if len(str) == 0 {
		return true
	}
	for _, word := range wordDict {
		if strings.Contains(str, word) {
			return WordBreak(strings.ReplaceAll(str, word, ""), wordDict)
		}
	}
	return false
}
