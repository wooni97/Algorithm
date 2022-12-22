from collections import deque
def solution(priorities, location):
    answer = 0
    
    d = deque([(i,v) for v,i in enumerate(priorities)])
    print(d)
    while len(d):
        num = d.popleft()
        if d and max(d)[0] > num[0]:
            d.append(num)
        else:
            answer +=1
            if(location == num[1]):
                break
    return answer