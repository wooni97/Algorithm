def solution(cap, n, deliveries, pickups):
    answer = 0
    
    stack_deliveries = []
    stack_pickups = []
    
    for i in range(len(deliveries)) :
        if deliveries[i] != 0 :
            stack_deliveries.append([i+1,deliveries[i]])
        if pickups[i] != 0 :
            stack_pickups.append([i+1, pickups[i]])
    
    
    while stack_deliveries or stack_pickups :
        if len(stack_deliveries) > 0 and len(stack_pickups) == 0 :
            answer += stack_deliveries[-1][0] *2
        elif len(stack_deliveries) == 0 and len(stack_pickups) > 0 :
            answer += stack_pickups[-1][0] *2
        else :
            answer += max(stack_deliveries[-1][0] , stack_pickups[-1][0]) * 2
        
        deliver_cap = cap
        pickup_cap = cap
        
     
        while deliver_cap > 0 and stack_deliveries :
            
            if stack_deliveries[-1][1] <= deliver_cap :
                deliver_cap -= stack_deliveries[-1][1]
                stack_deliveries.pop()
            else :
                stack_deliveries[-1][1] -= deliver_cap
                deliver_cap = 0
               
                
      
        while pickup_cap > 0 and stack_pickups :
         
            if stack_pickups[-1][1] <= pickup_cap :
                pickup_cap -= stack_pickups[-1][1]
                stack_pickups.pop()
            else :
                stack_pickups[-1][1] -= pickup_cap
                pickup_cap = 0
                flag = False
        
        
                
        
    return answer