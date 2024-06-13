import bisect

def find_number_in_one_list(l, number):
    for i in range(len(l)):
        idx = bisect.bisect_left(l, number - l[i])
        if idx < len(l) and l[idx] == number - l[i]:
            #print(l[i], l[idx])
            return [l[i], l[idx]]
    return []
    
def find_number_in_two_lists(l1, l2, number):
    for i in range(len(l1)):
        if number - l1[i] in l2:
            #print(l1[i], number - l1[i])
            return [l1[i], number - l1[i]]
    
    return []
    
def solution(coin, cards):
    answer = 0
    n = len(cards)
    
    # 카드 뭉치에서 뽑아야할 인덱스 번호
    idx = 0
    
    # 손에 남은 카드
    a = []
    # 현재 라운드까지 뽑은 카드 중 아직 가져오지 않은 카드
    b = []
    
    idx = len(cards) // 3
    a = cards[:idx]
    a.sort()
    
    while True:
        answer += 1
        if idx + 2 > len(cards):
            break
        
        b += cards[idx:idx+2]
        b.sort()
        idx += 2
      
        # 동전 0개 소모 
        result = find_number_in_one_list(a, n+1)
        if len(result) == 2:
            a.remove(result[0])
            a.remove(result[1])
            continue
        
        # 동전 1개 소모
        if coin - 1 < 0:
            break
            
        result = find_number_in_two_lists(a, b, n+1)
        if len(result) == 2:
            a.remove(result[0])
            b.remove(result[1])
            coin -= 1
            continue
        
        # 동전 2개 소모
        if coin - 2 < 0 :
            break
            
        result = find_number_in_one_list(b, n+1)
        if len(result) == 2:
            b.remove(result[0])
            b.remove(result[1])
            coin -= 2
            continue
        
        break
    
    return answer