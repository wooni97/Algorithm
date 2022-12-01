from collections import deque
def solution(queue1, queue2):
    q1, q2 = deque(queue1), deque(queue2)
    answer = 0
    s1, s2 = sum(queue1), sum(queue2)
    same = (s1 + s2) // 2
    max_count = len(q1) * 3
    if (s1 + s2) % 2 == 1 :
        return -1

    while True :
        if s1 <= 0 or s2 <= 0 :
            answer = -1
            break

        if s1 == same :
            break

        if s1 > s2 :
            i = q1.popleft()
            q2.append(i)
            s1 -= i
            s2 += i
            answer += 1
        else :
            i = q2.popleft()
            q1.append(i)
            s2 -= i
            s1 += i
            answer += 1

        if answer == max_count:
            return -1
    return answer