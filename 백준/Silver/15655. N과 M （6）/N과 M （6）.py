N, M = map(int, input().split())

numbers = list(map(int, input().split()))
numbers.sort()
ans = []
def back(k) :
    if len(ans) == M :
        print(' '.join(map(str, ans)))
        return
    else :
        for i in range(k,len(numbers)) :
            if numbers[i] not in ans :
                ans.append(numbers[i])
                back(i+1)
                ans.pop()
back(0)