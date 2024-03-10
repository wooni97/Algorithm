import sys

def solution(s):
    answer = sys.maxsize
    
    n = len(s)
    
    if n == 1:
        return 1
    
    for i in range(1, n // 2 + 1):
        unit = ""
        count = 0
        
        result = []
        
        for j in range(0, n // i + 1):
            
            if i * j + i > n :
                sliced = s[i * j :]
                result += sliced
                continue
            
            sliced = s[i * j : i * j + i]
            
            if unit == "":
                unit = sliced
                count = 1
                continue
        
            if unit == sliced:
                count += 1
                continue
            
            if count == 1:
                result += unit
            else:
                result += str(count) 
                result += unit
            
            unit = sliced
            count = 1
        
        if count == 1:
            result += unit
        else:
            result += str(count) 
            result += unit
        
        answer = min(answer, len(result))
    return answer