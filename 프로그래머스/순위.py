import collections
def solution(n, results):
    answer = 0
    
    win_set = collections.defaultdict(set)
    loose_set = collections.defaultdict(set)
   
    for winner, looser in results :
        win_set[winner].add(looser)
        loose_set[looser].add(winner)
    
    
    #print(win_set)
    #print(loose_set)
    
    for i in range(1, n+1) :
        for loosers in win_set[i] :
            win_set[i].update(win_set[loosers])
        for winners in loose_set[i] :
            loose_set[i].update(loose_set[winners])
    
    for i in rnage(1, n+1) :
        if len(win_set[i]) + len(loose_set[i]) == n - 1 :
            answer += 1
    

    
    
    
            
    
    return answer