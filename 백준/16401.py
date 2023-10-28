def can_distribute(gift_lengths, M, max_length):
    # max_length 길이로 과자를 잘라서 M명의 조카에게 나눠줄 수 있는지 확인하는 함수
    total_pieces = 0
    for length in gift_lengths:
        total_pieces += length // max_length

    return total_pieces >= M


def find_max_gift_length(M, N, gift_lengths):
    gift_lengths.sort()  # 과자 길이를 정렬
    left, right = 1, gift_lengths[-1]  # 이진 탐색 범위 설정 (1부터 가장 긴 과자의 길이까지)
    result = 0

    while left <= right:
        mid = (left + right) // 2  # 중간 길이 계산
        if can_distribute(gift_lengths, M, mid):
            result = mid
            left = mid + 1  # 더 큰 길이로 시도
        else:
            right = mid - 1  # 더 작은 길이로 시도

    return result


# 입력 받기
M, N = map(int, input().split())
gift_lengths = list(map(int, input().split()))

# 최대 길이 구하기
print(find_max_gift_length(M, N, gift_lengths))