

N, M = map(int, input().split())
ans = []

def back() :
    if len(ans) == M :
        print(' '.join(map(str, ans)))
        return
    else :
      for i in range(1,N+1) :

            ans.append(i)
            back()
            ans.pop()
back()
