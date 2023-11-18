def solution(n, k, cmd):
    answer = ['O'] * n  # 초기 상태는 모든 행이 삭제되지 않은 상태로 설정
    deleted_rows = []  # 삭제된 행의 인덱스를 저장하는 리스트
    current_row = k  # 현재 선택된 행의 인덱스

    # 연결 리스트를 이용하여 현재 선택된 행의 이전과 다음 행을 표현
    linked_list = {i: [i - 1, i + 1] for i in range(n)}
    linked_list[0][0] = None
    linked_list[n - 1][1] = None
    
    for command in cmd :
        if command[0] == "U" :
            x = int(command.split()[1])
            for _ in range(x) :
                current_row = linked_list[current_row][0]
                
        elif command[0] == "D" :
            x = int(command.split()[1])
            for _ in range(x) :
                current_row = linked_list[current_row][1]
                
        elif command[0] == "C" :
            deleted_rows.append(current_row)
            answer[current_row] = 'X'
            prev_row, next_row = linked_list[current_row]
            
            if prev_row is not None :
                linked_list[prev_row][1] = next_row
                
            if next_row is not None :
                linked_list[next_row][0] = prev_row
            
            if next_row is not None :
                current_row = next_row
            else :
                current_row = prev_row
            
        elif command[0] == "Z" :
            deleted_row = deleted_rows.pop()
            
            prev_row, next_row = linked_list[deleted_row]
            
            if prev_row is not None :
                linked_list[prev_row][1] = deleted_row
            if next_row is not None :
                linked_list[next_row][0] = deleted_row
            
            answer[deleted_row] = 'O'
            
    return ''.join(answer)