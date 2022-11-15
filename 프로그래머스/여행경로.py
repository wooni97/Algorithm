def solution(tickets):
    answer = []
    
    hashdict = {}
    for t in tickets :
        if t[0] in hashdict :
            hashdict[t[0]].append(t[1])
        else :
            hashdict[t[0]] = [t[1]]
    
    for key in hashdict.keys():
        hashdict[key].sort(reverse=True)
     
    stack = ["ICN"]
    
    while stack :
        top = stack.pop()
        
        if top not in hashdict or not hashdict[top] :
            answer.append(top)
        else :
            stack.append(top)
            stack.append(hashdict[top].pop())
            
    
            
        
    return answer[::-1]

