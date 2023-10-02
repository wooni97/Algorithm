N, M = map(int, input().split())

numbers = list(map(int, input().split()))
numbers.sort()
ans = []
def back() :
    if len(ans) == M :
        print(' '.join(map(str, ans)))
        return
    else :
        for number in numbers :
            if number not in ans :
                ans.append(number)
                back()
                ans.pop()
back()