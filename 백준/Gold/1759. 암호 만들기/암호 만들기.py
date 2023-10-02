l, c = map(int, input().split())
alphabet = sorted(list(map(str, input().split())))
ans = []


def back(start, cnt):
    if len(ans) == l :
        if cnt >=1 and l - cnt >= 2 :
            print(''.join(map(str, ans)))
        cnt = 0
        return
    else :
        for i in range(start, c) :
            if alphabet[i] not in ans :
                if alphabet[i] in ['a', 'e', 'i', 'o', 'u'] :
                    cnt += 1
                ans.append(alphabet[i])
                back(i+1, cnt)
                if ans[-1] in ['a', 'e', 'i', 'o', 'u'] :
                    cnt -= 1
                ans.pop()
cnt = 0
back(0, cnt)