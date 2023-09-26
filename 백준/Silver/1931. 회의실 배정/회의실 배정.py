

N = int(input())

answer = 1
meetings = []
for i in range(N) :
    start, end = map(int, input().split())
    meetings.append((end, start))

meetings.sort()

end_time = meetings[0][0]


for i in range(1,N) :
    if meetings[i][1] >= end_time :
       
        end_time = meetings[i][0]
        answer += 1

print(answer)
