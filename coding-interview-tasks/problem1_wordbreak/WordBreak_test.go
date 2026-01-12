package problem1_wordbreak

import (
	"testing"

	"github.com/stretchr/testify/require"
)

func TestWordBreak(t *testing.T) {
	tests := []struct {
		s        string
		wordDict []string
		expected bool
	}{
		{s: "leetcode", wordDict: []string{"leet", "code"}, expected: true},
		{s: "applepenapple", wordDict: []string{"apple", "pen"}, expected: true},
		{s: "catsandog", wordDict: []string{"cats", "dog", "sand", "and", "cat"}, expected: false},
	}

	for test := range tests {
		t.Run(tests[test].s, func(t *testing.T) {
			require.Equal(t, tests[test].expected, WordBreak(tests[test].s, tests[test].wordDict))
		})
	}
}
