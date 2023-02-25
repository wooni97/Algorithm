def solution(money):
    answer = 0
    
    DP1 = [0] * len(money)
    DP2 = [0] * len(money)
    
    DP1[0] = money[0]
    DP1[1] = max(money[1], money[0])
    
    for i in range(2, len(money) - 1) :
        DP1[i] = max(DP1[i-1], money[i] + DP1[i-2])
    
    DP2[1] = money[1]
    
    for i in range(2, len(money)) :
        DP2[i] = max(DP2[i-1], money[i] + DP2[i-2])
        
    answer = max(DP1[-2], DP2[-1])
    return answer