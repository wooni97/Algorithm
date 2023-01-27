from collections import defaultdict


def solution(id_list, report, k):
    answer = [0] * len(id_list)
    
    # 주어지는 report 리스트를 중복 제거 해주는 것이 이 문제의 핵심이었다.
    # 이 한줄의 코드 없이 제출하면 수많은 시간초과를 만날 수 있다.
    report = set(report)
    
    user_list_who_i_report = defaultdict(set)
    num_of_reported = defaultdict(int)
    suspended = []

    for r in report:
        do_report, be_reported = r.split()
        
        num_of_reported[be_reported] += 1
        user_list_who_i_report[do_report].add(be_reported)
        
        if num_of_reported[be_reported] == k:
            suspended.append(be_reported)

    for s in suspended:
        for i in range(len(id_list)):
            if s in user_list_who_i_report[id_list[i]]:
                answer[i] += 1

    return answer

