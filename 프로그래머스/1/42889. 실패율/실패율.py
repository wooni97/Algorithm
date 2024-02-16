
def solution(N, stages):
    answer = {}

    total_players = len(stages)

    for i in range(1, N+1):
        challengers = stages.count(i)
        if total_players == 0:
            answer[i] = 0
            continue
        
        answer[i] = challengers / total_players

        total_players -= challengers

    return sorted(answer, key=answer.get, reverse=True)