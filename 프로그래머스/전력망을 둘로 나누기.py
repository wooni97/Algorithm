def solution(n, wires):
    answer = []
    
    tree = [[0]*(n+1) for _ in range(n+1)]
    
    for wire in wires :
        tree[wire[0]][wire[1]] = 1
        tree[wire[1]][wire[0]] = 1
    
    #print(tree)
    
    for wire in wires :
        tree[wire[0]][wire[1]] = 0
        tree[wire[1]][wire[0]] = 0
        
        blank = [1]
        cnt = 1
        visited = [False] * (n+1)
        visited[1] = True
        while blank :
            top = blank.pop()
            for i in range(1,n+1) :
                if tree[top][i] == 1 and visited[i] == False :
                    visited[i] = True
                    blank.append(i)
                    cnt += 1
                    
        answer.append(abs(cnt-(n-cnt)))
        
        tree[wire[0]][wire[1]] = 1
        tree[wire[1]][wire[0]] = 1
    
    
    return sorted(answer)[0]