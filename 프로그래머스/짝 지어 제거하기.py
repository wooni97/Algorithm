def solution(s):
    answer = 0
    stack = []
    for word in s :
        
        if len(stack) == 0 :
            stack.append(word)
            
        else :
            if len(stack) >= 2 and stack[-1] == stack[-2] :
                
                stack.pop()
                stack.pop()
                stack.append(word)
                
            else : 
                stack.append(word)
               
    if len(stack) == 0 :
        return 1
    elif len(stack) == 2 and stack[-1] == stack[-2] :
        return 1
        
    return answer