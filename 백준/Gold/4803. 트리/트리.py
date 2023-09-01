import sys
from collections import defaultdict
def check(j):
	ret = True
	queue = [j]
	while queue:
		a = queue.pop()
		if visit[a] == 1:  # 사이클
			ret = False
		visit[a] = 1
		for k in dic[a]:
			if k == a:  
				ret =  False
			if visit[k] == 0:
				queue.append(k)
	return ret
    
cnt = 0
while 1:
	n,m = map(int,input().split())
	if n == 0 and m == 0:
		break
	ans = 0
	cnt += 1
	dic = defaultdict(list)
	visit = [0]*(n+1)
	for i in range(m):
		a,b = map(int,sys.stdin.readline().split())
		dic[a].append(b)
		dic[b].append(a)
	for j in range(1,n+1):
			if visit[j] == 1:  # 이미 방문한 적이 있는 경우
				continue
			if check(j):  # 트리인 경우
				ans += 1
	
	if ans > 1:
		print("Case %d: A forest of %d trees." % (cnt,ans))
	elif ans == 1:
		print("Case %d: There is one tree." %cnt)
	else:
		print("Case %d: No trees." %cnt)