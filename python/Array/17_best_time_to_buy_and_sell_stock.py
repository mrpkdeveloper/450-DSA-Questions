def maxProfit(self, prices):
    """
    :type prices: List[int]
    :rtype: int
    """
    l, r = 0, 1  # left=buy, right=sell
    maxP = 0
    
    while r < len(prices):
        if prices[l] < prices[r]:
            profit = prices[r] - prices[l]
            maxP = max(maxP, profit)
        else:
            l = r
        r += 1
    return maxP