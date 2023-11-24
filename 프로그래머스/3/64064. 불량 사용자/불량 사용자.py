
def is_match(user_id_element, banned_id_element):
    if len(user_id_element) != len(banned_id_element):
        return False

    for i in range(len(user_id_element)):
        if banned_id_element[i] == "*":
            continue
        else :
            if banned_id_element[i] != user_id_element[i]:
                return False

    return True
def dfs(index, user_id, banned_id, ids, result) :
    if index == len(banned_id):
        result.add(tuple(sorted(ids)))
        return

    for i in range(len(user_id)):
        if i not in ids and is_match(user_id[i], banned_id[index]):
            ids.add(i)
            dfs(index+1, user_id, banned_id, ids, result)
            ids.remove(i)

def solution(user_id, banned_id):
   result = set()
   ids = set()
   dfs(0, user_id, banned_id, ids, result)
   return len(result)

if __name__ == '__main__':
    user_id = ["frodo", "fradi", "crodo", "abc123", "frodoc"]
    banned_id = ["fr*d*", "abc1**"]

    user_id2 = ["frodo", "fradi", "crodo", "abc123", "frodoc"]
    banned_id2 = ["*rodo", "*rodo", "******"]

    user_id3 = ["frodo", "fradi", "crodo", "abc123", "frodoc"]
    banned_id3 = ["fr*d*", "*rodo", "******", "******"]

    print(solution(user_id, banned_id))
    print(solution(user_id2, banned_id2))
    print(solution(user_id3, banned_id3))
