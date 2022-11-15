def solution(triangle):
    answer = 0
    n = len(triangle) 
    
    for i in range(1 , n ):
        for j in range(0, n - i):
            if(j == 0):
                triangle[n-i-1][j] = triangle[n-i-1][j] + max(triangle[n-i][0],triangle[n-i][1])
            elif(i != j and j !=0):
                triangle[n-i-1][j] = triangle[n-i-1][j] + max(triangle[n-i][j],triangle[n-i][j+1]) 
            elif(i == j):
                triangle[n-i-1][j] = triangle[n-i-1][j] + max(triangle[n-i][j],triangle[n-i][j+1])
       
    return triangle[0][0]# + max(triangle[1][0], triangle[1][1])