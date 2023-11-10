def solution(targets):
    answer = 1
    
    targets.sort(key=lambda x:(x[1],x[0]))
    #print(targets)
    e = targets[0][1]
    for i in range(1, len(targets)) :
        start, end = targets[i]
        
        if start < e :
            continue
        else :
            answer += 1
            e = end
    return answer