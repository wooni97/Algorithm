def DFS(n, k, i, j, board, group) :
    if 0 <= i < n and 0 <= j < n and board[i][j]  == k :
        group.append([i,j])
        board[i][j] = 1 - k
        DFS(n, k, i+1, j, board, group)
        DFS(n, k, i-1, j, board, group)
        DFS(n, k, i, j+1, board, group)
        DFS(n, k, i, j-1, board, group)
    else :
        return

def make_blocks(group, blocks) :
    min_x = min(group, key=lambda x:x[0])[0]
    min_y = min(group, key=lambda x:x[1])[1]
                
    for k in range(len(group)) :
        group[k][0] -= min_x
        group[k][1] -= min_y
                
    max_x = max(group, key=lambda x:x[0])[0] + 1
    max_y = max(group, key=lambda x:x[1])[1] + 1
                
    matrix = [[0] * max_y for _ in range(max_x)]
    
    for x,y in group :
        matrix[x][y] = 1
        
    blocks.append(matrix)

def rotate(block) :
    #print("rotate 안에 들어온 블럭: {}".format(block))
    n = len(block)
    m = len(block[0])
    
    rotate_block = [[0] * n for _ in range(m)]
    
    for i in range(n) :
        for j in range(m) :
            rotate_block[j][n-1-i] = block[i][j]
    
    #print("rotate 끝난 블럭: {}".format(rotate_block))
    return rotate_block
def solution(game_board, table):
    answer = 0
    
    n = len(table)
    blocks = []
    empty = []
    for i in range(n) :
        for j in range(n) :
            group = []
            if table[i][j] == 1 :
                DFS(n, 1, i, j, table, group)
                #print(group)
                make_blocks(group, blocks)
    #print(blocks)
    
    for i in range(n) :
        for j in range(n) :
            group = []
            if game_board[i][j] == 0 :
                DFS(n, 0, i, j, game_board, group)
                make_blocks(group, empty)
    print(empty)
    for block in blocks :
        block_x = len(block)
        block_y = len(block[0])
        for shape in empty :
            x = len(shape) 
            y = len(shape[0])
        
            if x*y == block_x*block_y :
                flag = False
                #print("블럭 : {}, 비어있는 틀 : {}".format(block, shape))
                for i in range(4) :
                    if shape == block :
                        #print("블럭 : {}, 비어있는 틀 : {} 이 같음".format(block, shape))
                        for b in block :
                            answer += b.count(1)
                        shape[0][0] = -1
                        #block[0][0] = -1
                        #print("블럭들 : {}".format(blocks))
                        flag = True
                        break
                    else :
                        #print("회전하려고 들어가는 블럭 : {}".format(block))
                        block = rotate(block)
                        #print("회전한 블럭 : {}".format(block))
                if flag :
                    break
            
            
        #print(x,y)
    return answer