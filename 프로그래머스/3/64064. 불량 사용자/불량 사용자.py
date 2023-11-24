def is_match(user_id, banned_id):
    # 불량 사용자에 해당하는지 체크하는 함수
    if len(user_id) != len(banned_id):
        return False
    for i in range(len(user_id)):
        if banned_id[i] != '*' and user_id[i] != banned_id[i]:
            return False
    return True

def dfs(index, user_ids, banned_ids, selected, result):
    if index == len(banned_ids):
        # 불량 사용자 목록에 모두 대응되는 경우
        result.add(tuple(sorted(selected)))
        return

    for i in range(len(user_ids)):
        if i not in selected and is_match(user_ids[i], banned_ids[index]):
            # 아직 선택되지 않은 사용자 아이디이고, 불량 사용자에 해당하는 경우
            selected.add(i)
            dfs(index + 1, user_ids, banned_ids, selected, result)
            selected.remove(i)

def solution(user_ids, banned_ids):
    result = set()  # 중복을 방지하기 위한 집합
    dfs(0, user_ids, banned_ids, set(), result)
    return len(result)
