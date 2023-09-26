
N = int(input())

level = []
for i in range(N) :
    score = int(input())
    level.append(score)

answer = 0
for i in range(N-2 , -1, -1) :
    if level[i+1] <= level[i] :
        answer += level[i] - level[i+1] + 1
        level[i] -= level[i] - level[i+1] + 1
print(answer)